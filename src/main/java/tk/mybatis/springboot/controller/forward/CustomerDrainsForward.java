package tk.mybatis.springboot.controller.forward;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerDrainsForward {

	@RequestMapping(value="/customerDrains/addUI")
	public String customer_add(){
		return "/custom/addDrains";
	}

}
