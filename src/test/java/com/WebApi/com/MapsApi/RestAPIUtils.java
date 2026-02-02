package com.WebApi.com.MapsApi;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;

public class RestAPIUtils {

    protected RequestSpecification commonSpec;

    public void setupFramework() {
        // Initialize common specifications
        commonSpec = SpecFactory.getRequestSpec()
                .header("Authorization", "Bearer " + AuthManager.getAccessToken());
    }
}