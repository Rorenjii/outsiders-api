package org.outsiders.release.repository;

import org.outsiders.release.domain.Item;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ItemRepository extends CassandraRepository<Item, String> {
}