package org.outsiders.release.service.impl;

import java.util.List;
import java.util.Optional;

import org.outsiders.release.domain.Race;
import org.outsiders.release.repository.RaceRepository;
import org.outsiders.release.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaceServiceImpl implements RaceService {

	@Autowired
	private RaceRepository repo;
	
	@Override
	public Race insert(Race entity) {
		return repo.insert(entity);
	}

	@Override
	public List<Race> insert(Iterable<Race> entities) {
		return repo.insert(entities);
	}

	@Override
	public Optional<Race> findById(String id) {
		return repo.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return repo.existsById(id);
	}

	@Override
	public List<Race> findAll() {
		return repo.findAll();
	}

	@Override
	public List<Race> findAllById(Iterable<String> ids) {
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
	public void delete(Race entity) {
		repo.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Race> entities) {
		repo.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		repo.deleteAll();
	}

}