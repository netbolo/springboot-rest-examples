package com.legend.payroll.service;

import com.legend.payroll.controller.EmployeeRestController;
import com.legend.payroll.entity.Employee;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/24上午7:43
 */
public class EmployeeRepresentationModelAssembler extends SimpleIdentifiableRepresentationModelAssembler<Employee> {
  /**
   * Link the {@link Employee} domain type to the {@link EmployeeRestController} using this
   * {@link SimpleIdentifiableRepresentationModelAssembler} in order to generate both
   * {@link org.springframework.hateoas.EntityModel} and {@link org.springframework.hateoas.CollectionModel}.
   */
  public EmployeeRepresentationModelAssembler() {
    super(EmployeeRestController.class);
  }
}
