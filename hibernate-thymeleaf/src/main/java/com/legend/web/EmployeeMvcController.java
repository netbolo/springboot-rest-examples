//package com.legend.web;
//
//import com.legend.exception.RecordNotFoundExcption;
//import com.legend.model.Employee;
//import com.legend.service.EmployeesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.List;
//import java.util.Optional;
//
///**
// * @author iot
// * @Description TODO
// * {@link}
// * @date 2021/6/25上午9:08
// */
//@Controller
//@RequestMapping("/")
//public class EmployeeMvcController {
//  @Autowired
//  EmployeesService service;
//
//  @RequestMapping
//  public String getAllEmployees(Model model){
//    List<Employee> list = service.getAllEmployees();
//
//    model.addAttribute("employees", list);
//    return "list-employees";
//  }
//
//  @RequestMapping(path = {"/edit", "/edit/{id}"})
//  public String editEmployeeById(Model model, @PathVariable("id")
//                                 Optional<Long> id) throws RecordNotFoundExcption{
//    if(id.isPresent()){
//      Employee entity = service.getEmployeeById(id.get());
//      model.addAttribute("employees", entity);
//    }else {
//      model.addAttribute("employees", new Employee());
//    }
//    return "add-edit-employee";
//  }
//
//  @RequestMapping(path = "/delete/{id}")
//  public String deleteEmployeeById(Model model, @PathVariable("id") Long id)
//    throws RecordNotFoundExcption{
//    service.deleteEmployeeById(id);
//    return "redirect:/";
//  }
//
//  @RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
//  public String creatOrUpdateEmployee(Employee employee){
//    service.creteOrUpdateEmployee(employee);
//    return "redirect:/";
//  }
//
//}
