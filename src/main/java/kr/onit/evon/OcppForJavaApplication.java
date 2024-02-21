package kr.onit.evon;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import kr.onit.evon.config.CommonProperty;

@EnableAsync
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "10m")
@EnableConfigurationProperties({CommonProperty.class})
@EnableJpaAuditing
@SpringBootApplication
public class OcppForJavaApplication {
	public static void main(String[] args) {
		SpringApplication.run(OcppForJavaApplication.class, args);
	}

}
