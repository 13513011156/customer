package tk.mybatis.springboot.mapper;


import tk.mybatis.springboot.model.CustomerDrains;
import tk.mybatis.springboot.util.MyMapper;

import java.util.List;

public interface CustomerDrainsMapper extends MyMapper<CustomerDrains> {
    List<CustomerDrains> findAll(CustomerDrains customerDrains);
    CustomerDrains findById(String id);
}