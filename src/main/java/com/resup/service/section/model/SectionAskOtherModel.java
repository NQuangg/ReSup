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

import java.util.Map;

@Service
public class SectionAskOtherModel extends SectionAskModel{
    @Autowired
    private DialogFlowApp dialogFlowApp;

    public ActionResponse section_ask_other_model(ActionRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> map = request.getContext("model").getParameters();
        String section = map.get("section").toString();
        String sentence = map.get("sentence").toString();
        numberModel++;

        ResponseEntity<Part> response =
                restTemplate.getForEntity("http://ischolar.df.r.appspot.com/api/v1/part/Sections-" + section + "-" + sentence,
                        Part.class);
        Part part = response.getBody();

        String content;
        if (numberModel >= part.getListPhrases().length) {
            content = "Hết mẫu câu rồi ạ";
        } else {
            content = part.getListPhrases()[numberModel].getName();
            content+= " (" + part.getListPhrases()[numberModel].getVi() + ")";
            phraseModel = part.getListPhrases()[numberModel].getName();
        }

        ResponseBuilder responseBuilder = dialogFlowApp.getResponseBuilder(request);
        responseBuilder.add(content);

        return responseBuilder.build();
    }
}
