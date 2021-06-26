package com.legend.rest.tutorial.persistence.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.legend.rest.tutorial.persistence.IOperations;
import com.legend.rest.tutorial.persistence.model.Foo;

public interface IFooService extends IOperations<Foo> {

    Page<Foo> findPaginated(Pageable pageable);

}
