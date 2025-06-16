package com.in.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.in.entity.User;
import com.in.exceptions.UserNotFoundException;
import com.in.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	public User saveUserDetails(User user) {
		return repo.save(user);
	}
	@Override
	public User getOneUser(Integer id) {
		return repo.findById(id).orElseThrow(()->new UserNotFoundException("User with ID "+id+" not available in Database"));
	}

	@Override
	public List<User> getUserDetails() {
		return repo.findAll();
	}

	@Override
	public void deleteOneUser(Integer id) {
		repo.deleteById(id);
		System.out.println("Record deleted with id: "+id);
	}

	@Override
	public void deleteAllUserDetails() {
        repo.deleteAll();
        System.out.println("Deleted all records!!");
	}
	
	@Override
	public void updateUserDetails(User user) {
		User existingUser = repo.findById(user.getuId())
			                .orElseThrow(()->new UserNotFoundException("User Detaile is not available in DB with id: "+user.getuId()));
	
		existingUser.setUname(user.getUname());
		existingUser.setAddr(user.getAddr());
	 repo.save(existingUser);
	}
}
