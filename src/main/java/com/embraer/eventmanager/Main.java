package com.embraer.eventmanager;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Celso Ricardo Marques Pereira - CRMPERE
 * @version 1.0 - 14/01/2015
 */
public class Main {

	public static void main(String[] args) throws Exception {
		
		String webappDirLocation = "src/main/webapp";
		
		String webPort = System.getenv("PORT");
		if (StringUtils.isBlank(webPort)) {
			webPort = "8080";
		}
		
//		Server server = new Server(Integer.valueOf(webPort));
//		WebAppContext root = new WebAppContext();
//		root.setContextPath("/");
//		root.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
//		root.setResourceBase(webappDirLocation);
//		root.setParentLoaderPriority(true);
//		
//		server.setHandler(root);
//		server.start();
//		server.join();
	}
}