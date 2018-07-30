package tk.mybatis.springboot.controller.forward;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrganizationForward {

	@RequestMapping(value="/organization/manager")
	public String organization_manager(){
		return "organization/manager";
	}

	@RequestMapping(value="/organization/addUI")
	public String organization_add(){
		return "organization/add";
	}


}
