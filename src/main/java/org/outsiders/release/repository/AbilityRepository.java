package org.outsiders.release.repository;

import org.outsiders.release.domain.Ability;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface AbilityRepository extends CassandraRepository<Ability, String> {
}