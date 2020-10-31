package com.ruchira.SpringTaskSink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

@SpringBootApplication
@EnableTaskLauncher
public class SpringTaskSinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTaskSinkApplication.class, args);
	}

}
