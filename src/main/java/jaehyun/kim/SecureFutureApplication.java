package jaehyun.kim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SecureFutureApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecureFutureApplication.class, args);
    }
} 