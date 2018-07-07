package org.outsiders.release.repository;

import org.outsiders.release.domain.Character;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface CharacterRepository extends CassandraRepository<Character, String> {
}