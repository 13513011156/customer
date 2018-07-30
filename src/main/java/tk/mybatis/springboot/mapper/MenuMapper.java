package tk.mybatis.springboot.mapper;


import org.apache.ibatis.annotations.Param;
import tk.mybatis.springboot.model.Resource;
import tk.mybatis.springboot.util.MyMapper;

import java.util.List;

public interface MenuMapper extends MyMapper<Resource> {

    List<String> findChildrenMenuId(@Param("id") String id);

    int batchRemoveMenus(List<String> list);

    List<String> findMenuIds(String id);

    List<Resource> batchSelect(List<String> list);
}