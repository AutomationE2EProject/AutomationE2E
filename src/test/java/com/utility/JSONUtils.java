package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.json.Json;

import com.constants.Env;
import com.google.gson.Gson;
import com.uo.pojo.Config;
import com.uo.pojo.Environment;

public class JSONUtils {
	public static Environment getJSONValue(Env env)  {
		Gson gson = new Gson();
		File file = new File(System.getProperty("user.dir")+"\\config\\config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Config config = gson.fromJson(fileReader, Config.class);
		Environment environment=null;
//		if(env.equals("QA")) {
		environment = config.getEnvironments().get("QA");
//		}
		return environment;
	}
	
	
}
