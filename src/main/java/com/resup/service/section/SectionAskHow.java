package com.resup.service.section;

import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.response.ResponseBuilder;
import com.resup.DialogFlowApp;
import com.resup.api.api1.ListPart;
import com.resup.api.api1.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SectionAskHow {
    @Autowired
    private DialogFlowApp dialogFlowApp;

    public ActionResponse section_ask_how(ActionRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        String section = request.getParameter("section").toString();
        String url = "http://ischolar.df.r.appspot.com/api/v1/sections";

        ResponseEntity<Section[]> response = restTemplate.getForEntity(url, Section[].class);
        Section[] sections = response.getBody();
        Section keySection = new Section();
        for (Section sectionItem: sections) {
            if (sectionItem.getName().toLowerCase().equals(section.toLowerCase())) {
                keySection = sectionItem;
            }
        }
        String content = "Phần " + keySection.getName() + " thường có " + keySection.getListPart().length + " câu. \n";
        int index = 1;
        for (ListPart listPart: keySection.getListPart()) {
            content+= "Câu " + index + ": " + listPart.getVi() + ". \n";
            index++;
        }

        ResponseBuilder responseBuilder = dialogFlowApp.getResponseBuilder(request);
        responseBuilder.add(content);

        return responseBuilder.build();
    }
}

