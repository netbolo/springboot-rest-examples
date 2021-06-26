package com.legend.payroll.controller;

import com.legend.payroll.service.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/23下午8:08
 */
@ControllerAdvice
public class EmployeeNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(EmployeeNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)

  String employeeNotFoundHandler(EmployeeNotFoundException ex){
    return ex.getMessage();
  }
}
