package com.czq.online;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwaggerOnlineApplication {

	/**
	 * （了解更多Swagger2注解的详解，关注微信公众号：快乐学习与分享）
	 *
	 * 这个模块可以使用最新的swagger2版本
	 * 可以在线查看api和测试接口（不能导出离线API文档）
	 *
	 * 启动这个类之后访问
	 * http://localhost:9987/swagger-ui.html
	 *
	 * @param args 参数
	 */
	public static void main(String[] args) {
		SpringApplication.run(SwaggerOnlineApplication.class, args);
	}
}
