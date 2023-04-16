package lk.ijse.spring;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MySpringBootPOSAppInitializer {

    public static void main(String[] args) {

        SpringApplication.run(MySpringBootPOSAppInitializer.class);
        System.out.println("spring start ....!");
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
