package tk.mybatis.springboot.mapper;



import tk.mybatis.springboot.model.RoleResource;
import tk.mybatis.springboot.util.MyMapper;

import java.util.List;

public interface RoleResourceMapper extends MyMapper<RoleResource> {

    int remove(String roleId);
    List<String> batchSelect(List<String> list);
}