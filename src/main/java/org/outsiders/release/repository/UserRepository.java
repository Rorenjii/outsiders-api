package org.outsiders.release.repository;

import org.outsiders.release.domain.User;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserRepository extends CassandraRepository<User, String> {
	
	@AllowFiltering
	User findByEmail(String email);
}