package org.sid.customerservice;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.sid.customerservice.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(new Customer(null,"Nassim","nassimcoder@gmail.com"));
            customerRepository.save(new Customer(null,"Nassim2","nassim2@gmail.com"));
            customerRepository.save(new Customer(null,"Yassine","yassine@gmail.com"));
            customerRepository.findAll().forEach(c->{
                System.out.println(c.toString());
            });
        };
    }

}
