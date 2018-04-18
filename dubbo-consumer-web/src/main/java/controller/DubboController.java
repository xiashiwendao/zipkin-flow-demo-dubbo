package controller;

import org.dubbo.api.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;

@Controller
public class DubboController {
	@Reference
	private DemoService demoService;
	private static Logger logger = LoggerFactory.getLogger(DubboController.class);

	@RequestMapping(value = { "/dubbo/{username}" })
	@ResponseBody
	public String index(@PathVariable("username") String name) {
		logger.info("consumer start");
		logger.info("consumer message: " + demoService.getDisplayText(name));

		return demoService.getDisplayText(name);
	}
}
