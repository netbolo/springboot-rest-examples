package com.legend.springboot.service;

import com.legend.springboot.model.Employee;

import java.util.List;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/25下午5:53
 */
public interface EmployeeService {
  List<Employee> getAllEmployees();
  void saveEmployee(Employee employee);
  Employee getEmployeeById(long id);
  void deleteEmployeeById(long id);
}
