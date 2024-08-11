package com.pichincha.automationtest.runners;

import com.pichincha.automationtest.util.execution.AfterSuite;
import com.pichincha.automationtest.util.execution.BeforeSuite;
import com.pichincha.automationtest.util.execution.ControlExecution;
import com.pichincha.automationtest.util.execution.CustomCucumberWithSerenityRunner;
import com.pichincha.automationtest.util.overwritedata.FeatureOverwrite;
import com.pichincha.automationtest.util.constants.Paths;
import io.cucumber.junit.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.pichincha.automationtest.util.constants.Constants.EXT_FEATURE;

@Slf4j
@RunWith(CustomCucumberWithSerenityRunner.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.pichincha.automationtest.hooks", "com.pichincha.automationtest.glue"},
        plugin = {"json:build/cucumber-reports/json/cucumber.json", "summary"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@ProductPurchase"
)

public class WebRunnerTest {

    private WebRunnerTest() {
    }

    @BeforeSuite
    public static void init() throws IOException {
        ControlExecution.featuresSegmentation();
        List<String> features = FeatureOverwrite.listFilesByFolder(new File(Paths.featuresPath()));
        for (String feature : features) {
            if (feature.contains(EXT_FEATURE)) {
                FeatureOverwrite.overwriteFeatureFileAdd(feature);
            }
        }
        FeatureOverwrite.clearListFilesByFolder();
    }

    @AfterSuite
    public static void after() {
        log.info("=====> End Execution SerenityBDD");
    }
}