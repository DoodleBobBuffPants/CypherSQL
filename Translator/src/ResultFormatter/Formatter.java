package ResultFormatter;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

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
		long startTime = System.currentTimeMillis();
		Result result = neo4jConnection.execute(query);
		System.out.println("Neo4J execution time: " + (System.currentTimeMillis() - startTime));
		while (result.hasNext()) {
			neo4jResult.add(result.next().entrySet().stream().collect(Collectors.toMap(Entry::getKey, e -> formatNeo4JValue(e.getValue()))));
		}
		neo4jConnection.shutdown();
	}
	
	public void getPostgresResult(String dbName, String query) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, "postgres", "admin");
			Statement statement = connection.createStatement();
			long startTime = System.currentTimeMillis();
			ResultSet result = statement.executeQuery(query);
			System.out.println("Postgres execution time: " + (System.currentTimeMillis() - startTime));
			while(result.next()) {
				Map<String, String> newElement = new HashMap<String, String>();
				ResultSetMetaData resultMetaData = result.getMetaData();
				for (int i = 1; i <= resultMetaData.getColumnCount(); i++) {
					newElement.put(resultMetaData.getColumnName(i), formatPostgresValue(result.getObject(i)));
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
	
	public void printNeo4JResult() {
		for (Map<String, String> row: neo4jResult) {
			row.forEach((k, v) -> System.out.print(k + " - " + v + " ; "));
			System.out.println();
		}
	}
	
	public void printPostgresResult() {
		for (Map<String, String> row: postgresResult) {
			row.forEach((k, v) -> System.out.print(k + " - " + v + " ; "));
			System.out.println();
		}
	}
}