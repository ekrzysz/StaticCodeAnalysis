
import javax.swing.JFileChooser;

//
public class OpenFolder{
	
	//opens folder GUI where user is prompted to select folder they wish
	//to clone repo to
	public String openWindowsExplorer(){
		JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new java.io.File("C:/"));
	    chooser.setDialogTitle("choosertitle");
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);

	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	      return chooser.getSelectedFile().toString();
	    } else {
	      System.out.println("No Selection ");
	      return "false";
	    }
		
	}

}