package com.simplify.sample.controller.aaa;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.simplify.sample.service.aaa.TempService;


@RestController
public class StatusController {
	
	
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Map<String, String> isRunning() {
    	Map<String, String> test = new HashMap<String, String>();
    	test = TempService.Test1();
//    	qnaService.getQna();
    	
    	return test;
    	
    }
}