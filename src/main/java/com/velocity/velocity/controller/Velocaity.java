package com.velocity.velocity.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.StringWriter;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

@RestController
@RequestMapping("/ssti")
public class Velocaity {

    @RequestMapping("/")
    @ResponseBody
    String index(@RequestParam(required = false, name = "text") String textString) {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();
        Template t = velocityEngine.getTemplate("template.vm");
        VelocityContext context = new VelocityContext();
        context.put("name", "World");
        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        System.out.println(writer);
    }
}

