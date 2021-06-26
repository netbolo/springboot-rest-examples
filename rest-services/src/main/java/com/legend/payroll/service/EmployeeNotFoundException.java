package com.legend.payroll.service;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/23下午8:00
 */
public class EmployeeNotFoundException extends RuntimeException {

  public EmployeeNotFoundException(Long id){
    super("Could not find employee " + id);
  }
}
