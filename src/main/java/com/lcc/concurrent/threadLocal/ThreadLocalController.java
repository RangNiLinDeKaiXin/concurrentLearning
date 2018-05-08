package com.lcc.concurrent.threadLocal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/threadLocal")
public class ThreadLocalController {

	@RequestMapping("/test")
	@ResponseBody
	public Long test() {
		//取 ThreadLocal的数据
		return RequestHolder.getId();
	}
}
