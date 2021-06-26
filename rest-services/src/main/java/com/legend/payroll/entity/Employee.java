package com.legend.payroll.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/23下午7:36
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class Employee {

  private @Id
  @GeneratedValue
  Long id;
  private String name;
  private String role;
}
