package tk.mybatis.springboot.controller.forward;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DevelopForward {

	@RequestMapping(value="/market/develop")
	public String market_develop(){
		return "/market/customer_develop";
	}

	@RequestMapping(value="/market/chance")
	public String market_chance(){
		return "/market/customer_chance";
	}
	@RequestMapping(value="/market/addUI")
	public String market_addUI(){
		return "/market/add";
	}
	@RequestMapping(value="/market/giveUI")
	public String market_giveUI(){
		return "/market/designee";
	}

	@RequestMapping(value="/market/exploitUI")
	public String market_exploitUI(){
		return "/market/exploit";
	}

}
