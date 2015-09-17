package ru.letoapp.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertyReader {

    private static Properties props = new Properties();

    public static void init(String file) throws AssertionError{
        try {
        	 InputStreamReader isr = new InputStreamReader(new FileInputStream("src/main/resources/" + file), "UTF-8");
        	 props.load(isr);
        	} catch (Exception e) {
            try {
            	 props.load(props.getClass().getResourceAsStream(file));            
            } catch (FileNotFoundException e1) {
                throw new AssertionError("File with locator's information not found: " + e.toString());
            } catch (IOException e1) {
                throw new AssertionError("IO error while trying to reach locator's information file: " + e.toString());
            }
        }
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }


}
