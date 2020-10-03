package read.write.delete.file;

public class DisplayOptions {
	
	public void welcomeString()
	{
		System.out.println(ConstantsFile.WELCOME_STRING);
	}
	
	public void displayMainOptions()
	{
		System.out.println(ConstantsFile.LIST_OPTIONS);
	}
	
	public void inValidOtion()
	{
		System.out.println(ConstantsFile.INVALID_OPTION);
	}

	public void exitApplications()
	{
		System.out.println(ConstantsFile.EXIT_APPLICATION);
	}
	
	public void enterFileText()
	{
		System.out.println(ConstantsFile.ENTER_FILE_TEXT);
	}
	
	public void searchFile()
	{
		System.out.println(ConstantsFile.SEARCH_FILE);
	}
	
	public void successFile()
	{
		System.out.println(ConstantsFile.FILE_SUCCESS);
	}
	
	public void fileFailure()
	{
		System.out.println(ConstantsFile.FILE_FAILURE);
	}
	
	public void fileContent()
	{
		System.out.println(ConstantsFile.FILE_CONTENT);
	}
	
	public void deleteFile()
	{
		System.out.println(ConstantsFile.DELETE_FILE);
	}
}
