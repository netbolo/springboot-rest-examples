package com.legend.payroll.controller;

import com.legend.payroll.entity.Employee;
import com.legend.payroll.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/24下午2:23
 */
@SpringBootTest
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
class EmployeeRestControllerTest {

  @MockBean
  private EmployeeRepository employeeRepository;

  @Test
  public void mockitoTest(){

    String name = "alex";

    Employee alex = new Employee((long)1,"alex","test");

    Mockito.when(employeeRepository.findByName(alex.getName()))
        .thenReturn(alex);

    Employee found = employeeRepository.findByName(name);

    assertThat(found.getName())
        .isEqualTo(name);
  }

  @Autowired
  private WebApplicationContext context;

  private MockMvc mockMvc;

  @BeforeEach
  public void setUp(RestDocumentationContextProvider restDocumentation) {

    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
        .apply(documentationConfiguration(restDocumentation)).build();
  }


  @Test
  public void addEmployeeTest() throws Exception {
    this.mockMvc.perform(post("/employees/1").accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk());
        //.andDo(document("EmployeeRestTest",
        //    responseFields(
        //        fieldWithPath("content").description("The content"),
        //        fieldWithPath("_links.self.href").description("The links self href")
        //    )));
  }
}
