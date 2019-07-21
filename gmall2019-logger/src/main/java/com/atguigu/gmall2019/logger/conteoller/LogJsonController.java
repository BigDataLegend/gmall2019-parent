package com.atguigu.gmall2019.logger.conteoller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.gmall2019.common.constant.GmallConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController   //controller +    @ResponseBody
@Slf4j
public class LogJsonController {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	@GetMapping("test")
	public String getTest() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!1");
		return "success";
	}

	@PostMapping("log")
	public String doLog(@RequestParam("logString") String logString) {

		// 1 补充时间戳
		JSONObject jsonObject = JSON.parseObject(logString);
		jsonObject.put("ts", System.currentTimeMillis());
		String jsonString = jsonObject.toJSONString();

		// 2、落盘 file
		log.info(jsonString);//需要借助一个工具，并且写上注解，就创建了一个log对象，用来打印日志


		//3 发送到kafka
		if ("startup".equals(jsonObject.getString("type"))) {
			kafkaTemplate.send(GmallConstant.KAFKA_TOPIC_STARUP, jsonString);
		} else {
			kafkaTemplate.send(GmallConstant.KAFKA_TOPIC_STARUP, jsonString);
		}

		return "success";

	}

}
