package com.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping("/display")
	public List<User> getAllUserDetails(){
		List<User> list = service.getUserDetails();
		return list;
	}
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
	    service.deleteOneUser(id);
	    return ResponseEntity.ok("User deleted with id: " + id);
	}

	@GetMapping("/deleteAll")
	public ResponseEntity<String> deleteAllUserRecords() {
		service.deleteAllUserDetails();
		return ResponseEntity.ok("ALL DETAILS ARE DELETED ");
	}
    
	@GetMapping("/update/{id}/{name}/{addr}")
	public ResponseEntity<String> updateUserDetailes(@PathVariable Integer id, @PathVariable String name, @PathVariable String addr){
		service.updateUserDetails(new User(id, name, addr));
		return ResponseEntity.ok("Record Updated succesfully.");
	}
}
