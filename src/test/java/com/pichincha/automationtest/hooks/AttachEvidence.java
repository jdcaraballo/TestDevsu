package com.pichincha.automationtest.hooks;

import com.pichincha.automationtest.util.PropertiesReader;
import com.pichincha.automationtest.util.execution.AttachEvidenceToScenario;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.restassured.specification.FilterableRequestSpecification;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.pichincha.automationtest.util.constants.Constants.ATTRIB_ADD_EVIDENCE_CUCUMBER_ON;
import static com.pichincha.automationtest.util.constants.Constants.PROP_MANUALTEST;

@Slf4j
public class AttachEvidence extends AttachEvidenceToScenario {

    static PropertiesReader readProperties = new PropertiesReader();

    @After("not @dataBase and not @api")
    //@AfterStep("not @manual and not @dataBase and not @api")
    public void attachScreenshotJsonReportForScenario(Scenario scenario) {
        boolean isManualScenario = false;

        try {
            String[] tagsScenario = scenario.getSourceTagNames().toArray(new String[0]);
            for (String lineTag : tagsScenario) {
                if (lineTag.trim().equalsIgnoreCase("@manual")) {
                    isManualScenario = true;
                    break;
                }
            }
            if (isManualScenario) {
                String addEvidenceOn = readProperties.getProperty(ATTRIB_ADD_EVIDENCE_CUCUMBER_ON, PROP_MANUALTEST);
                if (addEvidenceOn.trim().equalsIgnoreCase("failed")) {
                    if (scenario.isFailed()) {
                        addEvidenceManualTest(scenario);
                    }
                } else {
                    addEvidenceManualTest(scenario);
                }
            } else {
                addScreenshot(scenario);
            }
        } catch (Exception e) {
            log.error("Failure when attaching image/evidence to JSON report generated by cucumber. " + e.getMessage());
        }
    }

    @After("@api and @smokeTest and not @karate")
    public void addEvidenceApis(Scenario scenario) {
        if (scenario.isFailed()) {
            FilterableRequestSpecification requestSpecification = (FilterableRequestSpecification) SerenityRest.when();
            Map<String, Object> metadata = new HashMap<>();
            metadata.put("URL", requestSpecification.getURI());
            metadata.put("Request Headers", requestSpecification.getHeaders().toString().split("\n"));
            metadata.put("Request Method", requestSpecification.getMethod());
            metadata.put("Request Body", requestSpecification.getBody());
            metadata.put("Status Code", SerenityRest.lastResponse().statusCode());
            metadata.put("Response Headers", SerenityRest.lastResponse().getHeaders().toString().split("\n"));
            metadata.put("Response Body", SerenityRest.lastResponse().getBody().prettyPrint());
            JSONObject evidenceJSON = new JSONObject(metadata);
            scenario.log(evidenceJSON.toString());
        }
    }
}