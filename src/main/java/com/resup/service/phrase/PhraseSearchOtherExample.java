package com.resup.service.phrase;

import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.response.ResponseBuilder;
import com.resup.DialogFlowApp;
import com.resup.api.api3.Phrase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PhraseSearchOtherExample extends PhraseSearchExample{
    @Autowired
    private DialogFlowApp dialogFlowApp;

    public ActionResponse phrase_search_other_example(ActionRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        String phrase = phraseModel;
        numberExample++;

        ResponseEntity<Phrase[]> response =
                restTemplate.getForEntity("https://20200531t171311-dot-ischolar.df.r.appspot.com/scholar?keyword=" + phrase + "&fbclid=IwAR0L0hH1A5dP06aBuzapXpPXYowOPyQTc-kUEPrRgDE8qs7mnMHM_UoBPDo",
                        Phrase[].class);
        Phrase[] phrases = response.getBody();

        String content;
        if (numberExample >= phrases.length) {
            content = "Hết ví dụ rồi ạ";
        } else {
            content = phrases[numberExample].getSummary();
        }

        ResponseBuilder responseBuilder = dialogFlowApp.getResponseBuilder(request);
        responseBuilder.add(content);

        return responseBuilder.build();
    }
}
