package FrameWork.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class orderinput {
	
	public List<HashMap<String, String>> getjsondata() throws IOException
	{
		
		String jsoncontent =FileUtils.readFileToString(new File("C:\\Users\\madhukar.v\\eclipse-workspace\\New\\Selenium\\src\\test\\java\\FrameWork\\data\\Input.json"));
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>(){});
		
		return data;
	}

}
