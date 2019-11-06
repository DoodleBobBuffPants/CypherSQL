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
			row.forEach((k, v) -> newElement.put(k, formatNeo4JValue(v)));
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
					newElement.put(result.getMetaData().getColumnName(i), formatPostgresValue(result.getObject(i)));
				}
				postgresResult.add(newElement);
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private String formatNeo4JValue(Object value) {
		if (value instanceof Object[]) {
			String result = "]";
			for (int i = 0; i < ((Object[]) value).length; i++) {
				result = "," + ((Object[]) value)[i].toString().toLowerCase() + result;
			}
			return "[" + result.substring(1, result.length());
		} else {
			return value.toString().toLowerCase();
		}
	}
	
	private String formatPostgresValue(Object value) {
		return value.toString().replace("{", "[").replace("}", "]")
							   .replace("\\\"", "<3").replace("\"", "").replace("<3", "\\\"").toLowerCase();
	}
	
	public boolean compare() {
		if (neo4jResult.size() != postgresResult.size()) return false;
		for (Map<String, String> neoRow: neo4jResult) {
			if (!postgresResult.contains(neoRow)) return false;
		}
		return true;
	}
	
	public void printPostgresResult() {
		for (Map<String, String> row: postgresResult) {
			row.forEach((k, v) -> System.out.print(k + " - " + v + " ; "));
			System.out.println();
		}
	}
}