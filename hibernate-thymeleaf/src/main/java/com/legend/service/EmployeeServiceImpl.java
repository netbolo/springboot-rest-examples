package com.legend.service;

import com.legend.model.Employee;
import com.legend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/26上午10:09
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public List<Employee> getAllEmployees() {

    if (employeeRepository.findAll().size() > 0) {
      return employeeRepository.findAll();
    } else {
      return new ArrayList<Employee>();
    }
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
    }else {
      throw new RuntimeException("No employee record exit for given id::" +id);
    }
    return employee;
  }

  @Override
  public void deleteEmployeeById(long id) {
    this.employeeRepository.deleteById(id);
  }
}
