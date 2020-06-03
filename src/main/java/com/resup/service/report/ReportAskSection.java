package com.resup.service.report;

import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.response.ResponseBuilder;
import com.resup.DialogFlowApp;
import com.resup.api.api1.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReportAskSection {
    @Autowired
    private DialogFlowApp dialogFlowApp;

    public ActionResponse report_ask_section(ActionRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://ischolar.df.r.appspot.com/api/v1/sections";

        ResponseEntity<Section[]> response = restTemplate.getForEntity(url, Section[].class);
        Section[] sections = response.getBody();

        String content = "1 bài báo cáo gồm có " + sections.length + " phần: \n";
        int index = 1;
        for (Section section: sections) {
            content+= "Phần " + index + ": " + section.getName() + " (" + section.getVi() + "). \n";
            index++;
        }

        ResponseBuilder responseBuilder = dialogFlowApp.getResponseBuilder(request);
        responseBuilder.add(content);

        return responseBuilder.build();
    }
}

