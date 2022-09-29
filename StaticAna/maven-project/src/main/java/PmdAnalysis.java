import net.sourceforge.pmd.PMD;
import net.sourceforge.pmd.PMDConfiguration;


public class PmdAnalysis{
	
	//takes in directory path of cloned repo as string and applies 
	//pmd programmatically with the following rule sets. Sets location 
	//of XML file inside cloned directory and returns directory to user
	//to fine results faster
	
	//Note: that more rule sets can be added if desired
	public String makePmd(String directoryPath) {
		
	
	PMDConfiguration configuration = new PMDConfiguration();
    
    configuration.setInputPaths(directoryPath);
    
    //can add additional rule sets
    configuration.addRuleSet("rulesets/java/quickstart.xml");
    configuration.addRuleSet("rulesets/java/basic.xml");
    
    
    configuration.setReportFormat("xml");
    configuration.setReportFile(directoryPath + "\\" +"pmdResults.xml");
    		
    PMD.runPmd(configuration);
    return directoryPath + "\\" +"pmdResults.xml";
    
	}
	
}