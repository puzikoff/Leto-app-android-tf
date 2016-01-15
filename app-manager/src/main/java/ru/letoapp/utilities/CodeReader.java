package ru.letoapp.utilities;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class CodeReader {
	public static final Logger Log = Logger.getLogger(CodeReader.class);
	
	public static String getCodeFromFile (String codeType) throws IOException{
		String otp = null;				
		if(PropertyReader.getProperty("smsFromFile").equals("true")) {			
			File file = new File(PropertyReader.getProperty("smsCodePath"));
			BufferedReader br = new BufferedReader (new InputStreamReader(new FileInputStream( file ), "UTF-8"));
			while(br.readLine() != null) {	    	
				otp = br.readLine();	    
			}	    
			br.close();		    
			Pattern p = Pattern.compile("[0-9]{" + PropertyReader.getProperty("codeMask") + "," + PropertyReader.getProperty("codeMask") + "}");
			Matcher m = p.matcher(otp);	    
			m.find();	   
			otp = m.group(0);
		}
		if(PropertyReader.getProperty("smsFromFile").equals("false")) {
			otp = PropertyReader.getProperty("SmsCode");			
		}
		Log.info(otp);
		return otp;
	}
}
