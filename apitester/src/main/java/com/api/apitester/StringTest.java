package com.api.apitester;

import java.util.HashMap;
import java.util.Map;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mainstr = "key1,value1;key2,value2";
		Map<String, String> headersMap = new HashMap<String, String>();
		
		
		
		String[] substr = mainstr.split(";");	
		 for(int i = 0;i<substr.length;i++)
		 {
			 System.out.println("Print : "+substr[i].toString());
			 String[] subsubstring = substr[i].split(",");
			 headersMap.put(subsubstring[0], subsubstring[1]);
			 
		 }
		 
		 System.out.println(headersMap);
}
}
