package com.dealsandcouponsfinder.profilemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealsandcouponsfinder.profilemanagement.exception.ProfileRequestException;
import com.dealsandcouponsfinder.profilemanagement.model.Credentials;
import com.dealsandcouponsfinder.profilemanagement.model.Profile;
import com.dealsandcouponsfinder.profilemanagement.repository.CredentialsRepository;
import com.dealsandcouponsfinder.profilemanagement.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	CredentialsRepository credentialsRepository;

	public Profile save(Profile pro) {

		if (pro.getEmailId() == null && pro.getPassword() == null) {
			throw new ProfileRequestException("ID or password can not be null");
		} else {
			Profile profile = profileRepository.save(pro);
			Credentials cred = new Credentials(pro.getEmailId(), pro.getPassword());
			credentialsRepository.save(cred);
			return profile;
		}
	}

	public List<Profile> findAll() {
		return (List<Profile>) profileRepository.findAll();
	}

	public String deleteById(String id) {
		if (!findById(id).isEmpty()) {
			profileRepository.deleteById(id);
			return "Id " + id + " deleted!";
		} else {
			return "Id " + id + " is not found";
		}
	}

	public Optional<Profile> findById(String id) {
		Optional<Profile> profile = profileRepository.findById(id);
		if (profile.isEmpty()) {
			throw new ProfileRequestException("ID is not found");
		} else {
			return profile;
		}
	}

	public boolean login(Credentials cred) {
		Optional<Credentials> credentials = credentialsRepository.findById(cred.getEmailId());
		System.out.println(credentials);
		if (credentials.isPresent() && credentials.get().getPassword().equals(cred.getPassword()))
				 {
			
			credentialsRepository.save(credentials.get());
			return true;
		} else {
			return false;
		}
	}

	public boolean logout(Credentials cred) {
		Optional<Credentials> credentials = credentialsRepository.findById(cred.getEmailId());
		if (credentials.isPresent() && credentials.get().getPassword().equals(cred.getPassword())
				) {
			
			credentialsRepository.save(credentials.get());
			return true;
		} else {
			return false;
		}
	}
}
