package tk.mybatis.springboot.mapper;



import tk.mybatis.springboot.model.User;
import tk.mybatis.springboot.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface UserMapper extends MyMapper<User> {

    List<Map<String,Object>> findSalesAll();

    List<Map<String,Object>> findAllManager();
}