package org.outsiders.release.service.impl;

import java.util.List;
import java.util.Optional;

import org.outsiders.release.domain.Item;
import org.outsiders.release.repository.ItemRepository;
import org.outsiders.release.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository repo;
	
	@Override
	public Item insert(Item entity) {
		return repo.insert(entity);
	}

	@Override
	public List<Item> insert(Iterable<Item> entities) {
		return repo.insert(entities);
	}

	@Override
	public Optional<Item> findById(String id) {
		return repo.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return repo.existsById(id);
	}

	@Override
	public List<Item> findAll() {
		return repo.findAll();
	}

	@Override
	public List<Item> findAllById(Iterable<String> ids) {
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
	public void delete(Item entity) {
		repo.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Item> entities) {
		repo.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		repo.deleteAll();
	}
	
}