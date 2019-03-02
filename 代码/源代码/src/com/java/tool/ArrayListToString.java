package com.java.tool;

import java.util.ArrayList;

public class ArrayListToString {
	public static String[] arrayListToString(ArrayList<String> list){
		 ArrayList<String> carType = list;
	        int size=carType.size();  
	        String[] cararray=new String[size];  
	        for(int i=0;i<carType.size();i++){  
	            cararray[i]=carType.get(i);  
	        } 
	       // cararray[carType.size()] = "Ìí¼Ó...";
	        return cararray;
	}
}
