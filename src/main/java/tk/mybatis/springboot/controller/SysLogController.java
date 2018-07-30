package tk.mybatis.springboot.controller;


import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.springboot.model.SysLog;
import tk.mybatis.springboot.service.SysLogService;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService ;


    @RequestMapping(value="/findAll")
    @ResponseBody
    public Map<String, Object> findAll(SysLog sysLog, Integer pageIndex, Integer pageSize){
        sysLog.setPage(pageIndex+1);
        sysLog.setRows(pageSize);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        PageInfo<SysLog> sysLogPageInfo = sysLogService.findAll(sysLog);
        resultMap.put("data", sysLogPageInfo.getList());
        resultMap.put("total",sysLogPageInfo.getTotal());
        return resultMap;
    }
}
