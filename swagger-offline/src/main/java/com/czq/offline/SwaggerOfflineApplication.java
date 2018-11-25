package com.czq.offline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SwaggerOfflineApplication {

	/**
	 * 启动服务后访问以下网址（执行命令 mvn clean test 在目录 target/asciidoc 下可以生成离线HTML文档和PDF文档）
	 * http://localhost:9999/swagger-ui.html
	 * @param args 参数
	 */
	public static void main(String[] args) {
		SpringApplication.run(SwaggerOfflineApplication.class, args);
	}
}
