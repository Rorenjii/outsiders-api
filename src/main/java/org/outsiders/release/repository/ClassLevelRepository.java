package org.outsiders.release.repository;

import java.util.List;

import org.outsiders.release.domain.ClassLevel;
import org.outsiders.release.domain.constant.ClassType;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ClassLevelRepository extends CassandraRepository<ClassLevel, String> {
	
	@AllowFiltering
	public ClassLevel findByClassTypeAndLevel(ClassType classType, int level);
}