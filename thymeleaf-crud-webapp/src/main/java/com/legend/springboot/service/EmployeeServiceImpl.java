package com.legend.springboot.service;

import com.legend.springboot.model.Employee;
import com.legend.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/25下午5:54
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  @Override
  public void saveEmployee(Employee employee) {
    this.employeeRepository.save(employee);
  }

  @Override
  public Employee getEmployeeById(long id) {
    Optional<Employee> optional = employeeRepository.findById(id);
    Employee employee = null;
    if(optional.isPresent()){
      employee = optional.get();
    }else{
      throw new RuntimeException("Employee not found for id:: " +id);
    }
    return employee;
  }

  @Override
  public void deleteEmployeeById(long id) {
    this.employeeRepository.deleteById(id);
  }
}
