package com.calc.utils;

public class CollectionUtils {
	


	
	
	public static String printCol(Object[] objs) {
		
		StringBuilder sb = new StringBuilder();
		for (Object obj : objs) {
			sb.append(obj.toString()).append(System.lineSeparator());
		}
		return sb.toString();
	}
	
	
	public static Object[] deleteNulls(Object[] col) {
		int cont=0;
		if (col!=null) {
			for (Object o : col) {
				cont += o !=null ? 1: 0;
				}
			}
		Object[] col2 = new Object[cont];
		
		cont=0;
		for (Object o : col) {
			if (o!=null){
				col2[cont++]=o;
			}
		}
		return col2;
	}
	
}
