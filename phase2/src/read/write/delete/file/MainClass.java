package read.write.delete.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;



public class MainClass {

	/**
	 * @param args
	 */
	static FileOperations fileOperations = new FileOperations();
	static DisplayOptions options = new DisplayOptions();
	public static void main(String[] args) {
		
		Scanner filescan = new Scanner(System.in);
		DisplayMainMenu menu = new DisplayMainMenu();
		options.welcomeString();
		boolean condition = true;
while(condition)
{
	Scanner scan = new Scanner(System.in);
	options.displayMainOptions();
	String i = scan.next();
	
		switch(i)
		{
		case "1":
			condition = true;
			fileOperations.displayListOfFiles();
			break;
		case "2":
			condition = true;
			boolean showSubMenu = true;
			while(showSubMenu)
			{
				menu.displayAvailableOptions();
				String option = filescan.next();
				
			switch(option)
			{
			case "1":
				options.enterFileText();
				String fileName = filescan.next();
				insertfile(fileName);
				options.fileContent();
				insertContent(fileName);
				break;
			case "3":
				options.searchFile();
				String fileNameToSearch = filescan.next();
				fileOperations.searchFile(fileNameToSearch);
				condition = true;
				break;
			case "2":
				options.deleteFile();
				String fileNameToDel = filescan.next();
				fileOperations.deleteFile(fileNameToDel);
				break;
			case "4":
				showSubMenu = false;
				break;
				
			 default:
				 options.inValidOtion();
			     break;
			}
		}
			break;
		case "3":
			condition = false;
			options.exitApplications();
			break;
	    default:
	    	condition = true;
	    	options.inValidOtion();
	    	break;
		}
}
		
	}

	private static void insertContent(String fileName) {
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String content = input.readLine();
			fileOperations.insertContentInToFile(fileName, content);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}

	private static void insertfile(String fileName) {
		try {
			boolean result = fileOperations.insertFile(fileName);
			if(result)
			{
			options.successFile();	
			}
			else
			{
			options.fileFailure();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
