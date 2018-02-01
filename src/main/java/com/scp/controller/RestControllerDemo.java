package com.scp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerDemo 
{
	//checking
	@RequestMapping(value="/" , method = RequestMethod.GET)
	public String getMsg() {
		System.out.println("1 numer");
		return "working fine...!!";
		}
	
}
