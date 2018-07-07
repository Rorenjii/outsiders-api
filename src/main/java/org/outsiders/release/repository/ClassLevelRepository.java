package org.outsiders.release.repository;

import org.outsiders.release.domain.ClassLevel;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ClassLevelRepository extends CassandraRepository<ClassLevel, String> {
}