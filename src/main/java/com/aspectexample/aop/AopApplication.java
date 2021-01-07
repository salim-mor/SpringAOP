package com.aspectexample.aop;

import com.aspectexample.aop.beans.Client;
import com.aspectexample.aop.beans.Compte;
import com.aspectexample.aop.beans.IClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);

		Compte compte = new Compte(300);


		ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringContext.xml");
		IClient cp = (IClient)  ctx.getBean("clientProxy");

		cp.setNom("ahmed");
		cp.retirer(100);

	}




}
