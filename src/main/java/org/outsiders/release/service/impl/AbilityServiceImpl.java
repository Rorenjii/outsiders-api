package org.outsiders.release.service.impl;

import java.util.List;
import java.util.Optional;

import org.outsiders.release.domain.Ability;
import org.outsiders.release.repository.AbilityRepository;
import org.outsiders.release.service.AbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbilityServiceImpl implements AbilityService {

	@Autowired
	private AbilityRepository repo;
	
	
	@Override
	public Ability insert(Ability entity) {
		return repo.insert(entity);
	}

	@Override
	public List<Ability> insert(Iterable<Ability> entities) {
		return repo.insert(entities);
	}

	@Override
	public Optional<Ability> findById(String id) {
		return repo.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return repo.existsById(id);
	}

	@Override
	public List<Ability> findAll() {
		return repo.findAll();
	}

	@Override
	public List<Ability> findAllById(Iterable<String> ids) {
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
	public void delete(Ability entity) {
		repo.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Ability> entities) {
		repo.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		repo.deleteAll();
	}

	@Override
	public Ability findByName(String name) {
		return repo.findByName(name);
	}
	
}