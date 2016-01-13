


import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.aksw.openqa.Properties;
import org.aksw.openqa.component.answerformulation.AbstractQueryParser;
import org.aksw.openqa.component.context.IContext;
import org.aksw.openqa.component.param.IParamMap;
import org.aksw.openqa.component.param.IResultMap;
import org.aksw.openqa.component.param.ResultMap;
import org.aksw.openqa.component.providers.impl.ServiceProvider;


public class GFMedQueryParser extends AbstractQueryParser {
	
	String[][] allwedQuestions= {
			// standard greetings
			{"hi", "hello", "hola", "ola", "howdy"},
			// question greetings
			{"how are you", "how r you", "how r u", "how are u"}
	};
	
	public GFMedQueryParser() {
		super(null /* there is no params to be passed */);
	}

	public GFMedQueryParser(Map<String, Object> params) {
		super(params);
	}
	
	@Override
	public String getVersion() {
		return "sample2"; // version
	}
	
	@Override
	public String getLabel() {
		return "HelloWorldInterpreter"; // the label
	}
	
	@Override
	public String getId() {
		return getLabel() + " " + getVersion(); // id = label + version
	}
	
	@Override
	public boolean canProcess(IParamMap param) {
		return param.contains(Properties.Literal.TEXT, String.class);
	}

	@Override
	public List<? extends IResultMap> process(IParamMap param,
			ServiceProvider services, IContext context) throws Exception {
		
		String input = param.getParam(Properties.Literal.TEXT, String.class);
		String output = "abc.txt";
		System.setOut(new PrintStream(new FileOutputStream(output)));
		//The main class to get SPARQL outputs 
		Quest.main(new String[] { output, input });
		System.setOut(System.out);
		List<IResultMap> results = new ArrayList<>();
		ResultMap result = new ResultMap();
	    //result.setParam(Properties.Literal.TEXT, response);
		results.add(result);
		
		return results; // since we already consume the parameter, return null
	}
	
	


	 


}
