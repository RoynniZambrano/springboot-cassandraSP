package com.royforthewin.springbootcassandra.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("simple_table")
@Data
public class SimpleTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @Column("id")
    private String id;

    @PrimaryKeyColumn(name = "name", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    @Column("name")
    private String name;

    @Column("created_time")
    private Date createdTime  = new Date();
}