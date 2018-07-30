package tk.mybatis.springboot.controller.forward;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuForward {

	@RequestMapping(value="/resource/manager")
	public String resource_manager(){
		return "resource/manager";
	}

	@RequestMapping(value="/resource/addUI")
	public String resource_add(){
		return "resource/add";
	}

}
