package ResultFormatter;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class Formatter {
	private Set<Map<String, String>> neo4jResult;
	private Set<Map<String, String>> postgresResult;
	
	public static void main(String[] args) {
		Formatter formatter = new Formatter();
		formatter.initialiseResultSets();
		String neo4jQuery = "MATCH (n) RETURN labels(n) AS label, count(*) AS count";
		formatter.getNeo4JResult("D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\graph.db", neo4jQuery);
		String postgresQuery = "SELECT relname AS label, n_live_tup AS count "
				+ "FROM pg_stat_user_tables t "
				+ "INNER JOIN information_schema.columns c ON c.table_name = t.relname "
				+ "WHERE c.column_name = 'nodeid' "
				+ "AND t.relname <> 'nodes'";
		formatter.getPostgresResult("graph", postgresQuery);
		System.out.println(formatter.compare());
	}
	
	public void initialiseResultSets() {
		neo4jResult =  new HashSet<Map<String, String>>();
		postgresResult =  new HashSet<Map<String, String>>();
	}
	
	public void getNeo4JResult(String neo4jDBPath, String query) {
		GraphDatabaseService neo4jConnection = new GraphDatabaseFactory().newEmbeddedDatabase(new File(neo4jDBPath));
		Result result = neo4jConnection.execute(query);
		while (result.hasNext()) {
			Map<String, Object> row = result.next();
			Map<String, String> newElement = new HashMap<String, String>();
			row.forEach((k, v) -> newElement.put(k, v.toString().replace("[", "").replace("]", "").toLowerCase()));
			neo4jResult.add(newElement);
		}
		neo4jConnection.shutdown();
	}
	
	public void getPostgresResult(String dbName, String query) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, "postgres", "admin");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				Map<String, String> newElement = new HashMap<String, String>();
				for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
					newElement.put(result.getMetaData().getColumnName(i), result.getObject(i).toString().toLowerCase());
				}
				postgresResult.add(newElement);
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public boolean compare() {
		if (neo4jResult.size() != postgresResult.size()) return false;
		for (Map<String, String> neoRow: neo4jResult) {
			if (!postgresResult.contains(neoRow)) return false;
		}
		return true;
	}
}