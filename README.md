# Spring-Cloud-Gateway-Eureka-Registry

# Eureka Service Discovery :

![enter image description here](https://res.cloudinary.com/practicaldev/image/fetch/s--HDiaSQsV--/c_imagga_scale,f_auto,fl_progressive,h_900,q_auto,w_1600/https://dev-to-uploads.s3.amazonaws.com/uploads/articles/wwycjvnbruj9d7lsfj6d.png)

Eureka Server is an application that holds the information about all client-service applications.
Every Micro service will register into the Eureka server and Eureka server knows all the client applications running on each port and IP address.
Eureka Server is also known as Discovery Server.


## Start a Eureka Service Registry

You first need a Eureka Service registry. You can use Spring Cloud’s  `@EnableEurekaServer`  to stand up a registry with which other applications can communicate. This is a regular Spring Boot application with one annotation (`@EnableEurekaServer`) added to enable the service registry. The following listing (from  `eureka-service/src/main/java/com.example.serviceregistrationanddiscoveryservice/ServiceRegistrationAndDiscoveryServiceApplication.java`) shows the service application:

```
package com.example.serviceregistrationanddiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServiceRegistrationAndDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistrationAndDiscoveryServiceApplication.class, args);
	}
}
```

When the registry starts, it will complain (with a stacktrace) that there are no replica nodes to which the registry can connect. In a production environment, you will want more than one instance of the registry. For our simple purposes, however, it suffices to disable the relevant logging.

By default, the registry also tries to register itself, so you need to disable that behavior as well.

It is a good convention to put this registry on a separate port when using it locally.

Add some properties to  `eureka-service/src/main/resources/application.properties`  to handle all of these requirements, as the following listing shows:

```
server.port=8761

eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false

logging.level.com.netflix.eureka=OFF
logging.level.com.netflix.discovery=OFF
```


# App Architecture : 
![enter image description here](https://github.com/NassimMs/Spring-Cloud-Gateway-Eureka-Registry/blob/master/arch.png)
# Execution Screen : 

![enter image description here](https://github.com/NassimMs/Spring-Cloud-Gateway-Eureka-Registry/blob/master/screen.png)
