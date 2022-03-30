package com.dealsandcouponsfinder.profilemanagement.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import com.dealsandcouponsfinder.profilemanagement.exception.ProfileRequestException;
import com.dealsandcouponsfinder.profilemanagement.model.Credentials;
import com.dealsandcouponsfinder.profilemanagement.model.Profile;
import com.dealsandcouponsfinder.profilemanagement.service.ProfileService;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	ProfileService profileService;
	
	

	@PostMapping("/add")
	public Profile addProfile(@RequestBody Profile pro) {
		Profile profile = profileService.save(pro);
		return profile;
	}

	@GetMapping("/find/{id}")
	public Optional<Profile> searchProfileById(@PathVariable("id") String id) {
		Optional<Profile> profile = profileService.findById(id);
		return profile;
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProfileById(@PathVariable("id") String id) {
		String result = profileService.deleteById(id);
		return result;
	}

	@GetMapping("/findall")
	public List<Profile> findProfiles() {
		return (List<Profile>) profileService.findAll();
	}

	@PutMapping("/update")
	public Profile updateProfile(@RequestBody Profile pro) {
		Profile profile = profileService.save(pro);
		return profile;
	}

	@PostMapping("/login")
	public String loginProfile(@RequestBody Credentials cred) {
		boolean login = profileService.login(cred);
		if (login) {
			return "Login is successful";
		} else {
			return "Login is failed";
		}
	}

	@PostMapping("/logout")
	public String logoutProfile(@RequestBody Credentials cred) {
		boolean logout = profileService.logout(cred);
		if (logout) {
			return "Logout is successful";
		} else {
			return "Logout is failed";
		}

	}
}
