package com.resup.service;

import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.response.ResponseBuilder;
import com.resup.DialogFlowApp;
import com.resup.service.section.model.SectionAskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Test extends SectionAskModel {
    @Autowired
    private DialogFlowApp dialogFlowApp;

    public ActionResponse test(ActionRequest request) {
        RestTemplate restTemplate = new RestTemplate();
//        Map<String, Object> map = request.getContext("example").getParameters();
//        String content = map.get("phrase").toString();
//        String url = "http://ischolar.org/api/v1/sections";

        String phrase = request.getParameter("phrase").toString();
        if (phrase.length() == 0) {
            phrase = phraseModel;
        }
        ResponseBuilder responseBuilder = dialogFlowApp.getResponseBuilder(request);
        responseBuilder.add(phrase);

        return responseBuilder.build();
    }
}
