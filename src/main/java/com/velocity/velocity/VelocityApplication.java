package com.velocity.velocity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.StringWriter;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

@SpringBootApplication
public class VelocityApplication {

    public static void main(String[] args) {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();
        Template t = velocityEngine.getTemplate("template.vm");
        VelocityContext context = new VelocityContext();
        context.put("name", "World");
        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        System.out.println(writer);
        SpringApplication.run(VelocityApplication.class, args);
    }

}
