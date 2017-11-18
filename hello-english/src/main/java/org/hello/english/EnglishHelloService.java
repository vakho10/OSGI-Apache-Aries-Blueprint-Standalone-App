package org.hello.english;

import org.hello.api.HelloService;

public class EnglishHelloService implements HelloService
{
	@Override
	public String sayHello(String name) {
		return String.format("Hello, %s.", name);
	}
	
	public void init() {
		System.out.println("English hello service has been created.");
	}
	
	public void destroy() {
		System.out.println("English hello service has been destroyed!");
	}
}
