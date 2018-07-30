package tk.mybatis.springboot.mapper;

import java.util.List;
import java.util.Map;

public interface ReportMapper {


    List<Map<String,Object>> CountCustomerlevel();

    List<Map<String,Object>> CountCustomerSatify();

    List<Map<String,Object>> CountCustomerCredit();
}