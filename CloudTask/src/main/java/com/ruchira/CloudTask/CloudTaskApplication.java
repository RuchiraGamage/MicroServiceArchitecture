package com.ruchira.CloudTask;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class CloudTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudTaskApplication.class, args);
    }

    @Bean
    public TollProcessingTask getTollProcessingTask() {
        return new TollProcessingTask();
    }

    public class TollProcessingTask implements CommandLineRunner {

        @Override
        public void run(String... strings) throws Exception {
            if (null != strings) {
                System.out.println("parameter length is :" + strings.length);

                String firstArgs = strings[0];
                String secondArgs = strings[1];
                String thirdArgs = strings[2];

                System.out.println("Arguments :" + firstArgs + "/" + secondArgs + "/" + thirdArgs);

            }
        }
    }

}

