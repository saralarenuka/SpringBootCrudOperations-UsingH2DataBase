package com.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.entity.User;
import com.in.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/show")
	public String showUsers() {
		return "FROM USER SERVICE APPLICATION";
	}
	
	@GetMapping("/save/{id}/{name}/{addr}")
	public User saveUser(@PathVariable Integer id, @PathVariable String name, @PathVariable String addr) {
		System.out.println("Record saved");
		User user = new User();
        user.setuId(id);      
        user.setUname(name);
        user.setAddr(addr);
        return service.saveUserDetails(user);
	}
	@GetMapping("/get/{id}")
	public User getOneUserDetails(@PathVariable("id") Integer id) {
		
		return service.getOneUser(id);
	}
	
	
	
	
}
