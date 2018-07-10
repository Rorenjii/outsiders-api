package org.outsiders.release.repository;

import org.outsiders.release.domain.Race;
import org.outsiders.release.domain.constant.RaceType;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface RaceRepository extends CassandraRepository<Race, String> {
	
	@AllowFiltering
	Race findByType(RaceType type);
}