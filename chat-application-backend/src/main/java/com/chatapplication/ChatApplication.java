package com.chatapplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Properties;

@SpringBootApplication
public class ChatApplication {

	public static void main(String[] args) {
		String[] serverConfiguration = args[0].split(";");
		String serverType = serverConfiguration[0].split("=")[1].toLowerCase();
		String ip = serverConfiguration[1].split("=")[1].toLowerCase();

		Properties properties = new Properties();
		if (serverType.equals("iterative")) {
			System.out.println("Starting in iterative mode");
			properties.put("server.tomcat.threads.max", "1");
			properties.put("server.tomcat.max-connections", "1");
			properties.put("myserver.iterative", true);
			properties.put("server.address", ip);
		} else {
			System.out.println("Starting in concurrent mode");
			properties.put("server.tomcat.threads.max", "200");
			properties.put("server.tomcat.max-connections", "8192");
			properties.put("myserver.iterative", false);
			properties.put("server.address", ip);
		}

		new SpringApplicationBuilder(ChatApplication.class).properties(properties).run(args);
	}

}
