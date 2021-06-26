package com.legend.rest.tutorial.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legend.rest.tutorial.persistence.model.Foo;

public interface IFooDao extends JpaRepository<Foo, Long> {

}
