package tk.mybatis.springboot.controller.forward;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SysLogForward {

	@RequestMapping(value="/sysLog/address")
	public String address_map(){
		return "/address/map";
	}

	@RequestMapping(value="/sysLog/manager")
	public String sysLog_manager(){
		return "/sysLog/sysLog_manage";
	}

}
