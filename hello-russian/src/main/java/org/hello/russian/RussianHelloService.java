package org.hello.russian;

import org.apache.aries.blueprint.annotation.bean.Bean;
import org.apache.aries.blueprint.annotation.service.Service;
import org.hello.api.HelloService;

@Bean(initMethod = "init", destroyMethod = "destroy")
@Service(classes = HelloService.class)
public class RussianHelloService implements HelloService {

	@Override
	public String sayHello(String name) {
		return String.format("Здравствуй %s.", name);
	}

	public void init() {
		System.out.println("Russian hello service has been created.");
	}

	public void destroy() {
		System.out.println("Russian hello service has been destroyed!");
	}
}
