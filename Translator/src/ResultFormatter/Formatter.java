package ResultFormatter;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Map.Entry;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class Formatter {
	public static void main(String[] args) {
		System.out.println("Good morning world");
		connectNeo4J("D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\graph.db");
		connectPostgres();
	}
	
	private static void connectNeo4J(String neo4jDBPath) {
		GraphDatabaseService neo4jConnection = new GraphDatabaseFactory().newEmbeddedDatabase(new File(neo4jDBPath));
		Result result = neo4jConnection.execute("MATCH (n) RETURN labels(n), count(*)");
		System.out.println(result.resultAsString());
//		while (result.hasNext()) {
//			Map<String, Object> row = result.next();
//			for (Entry<String, Object> column: row.entrySet()) {
//				System.out.print(column.getKey() + ": " + column.getValue() + "; ");
//			}
//			System.out.println();
// 		}
		neo4jConnection.shutdown();
	}
	
	private static void connectPostgres() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/graph", "postgres", "admin");
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}