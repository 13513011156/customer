package tk.mybatis.springboot.controller.forward;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoleForward {

	@RequestMapping(value="/role/manager")
	public String role_manager(){
		return "role/manager";
	}

	@RequestMapping(value="/role/addUI")
	public String role_add(){
		return "role/add";
	}

	@RequestMapping(value="/role/rightUI")
	public String role_right(){
		return "role/right";
	}
}
