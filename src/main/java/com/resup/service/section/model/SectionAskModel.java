package com.resup.service.section.model;

import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.response.ResponseBuilder;
import com.resup.DialogFlowApp;
import com.resup.api.api2.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SectionAskModel {
    @Autowired
    private DialogFlowApp dialogFlowApp;

    protected static int numberModel;
    protected static String phraseModel;

    public ActionResponse section_ask_model(ActionRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        String section = request.getParameter("section").toString();
        String sentence = request.getParameter("sentence").toString();
        numberModel = 0;

        ResponseEntity<Part> response =
                restTemplate.getForEntity("http://ischolar.df.r.appspot.com/api/v1/part/Sections-" + section + "-" + sentence,
                        Part.class);
        Part part = response.getBody();

        String content = part.getListPhrases()[numberModel].getName();
        content+= " (" + part.getListPhrases()[numberModel].getVi() + ")";
        phraseModel = part.getListPhrases()[numberModel].getName();

        ResponseBuilder responseBuilder = dialogFlowApp.getResponseBuilder(request);
        responseBuilder.add(content);

        return responseBuilder.build();
    }
}
