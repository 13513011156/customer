package tk.mybatis.springboot.controller.forward;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerForward {

	@RequestMapping(value="/customer/manager")
	public String customer_manager(){
		return "/custom/customer_manage";
	}

	@RequestMapping(value="/customer/addUI")
	public String customer_add(){
		return "/custom/add";
	}

	@RequestMapping(value="/customer/drains")
	public String customer_drains(){
		return "/custom/customerDrains";
	}

}
