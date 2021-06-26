package com.legend.payroll.component;

import com.legend.payroll.controller.EmployeeRestController;
import com.legend.payroll.entity.Employee;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/23下午9:32
 */
@Component
public class EmployeeModelAssembler implements RepresentationModelAssembler<Employee,
    EntityModel<Employee>> {

  /**
   * Converts the given entity into a {@code D}, which extends {@link RepresentationModelAssembler}.
   *
   * @param employee
   * @return
   */
  @Override
  public EntityModel<Employee> toModel(Employee employee) {
    return EntityModel.of(employee,

        linkTo(methodOn(EmployeeRestController.class).one(employee.getId())).withSelfRel(),
        linkTo(methodOn(EmployeeRestController.class).all()).withRel("employees"));
  }
}
