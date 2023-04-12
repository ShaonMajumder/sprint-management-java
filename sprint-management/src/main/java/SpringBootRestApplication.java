//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class SpringBootRestApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(SpringBootRestApplication.class, args);
//    }
//}

import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = {""})

import BACKEND.Routes.RouteConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.context.annotation.Import;

@Import(RouteConfiguration.class)
@EnableAutoConfiguration(exclude = {R2dbcAutoConfiguration.class})
@SpringBootApplication
public class SpringBootRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApplication.class, args);
    }

}
