package com.platformance.wdt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WdtApplication {

	public static void main(String[] args) {
		SpringApplication.run(WdtApplication.class, args);
	}

//	@GetMapping("test")
//	public void test() {
//		List<Map<String, Object>> test =  userService.selectTest();
//		System.out.println(test);
//	}


}
