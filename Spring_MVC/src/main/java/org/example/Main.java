package org.example;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.example.config.WebConfig;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws LifecycleException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        String contextpath = "";
        String baseDoc;
        baseDoc = new File("src/main/java").getAbsolutePath();

        Context context = tomcat.addContext(contextpath,baseDoc);

        AnnotationConfigWebApplicationContext springcontext = new AnnotationConfigWebApplicationContext();
        springcontext.register(WebConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(springcontext);

        Tomcat.addServlet(context, "dispatcherServlet", dispatcherServlet);

        context.addServletMapping("/", "dispatcherServlet");

        tomcat.start();

        //keep server running
        tomcat.getServer().await();
    }

}
