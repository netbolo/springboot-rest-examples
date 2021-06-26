package com.legend.service;

import com.legend.model.Employee;

import java.util.List;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/26上午10:06
 */
public interface EmployeeService {
  List<Employee> getAllEmployees();
  void saveEmployee(Employee employee);
  Employee getEmployeeById(long id);
  void deleteEmployeeById(long id);
}
