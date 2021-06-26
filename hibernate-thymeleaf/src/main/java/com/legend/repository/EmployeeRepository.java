package com.legend.repository;

import com.legend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/25上午8:47
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
