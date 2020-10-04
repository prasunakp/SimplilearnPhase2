package read.write.delete.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileOperations {
	
	public void displayListOfFiles()
	{
		File folder = new File("listofFiles");
		File[] listOfFiles = folder.listFiles();
		List<String> fileNames = new ArrayList<String>();
		for(int i=0;i<listOfFiles.length;i++)
		{
			if(listOfFiles[i].isFile())
			{
				fileNames.add(listOfFiles[i].getName());
			}
		}
		Arrays.sort(listOfFiles);
		for(int i =0 ; i<listOfFiles.length;i++)
		{
			System.out.println(listOfFiles[i].getName());
		}
	
	}
	
	public void searchFile(String fileName)
	{
		boolean fileFound = false;
		File folder = new File("listofFiles");
		File[] listOfFiles = folder.listFiles();
        for(int i =0; i<listOfFiles.length;i++)
        {
        	if(listOfFiles[i].getName().equalsIgnoreCase(fileName))
        	{
        		System.out.println("file "+fileName+" found ");
        		fileFound = true;
        		break;
        	}
        }
        if(!fileFound)
        {
        	System.out.println("Entered file is not found");
        }
	}
	
	public boolean insertFile(String fileName) throws IOException
	{
		File file  = new File("listofFiles\\"+fileName);
		
		boolean result = file.createNewFile();
		
		return result;
	}
	
	public void insertContentInToFile(String fileName, String content) throws IOException
	{
		FileOutputStream fileInput = new FileOutputStream("listofFiles\\"+fileName);
		BufferedOutputStream bos = new BufferedOutputStream(fileInput);
		byte b[]=content.getBytes();
		bos.write(b);	
	
		bos.flush();
		bos.close();
		fileInput.close();
		
		System.out.println("Content written in to the file succesfully.");
	}
	
	public void deleteFile(String fileName)
	{
		File file  = new File("listofFiles\\"+fileName);
		
		if(file.delete())
		{
			System.out.println("file deleted succesfully "+fileName);
		}
		else
		{
			System.out.println("Sorry there is no file with file name "+fileName);
		}
	}

}
