package com.legend.springboot.repository;

import com.legend.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/25下午5:52
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
