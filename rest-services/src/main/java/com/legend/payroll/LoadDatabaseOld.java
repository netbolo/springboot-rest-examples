//package com.legend.payroll;
//
//import com.legend.payroll.entity.Employee;
//import com.legend.payroll.repository.EmployeeRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author iot
// * @Description TODO
// * {@link}
// * @date 2021/6/23下午7:48
// */
//@Configuration
//public class LoadDatabaseOld {
//
//  private static final Logger log = LoggerFactory.getLogger(LoadDatabaseOld.class);
//
//  @Bean
//  CommandLineRunner initDatabase(EmployeeRepository repository) {
//
//    return args -> {
//      log.info("Preloading " + repository.save(new Employee(
//          "Bilbo", "Baggins", "burglar")));
//      log.info("Preloading " + repository.save(new Employee(
//          "Frodo", "Baggins", "thief")));
//    };
//  }
//}
