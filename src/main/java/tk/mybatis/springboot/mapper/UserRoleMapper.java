package tk.mybatis.springboot.mapper;


import org.apache.ibatis.annotations.Param;
import tk.mybatis.springboot.model.UserRole;
import tk.mybatis.springboot.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface UserRoleMapper extends MyMapper<UserRole> {

    List<Map<String,Object>> findById(@Param("id") String id);
    int deleteByUserId(String id);
}