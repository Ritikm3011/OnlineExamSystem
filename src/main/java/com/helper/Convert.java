package com.helper;

public class Convert {
	public static double getDouble(String value) {
		double f = 0.0;
		if(value == null || value.isEmpty()) {
			return f;
		} 
		try {
			return Double.parseDouble(value);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid number format for parameter with value: " + value);
		}
		return f;
		
	}

}
