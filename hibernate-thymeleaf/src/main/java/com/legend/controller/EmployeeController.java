package com.legend.controller;

import com.legend.model.Employee;
import com.legend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/26上午10:26
 */
@Controller
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @RequestMapping("/")
  public String viewAllEmployees(Model model){

    model.addAttribute("listEmployees", employeeService.getAllEmployees());
    //return "list_employees";
    return "list_employees";
  }

  @GetMapping("/showNewEmployeeForm")
  public String showNewEmployeeForm(Model model){
    Employee employee = new Employee();
    model.addAttribute("employee",employee);
    return "new_employee";
  }

  @PostMapping("/saveEmployee")
  //@ModelAttribute等价于 model.addAttribute("attributeName", abc)
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
  public String deleteEmployee(@PathVariable(value = "id") long id, Model model){
    this.employeeService.deleteEmployeeById(id);
    return "redirect:/";
  }
}
