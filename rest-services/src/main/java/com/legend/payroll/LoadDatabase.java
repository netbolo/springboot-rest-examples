package com.legend.payroll;

import com.legend.payroll.entity.Employee;
import com.legend.payroll.repository.EmployeeRepository;
import com.legend.payroll.order.Order;
import com.legend.payroll.order.OrderRepository;
import com.legend.payroll.order.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/23下午7:48
 */
@Configuration
public class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(EmployeeRepository employeeRepository,
                                 OrderRepository orderRepository) {

    return args -> {
      employeeRepository.save(new Employee((long) 1,"Bilbo", "burglar"));
      employeeRepository.save(new Employee((long) 2,"Frodo", "thief"));

      employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));

      orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
      orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

      orderRepository.findAll().forEach(order -> log.info("Preloaded " + order));
    };
  }
}
