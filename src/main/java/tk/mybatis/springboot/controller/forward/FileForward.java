package tk.mybatis.springboot.controller.forward;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileForward {

	@RequestMapping(value="/file/manager")
	public String file_manager(){
		return "/file/manager";
	}


	/*@RequestMapping(value="/file/addUI")
	public String file_addUI(){
		return "file/down";
	}*/


}
