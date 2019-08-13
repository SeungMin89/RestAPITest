package com.simplify.sample.mapper;

import java.util.HashMap;
import java.util.Map;

public interface TestMapper2 {

	public static Map<String, String> getBoard() throws Exception{
		Map<String, String> test = new HashMap<String, String>();
		
		test.put("1", "Test1");
		test.put("2", "Test2");
		test.put("3", "Test3");
		test.put("4", "Te2123st4");
		
		
		return test;
	}
}
