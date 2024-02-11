/*
 * Program Name: CountTheKeywords.java
 * Author: Julian Fuentes
 * Date Last Updated: 11 February 2024
 * Purpose: This program will count the keywords.
 */

import java.util.*;
import java.io.*;

public class CountTheKeywords 
{
	public static void main(String[] args) throws Exception
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a Java source file: ");
		String filename = scan.nextLine();
		
		File file = new File(filename);
		if (file.exists()) 
		{
			System.out.println("The number of keywords " + filename
					+ " is " + countKeywords(file));
		}
		else 
		{
			System.out.println("File " + filename
					+ " does not exist");
		}
		//This should check to see if the file exists.
	}
		
	public static int countKeywords(File file) throws Exception
	{
		String[] keywordString = 
			{
				"abstract", "assert",
				"boolean", "break", "byte",
				"case", "catch", "char", "class", "const", "continue",
				"default", "do", "double",
				"else", "enum", "extends",
				"for", "final", "finally", "float",
				"goto",
				"if", "implements", "import", "instanceof", "int", "interface",
				"long",
				"native", "new",
				"package", "private", "protected", "public",
				"return",
				"short", "static", "strictfp", "super", "switch", "synchronized",
				"this", "throw", "throws", "transient", "try",
				"void", "volatile",
				"while", "true", "false", "null"
			};
		Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
		int count = 0;
		
		Scanner scan = new Scanner(file);
		
		while (scan.hasNext()) 
		{
			String word = scan.next();
			if (word.contains("//")) 
			{
				scan.nextLine();
			}
			//This should not allow comments to be counted.
			else if (word.contains("\"")) 
			{
				String nextWord;
				do 
				{
					nextWord = scan.next();
				}
				while (!nextWord.contains("\""));
			}
			//This should not allow strings to be counted.
			else if (word.contains("/*")) 
			{
				String nextWord;
				do 
				{
					nextWord = scan.next();
				}
				while (!nextWord.contains("*/"));
			}
			//This should not allow block comments to be counted.
			else if (keywordSet.contains(word))
				count++;
			
				
		}
		scan.close();
		return count;
		
	}
}
