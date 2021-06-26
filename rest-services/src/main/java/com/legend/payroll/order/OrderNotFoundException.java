package com.legend.payroll.order;

/**
 * @author iot
 * @Description TODO
 * {@link}
 * @date 2021/6/23下午8:00
 */
public class OrderNotFoundException extends RuntimeException {

  OrderNotFoundException(Long id){
    super("Could not find Order " + id);
  }
}
