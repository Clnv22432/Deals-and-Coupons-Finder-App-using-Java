package com.dealsandcouponsfinder.profilemanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.dealsandcouponsfinder.profilemanagement.model.Credentials;

public interface CredentialsRepository extends CrudRepository<Credentials, String>{

}
