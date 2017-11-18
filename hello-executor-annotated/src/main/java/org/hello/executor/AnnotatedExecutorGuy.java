package org.hello.executor;

import java.util.List;

import javax.inject.Inject;

import org.apache.aries.blueprint.annotation.bean.Bean;
import org.apache.aries.blueprint.annotation.service.ReferenceList;
import org.hello.api.HelloService;

/**
 * @author vakho
 * 
 * @see http://aries.apache.org/modules/blueprintannotation.html
 */
@Bean(initMethod = "init", destroyMethod = "destroy")
public class AnnotatedExecutorGuy {

	@Inject
	@ReferenceList(referenceInterface = HelloService.class)
	List<HelloService> helloServices;

	public void setHelloServices(List<HelloService> helloServices) {
		this.helloServices = helloServices;
	}

	public void init() {
		System.out.println("Annotated Executor guy has been launched :)");
		System.out.println("It discovered " + helloServices.size() + " services...");
		helloServices.stream().forEach(i -> {
			System.out.println(i.sayHello("Vakho"));
		});
	}

	public void destroy() {
		System.out.println("Annotated Executor guy has been destroyed :(");
	}
}
