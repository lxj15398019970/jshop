package start;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

/**
 * Copyright (c) 2005-2012 springside.org.cn
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 */

/**
 * 创建Jetty Server的工厂类.
 * 
 * @author calvin
 */
public class JettyFactory {

	private JettyFactory() {
	}

	/**
	 * 创建用于开发运行调试的Jetty Server, 以src/main/webapp为Web应用目录.
	 */
	public static Server buildNormalServer(int port, String contextPath) {
		Server server = new Server(port);
		WebAppContext webContext = new WebAppContext("src/main/webapp", contextPath);
		webContext.setClassLoader(Thread.currentThread().getContextClassLoader());
		server.setHandler(webContext);
		server.setStopAtShutdown(true);
		return server;
	}

	/**
	 * 创建用于Functional Test的Jetty Server:
	 * 1.以src/main/webapp为Web应用目录.
	 * 2.以test/resources/web.xml指向applicationContext-test.xml创建测试环境.
	 */
    @SuppressWarnings("unused")
	public static Server buildTestServer(int port, String contextPath) {
		Server server = buildNormalServer(port, contextPath);
		((WebAppContext) server.getHandler()).setDescriptor("src/test/resources/web.xml");
		return server;
	}
}
