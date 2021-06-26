//package com.legend.service;
//
//import com.legend.exception.RecordNotFoundExcption;
//import com.legend.model.Employee;
//import com.legend.repository.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
///**
// * @author iot
// * @Description TODO
// * {@link}
// * @date 2021/6/25上午8:48
// */
//@Service
//public class EmployeesService {
//
//  @Autowired
//  EmployeeRepository repository;
//
//  public List<Employee> getAllEmployees(){
//    List<Employee> result = (List<Employee>) repository.findAll();
//
//    if (result.size()>0){
//      return result;
//    }else {
//      return new ArrayList<Employee>();
//    }
//  }
//
//  public Employee getEmployeeById(Long id) throws RecordNotFoundExcption {
//    Optional<Employee> employee = repository.findById(id);
//
//    if (employee.isPresent()){
//      return employee.get();
//    }else {
//      throw new RecordNotFoundExcption("No employee recode exist for given id");
//    }
//  }
//
//  public Employee creteOrUpdateEmployee(Employee entity){
//
//    if(entity.getId() == null){
//      entity = repository.save(entity);
//      return entity;
//    }else {
//      Optional<Employee> employee = repository.findById(entity.getId());
//
//      if (employee.isPresent()){
//        Employee newEntity = employee.get();
//        newEntity.setEmail(entity.getEmail());
//        newEntity.setFirstName(entity.getFirstName());
//        newEntity.setLastName(entity.getLastName());
//        newEntity = repository.save(newEntity);
//        return newEntity;
//      } else {
//        entity = repository.save(entity);
//        return entity;
//      }
//    }
//  }
//
//  public void deleteEmployeeById(Long id) throws RecordNotFoundExcption{
//    Optional<Employee> employee = repository.findById(id);
//
//    if(employee.isPresent()){
//      repository.deleteById(id);
//    }else {
//      throw new RecordNotFoundExcption("No employee record exit for given id");
//    }
//  }
//}
