package com.scp.controller;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scp.dao.UserDaoImpl;
import com.scp.service.ServiceImpl;

@RestController
public class RestControllerDemo {
	
	
	
	// checking
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getMsg() {
		System.out.println("1 numer");
		return "working fine...!!";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List getList() {
		return new UserDaoImpl().getAll();
	}
}