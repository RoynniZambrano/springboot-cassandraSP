package com.royforthewin.springbootcassandra.controller;

import java.util.Optional;

import com.royforthewin.springbootcassandra.model.SimpleTable;
import com.royforthewin.springbootcassandra.repository.SimpleTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cassandra")
public class CassandraController {

    @Autowired
    private SimpleTableRepository simpleTableRepository;

    @PostMapping
    public ResponseEntity<SimpleTable> saveIntoSimpleTable(@RequestBody SimpleTable simpleTable) {
        SimpleTable savedData = simpleTableRepository.save(simpleTable);
        return new ResponseEntity<>(savedData, HttpStatus.OK);
    }

    @GetMapping(path = "{id}/{name}")
    public ResponseEntity<SimpleTable> fetchRecordFromSimpleTable(@PathVariable("id") String id,
                                                                  @PathVariable("name") String name) {
        Optional<SimpleTable> fetchData = simpleTableRepository.findByIdAndName(id, name);
        if (!fetchData.isPresent()) {
            // throw an exception and catch it in the controller advice and return an
            // elegant response to the user
        }
        return new ResponseEntity<>(fetchData.get(), HttpStatus.OK);
    }
}