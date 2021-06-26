package com.legend.springboot.controller;

import com.legend.springboot.model.Employee;
import com.legend.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/25下午5:56
 */
@Controller
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/")
  public String viewHomePage(Model model){
    model.addAttribute("listEmployees",employeeService.getAllEmployees());
    return "index";
  }

  @GetMapping("/showNewEmployeeForm")
  public String showNewEmployeeForm(Model model){
    Employee employee = new Employee();
    model.addAttribute("employee",employee);
    return "new_employee";
  }

  @PostMapping("/saveEmployee")
  public String saveEmployee(@ModelAttribute("employee") Employee employee){
    employeeService.saveEmployee(employee);
    return "redirect:/";
  }

  @GetMapping("/showFormForUpdate/{id}")
  public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
    Employee employee = employeeService.getEmployeeById(id);
    model.addAttribute("employee", employee);
    return "update_employee";
  }

  @GetMapping("/deleteEmployee/{id}")
  public String deleteEmployee(@PathVariable(value = "id") long id){
    this.employeeService.deleteEmployeeById(id);
    return "redirect:/";
  }
}
