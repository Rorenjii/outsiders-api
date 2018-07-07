package org.outsiders.release.service.impl;

import java.util.List;
import java.util.Optional;

import org.outsiders.release.domain.Character;
import org.outsiders.release.repository.CharacterRepository;
import org.outsiders.release.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {

	@Autowired
	private CharacterRepository repo;
	
	@Override
	public Character insert(Character entity) {
		return repo.insert(entity);
	}

	@Override
	public List<Character> insert(Iterable<Character> entities) {
		return repo.insert(entities);
	}

	@Override
	public Optional<Character> findById(String id) {
		return repo.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return repo.existsById(id);
	}

	@Override
	public List<Character> findAll() {
		return repo.findAll();
	}

	@Override
	public List<Character> findAllById(Iterable<String> ids) {
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
	public void delete(Character entity) {
		repo.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Character> entities) {
		repo.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		repo.deleteAll();
	}
	
}