package ru.letoapp.utilities;

import java.util.Random;

public class TestsHelper {
	public final static Random random = new Random();	
	
	public static String generateString(String characters, int length)
	{		
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(random.nextInt(characters.length()));
	    }
	    return new String(text);
	}

}
