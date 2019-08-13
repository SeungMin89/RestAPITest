package com.simplify.sample.service.aaa;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.StaticApplicationContext;

import com.simplify.sample.mapper.TestMapper2;

public class TempService {

	/*
	 * @Autowired static TestMapper2 testMapper2;
	 */
	
	public static Map<String, String> Test1() {
		Map<String, String> board = new HashMap<String, String>();
		String aaa = "Test";
    	
    	
    	String bbb = "  12313OK?";
    	
    	try {
			board = TestMapper2.getBoard();
			
//			board.get("1").
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
        return board;
	}
}
