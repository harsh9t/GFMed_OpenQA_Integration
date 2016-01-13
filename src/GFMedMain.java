import java.util.Scanner;

import org.aksw.openqa.AnswerFormulation;
import org.aksw.openqa.main.QueryResult;
import org.aksw.openqa.manager.plugin.PluginManager;


public class GFMedMain {
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String filename = "qald-4_biomedical_train.xml";
		String answer = "";
		if(args.length > 0)
			filename  = args[0];
		
		System.out.println("Please enter the file name:\t");
		Scanner input = new Scanner(System.in);
		filename = input.next();
    	GFMedQueryParser interpreter = new GFMedQueryParser();
    	
    	
    	PluginManager pluginManager = new PluginManager();
    	pluginManager.register(interpreter);
    	
    	pluginManager.setActive(true, interpreter.getId());
    	
    	
    	AnswerFormulation queryProcessor = new AnswerFormulation(pluginManager);
    	
    	QueryResult result;
		result = queryProcessor.process(filename);
		
		/*List<? extends IResultMap> output = result.getOutput();
		
		if(output.size() > 0) {
			answer = output.get(0).getParam(Properties.Literal.TEXT, String.class);
		}
		
		System.out.println("openQA:\t" + result.getParam(Properties.Literal.TEXT));
		*/
	}
}
