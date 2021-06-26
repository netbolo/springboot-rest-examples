package com.legend.payroll.repository;

import com.legend.payroll.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/23下午7:47
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  public Employee findByName(String name);

}
