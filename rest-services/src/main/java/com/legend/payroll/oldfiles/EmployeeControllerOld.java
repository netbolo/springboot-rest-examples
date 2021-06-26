//package com.legend.payroll;
//
//import org.springframework.hateoas.CollectionModel;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
//
///**
// * @author iot
// * @Description TODO
// * {@link}
// * @date 2021/6/23下午7:55
// */
//@RestController
//public class EmployeeControllerOld {
//
//  private final EmployeeRepository repository;
//
//  public EmployeeControllerOld(EmployeeRepository repository) {
//    this.repository = repository;
//  }
//
//  //aggregate root
//  //tag::get-aggregate-root[]
//  @GetMapping("/employees")
//  CollectionModel<EntityModel<Employee>> all(){
//
//    List<EntityModel<Employee>> employees = repository.findAll().stream()
//        .map(employee -> EntityModel.of(employee,
//
//            linkTo(methodOn(EmployeeControllerOld.class).one(employee.getId())).withSelfRel(),
//
//            linkTo(methodOn(EmployeeControllerOld.class).all()).withRel("employees")))
//        .collect(Collectors.toList());
//
//    return CollectionModel.of(employees,
//        linkTo(methodOn(EmployeeControllerOld.class).all()).withSelfRel());
//  }
//
//  @PostMapping("/employees/{id}")
//  Employee newEmployee(@RequestBody Employee newEmployee){
//    return repository.save(newEmployee);
//  }
//
//  @GetMapping("/employees/{id}")
//  EntityModel<Employee> one(@PathVariable Long id){
//
//    Employee employee = repository.findById(id)
//        .orElseThrow(()->new EmployeeNotFoundException(id));
//
//    return EntityModel.of(employee,
//        linkTo(methodOn(EmployeeControllerOld.class).one(id)).withSelfRel(),
//        linkTo(methodOn(EmployeeControllerOld.class).all()).withRel("employees"));
//  }
//
//  @PutMapping("/employees/{id}")
//  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
//    return repository.findById(id)
//        .map(employee -> {
//          employee.setName(newEmployee.getName());
//          employee.setRole(newEmployee.getRole());
//          return repository.save(newEmployee);
//        })
//        .orElseGet(() -> {
//          newEmployee.setId(id);
//          return repository.save(newEmployee);
//        });
//  }
//
//  @DeleteMapping("/employees/{id}")
//  void deleteEmployee(@PathVariable Long id){
//    repository.deleteById(id);
//  }
//}
