package org.outsiders.release.repository;

import org.outsiders.release.domain.Race;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface RaceRepository extends CassandraRepository<Race, String> {
}