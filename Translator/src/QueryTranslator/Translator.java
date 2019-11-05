package QueryTranslator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Translator {
	private String query;
	
	public static void main(String[] args) {
		System.out.println("Good morning world");
	}
	
	public Translator(String query) {
		this.query = query;
	}
	
	public Translator(Path queryPath) {
		try {
			this.query = new String(Files.readAllBytes(queryPath));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void translate() {
		System.out.println(query);
	}
}