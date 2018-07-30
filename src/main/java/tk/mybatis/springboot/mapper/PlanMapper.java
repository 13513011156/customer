package tk.mybatis.springboot.mapper;



import tk.mybatis.springboot.model.Plan;
import tk.mybatis.springboot.util.MyMapper;

import java.util.List;

public interface PlanMapper extends MyMapper<Plan> {
    List<Plan> findAllPlan(Plan plan);

}