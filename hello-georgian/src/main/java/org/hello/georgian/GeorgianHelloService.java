package org.hello.georgian;

import org.hello.api.HelloService;

public class GeorgianHelloService implements HelloService
{
	@Override
	public String sayHello(String name) {
		return String.format("გამარჯობა  %s.", name);
	}
	
	public void init() {
		System.out.println("Georgian hello service has been created.");
	}
	
	public void destroy() {
		System.out.println("Georgian hello service has been destroyed!");
	}
}
