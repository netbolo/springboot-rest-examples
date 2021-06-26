package com.legend.payroll.controller;

import com.legend.payroll.component.EmployeeModelAssembler;
import com.legend.payroll.service.EmployeeNotFoundException;
import com.legend.payroll.repository.EmployeeRepository;
import com.legend.payroll.entity.Employee;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/23下午7:55
 */
@RestController
public class EmployeeRestController {

  private final EmployeeRepository repository;

  private final EmployeeModelAssembler assembler;

  public EmployeeRestController(EmployeeRepository repository, EmployeeModelAssembler assembler) {
    this.repository = repository;
    this.assembler = assembler;
  }

  //aggregate root
  //tag::get-aggregate-root[]
  @GetMapping("/employees")
  public CollectionModel<EntityModel<Employee>> all() {


    List<EntityModel<Employee>> employees = repository.findAll().stream()
        .map(assembler::toModel
            //employee -> EntityModel.of(employee,
            //linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
            //linkTo(methodOn(EmployeeController.class).all()).withRel("employees"))
        )
        .collect(Collectors.toList());

    return CollectionModel.of(employees,
        linkTo(methodOn(EmployeeRestController.class).all()).withSelfRel());
  }

  //@PostMapping("/employees/{id}")
  //Employee newEmployee(@RequestBody Employee newEmployee){
  //  return repository.save(newEmployee);
  //}

  @PostMapping("/employees/{id}")
  public ResponseEntity<?> newEmployee(@RequestBody Employee newEmployee) {

    EntityModel<Employee> entityModel = assembler.toModel(repository.save(newEmployee));

    return ResponseEntity
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entityModel);
  }

  @GetMapping("/employees/{id}")
  public EntityModel<Employee> one(@PathVariable Long id) {

    Employee employee = repository.findById(id)
        .orElseThrow(() -> new EmployeeNotFoundException(id));

    return assembler.toModel(employee);

    //return EntityModel.of(employee,
    //    linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel(),
    //    linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
  }

  @PutMapping("/employees/{id}")
  public ResponseEntity<?> replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

    Employee updateEmployee = repository.findById(id)
        .map(employee -> {
          employee.setName(newEmployee.getName());
          employee.setRole(newEmployee.getRole());
          return repository.save(newEmployee);
        })
        .orElseGet(() -> {
          newEmployee.setId(id);
          return repository.save(newEmployee);
        });

    EntityModel<Employee> entityModel = assembler.toModel(updateEmployee);

    return ResponseEntity
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entityModel);
  }

  /*@DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }*/

  @DeleteMapping("/employees/{id}")
  public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
