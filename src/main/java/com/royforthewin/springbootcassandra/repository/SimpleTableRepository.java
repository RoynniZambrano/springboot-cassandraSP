package com.royforthewin.springbootcassandra.repository;

import java.io.Serializable;
import java.util.Optional;

import com.royforthewin.springbootcassandra.model.SimpleTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleTableRepository extends CrudRepository<SimpleTable, Serializable> {

    Optional<SimpleTable> findByIdAndName(String id, String name);

}