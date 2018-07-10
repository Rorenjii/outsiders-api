package org.outsiders.release.service.impl;

import java.util.List;
import java.util.Optional;

import org.outsiders.release.domain.ClassLevel;
import org.outsiders.release.domain.constant.ClassType;
import org.outsiders.release.repository.ClassLevelRepository;
import org.outsiders.release.service.ClassLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassLevelServiceImpl implements ClassLevelService {

	@Autowired
	private ClassLevelRepository repo;
	
	@Override
	public ClassLevel findByClassTypeAndLevel(ClassType classType, int level) {
		return repo.findByClassTypeAndLevel(classType, level);
	}
	
	@Override
	public ClassLevel insert(ClassLevel entity) {
		return repo.insert(entity);
	}

	@Override
	public List<ClassLevel> insert(Iterable<ClassLevel> entities) {
		return repo.insert(entities);
	}

	@Override
	public Optional<ClassLevel> findById(String id) {
		return repo.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return repo.existsById(id);
	}

	@Override
	public List<ClassLevel> findAll() {
		return repo.findAll();
	}

	@Override
	public List<ClassLevel> findAllById(Iterable<String> ids) {
		return repo.findAllById(ids);
	}

	@Override
	public long count() {
		return repo.count();
	}

	@Override
	public void deleteById(String id) {
		repo.deleteById(id);
	}

	@Override
	public void delete(ClassLevel entity) {
		repo.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends ClassLevel> entities) {
		repo.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		repo.deleteAll();
	}

}