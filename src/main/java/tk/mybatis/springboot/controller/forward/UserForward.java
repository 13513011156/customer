package tk.mybatis.springboot.controller.forward;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserForward {

	@RequestMapping(value="/user/manager")
	public String user_manager(){
		return "user/manager";
	}

	@RequestMapping(value="/user/addUI")
	public String user_add(){
		return "user/add";
	}


}
