package com.pichincha.automationtest.util.templates;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public class Merge {

    private final String templatePath;
    private static final Freemarker freemarker = new Freemarker();

    public Merge(String templatePath) {
        this.templatePath = templatePath;
    }

    public static Merge template(String templatePath) {
        return new Merge(templatePath);
    }

    public String withFields(Map<String, Object> fieldValues) {

        Template template = freemarker.getTemplate(templatePath);
        Writer writer = new StringWriter();

        try {
            template.process(fieldValues, writer);
        } catch (TemplateException | IOException e) {
            throw new IllegalStateException("Failed to merge test data template", e);
        }

        return writer.toString();
    }
}
