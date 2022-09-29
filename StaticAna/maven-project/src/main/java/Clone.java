import java.nio.file.Paths;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

//clone repo
public class Clone {
	
	//takes in two arguments input (link from textbox) and folderpath 
	//from folder button that user selected and clones repo to folderpath
	public boolean cloner(String input, String folderPath) { 
		
		try {
		    Git.cloneRepository()
		        .setURI(input)
		        .setDirectory(Paths.get(folderPath).toFile())
		        .call();
		    System.out.println("Completed Cloning");
		    return true;
		} catch (GitAPIException e) {
		    System.out.println("Exception occurred while cloning repo");
		    e.printStackTrace();
		    return false;
		}
	}
	
}
