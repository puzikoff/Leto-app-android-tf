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
	
	public static String getCodeFromFile (String codeType, String env) throws IOException{
		String otp = null;
		String otp2 = null;
		String filePath = "";
		if(env.equals("sb")) {
			if(codeType.equals("sms")) {			
				filePath = "\\\\VM-LETO-SB\\LOGS\\AM\\message_log.txt";
				
			}
			if(codeType.equals("vk")) {			
				filePath = "\\\\VM-LETO-SB\\LOGS\\AM\\message_log.txt";
			}
		}
		if(env.equals("mtest")) {
			if(codeType.equals("sms")) {			
				filePath = "\\\\VM-LETO-MTEST\\c$\\LOGS\\AM\\message_log.txt";
			}
			if(codeType.equals("vk")) {			
				filePath = "\\\\VM-LETO-MTEST\\c$\\LOGS\\AM\\message_log.txt";
			}
		}
		File file = new File(filePath);
	    BufferedReader br = new BufferedReader (new InputStreamReader(new FileInputStream( file ), "UTF-8"));
	    while((otp = br.readLine()) != null) {	    	
	    	otp2 = otp;	    
	    }	    
	    br.close();		    
	    Pattern p = Pattern.compile("[0-9]{4,4}");
	    Matcher m = p.matcher(otp2);	    
	    m.find();	   
	    otp2 = m.group(0);     
		return otp2;
	}
}
