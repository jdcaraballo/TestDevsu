package com.pichincha.automationtest.util.templates;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

class Freemarker {

    private Configuration configuration = null;

    private Configuration getConfiguration() {
        if (configuration == null) {
            configuration = new Configuration(Configuration.VERSION_2_3_28);
            configuration.setDefaultEncoding("UTF-8");
            configuration.setClassForTemplateLoading(Freemarker.class, "/");
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        }
        return configuration;
    }

    /**
     * The template file should be in the "src/test/resources/templates" directory.
     */
    Template getTemplate(String templatePath) {
        try {
            return getConfiguration().getTemplate(templatePath);
        } catch (Exception e) {
            throw new IllegalStateException("Could not find template " + templatePath, e);
        }
    }

}