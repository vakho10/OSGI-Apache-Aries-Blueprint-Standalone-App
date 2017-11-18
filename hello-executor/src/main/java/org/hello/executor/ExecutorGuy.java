package org.hello.executor;

import java.util.List;

import org.hello.api.HelloService;

public class ExecutorGuy {
	
	private List<HelloService> helloServicesList;

	public void setHelloServicesList(List<HelloService> helloServicesList) {
		this.helloServicesList = helloServicesList;
	}

	public void init() {
		System.out.println("Executor guy has been launched :)");		
		System.out.println("It discovered " + helloServicesList.size() + " services...");
		helloServicesList.stream().forEach(i -> {
			System.out.println(i.sayHello("Vakho"));
		});
	}

	public void destroy() {
		System.out.println("Executor guy has been destroyed :(");
	}
}
