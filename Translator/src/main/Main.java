package main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Main {
	
	public static void main (String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		
		PrintWriter writer = new PrintWriter("emptyClass.java", "UTF-8");
		writer.println("public class emptyClass{");
		writer.println("public static void main (String[] args){");
		writer.println("System.out.println(\"Look at me, I'm Incepting!\");");
		writer.println("}");
		writer.println("}");
		writer.close();
	}
	
	//TODO: EVERYTHING

}
