package sait.parser.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import sait.parser.models.XMLTag;

/**
 * The XML parser is a simple parser that read a XML file from physical hardriver
 * Parse for errors in the XML construction and print all lines that are not properly 
 * constructed in the order in which the errors occur
 */
public class XMLparser 
{
	/** 
	* The main method 
	* @param args - 
	* @throws FileNotFoundException - if the file doesn't exist
	*/
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		boolean isContinue = true;
		String input = null;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Do you want to start the XML Parser now: Type Y for contiue, Q to exit");
		
		while(isContinue) 
		{
			input = scan.next();
			
			if(input.toLowerCase().equals("y")) {
				System.out.println("Please enter the XML file path: ");
				
				Scanner incmd = new Scanner(System.in);
				File newFile = new File(incmd.nextLine());
				
				if (!newFile.exists()) {
				    System.out.println("XML file does not exists");		      
				    System.exit(0);
				}else 
				{
					Scanner inputXML = new Scanner( newFile );
					int line = 0;
					while( inputXML.hasNextLine() ) 
					{
						String strXML = inputXML.nextLine();
						ReadXml(strXML,line+1);
						line++;
					}
					inputXML.close();
				}

				incmd.close();
				isContinue = false;
			}else if(input.toLowerCase().equals("q")) {
				isContinue = false;
				System.out.println("Thanks for using!");
			}else
			{
				System.out.println("Do you want to start the XML Parser now: Type Y for contiue, Q to exit");
			}
		}
			
		scan.close();
	}
	
	/** 
	* Read and parse the XML file 
	* @param strInput - the line reading from XML file
	* @param line - the line number 
	*/
	
	public static void ReadXml(String strInput,int line)
	{
		char[] ch = strInput.toCharArray();
		int size = strInput.length();
		int pos = 0;
		
		for( int i = 0; i < size; i++ )
		{
			if( ch[i] == '<') 
			{
				for( int j = i+1; j < ch.length; j++) 
				{
					if( ch[j] == '>' ) 
					{
						String tagName = null;
						
						if( strInput.indexOf(' ', i) == -1 || strInput.indexOf(' ', i) > strInput.indexOf('>', i) ) 
						{							
							tagName = strInput.substring(i, j+1);
						}
						else 
						{
							if( ch[j-1] == '/' ) {
								tagName = strInput.substring(i, strInput.indexOf(' ', i))+ch[j-1]+ch[j];
							}else {
								tagName = strInput.substring(i, strInput.indexOf(' ', i))+ch[j];
							}
						}
						
						AddTag(tagName,line);
						pos = j;
						break;
					}
				}
			}
			
			if( ch[i] == '>' ) 
			{
				if( i != pos ) 
				{
					String tag = null;
					if( ch[i-1] == '/') 
					{
						tag = strInput.substring(i-1,i+1);
						AddTag(tag,line);
					}else {
						tag = strInput.substring(i,i+1);
						AddTag(tag,line);
					}
				}
			}
		}
	}
	
	/** 
	* Add XML Tag into database(AraayList) 
	* @param strTag - input XML Tag
	* @param line - the line number
	*/
	
	public static void AddTag(String strTag, int line) 
	{
		ArrayList<XMLTag> tagList = new ArrayList<XMLTag>();
		String tagType = null;
		String tagName = null;
		
		if( strTag.matches("<[a-zA-Z]+.*?>") ) {
			tagType = "Start_Tag";
			tagName = strTag.substring(1,strTag.length()-1);
		}
		if( strTag.matches("</[a-zA-Z]+.*?>") ) {
			tagType = "End_Tag";
			tagName = strTag.substring(2,strTag.length()-1);
		}
		if(strTag.matches("<[^>]+\\/>")) {
			tagType = "Self_Closing_Tag";
			tagName = strTag.substring(1,strTag.length()-2);
		}		
		if( strTag.equals(">")  || strTag.equals("/>")) {
			tagType = "End_Tag";
			tagName = strTag;
		}
		
		XMLTag xtag = new XMLTag( tagName, line, tagType);
		if(strTag.equals("<?xml>")) { return; }
		tagList.add(xtag);
		
		//test successful
		//E:\Study\SAIT\Winter 2022 - CPRG311\Assignments\Assignment2\XMLParserSampleFiles\sample2.xml
		//E:\Study\SAIT\Winter 2022 - CPRG311\Assignments\Assignment2\XMLParserSampleFiles\sample1.xml
		for( int k = 0; k < tagList.size(); k++ ) 
		{
			System.out.println(tagList.get(k).getTagName()+" "+tagList.get(k).getTagType()+" "+tagList.get(k).getLineNum());
		}
	}

}
