package me.buildon.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import me.buildon.domain.Account;

public interface AccountRepository extends MongoRepository<Account, String> {
	
	public Account findByUsername(String username);
	

}
