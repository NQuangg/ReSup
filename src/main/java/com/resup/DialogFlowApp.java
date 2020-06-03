package com.resup;


import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.resup.service.Test;
import com.resup.service.phrase.PhraseSearchExample;
import com.resup.service.phrase.PhraseSearchOtherExample;
import com.resup.service.report.ReportAskSection;
import com.resup.service.section.SectionAskHow;
import com.resup.service.section.model.SectionAskModel;
import com.resup.service.section.model.SectionAskOtherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DialogFlowApp extends DialogflowApp {

    // Bố cục 1 bài báo cáo
    @Autowired
    private ReportAskSection reportAskSection;
    @ForIntent("report_ask_section")
    public ActionResponse report_ask_section(ActionRequest request) {
        return reportAskSection.report_ask_section(request);
    }

    // Bố cục 1 phần cụ thể
    @Autowired
    private SectionAskHow sectionAskHow;
    @ForIntent("section_ask_how")
    public ActionResponse section_ask_how(ActionRequest request) {
        return sectionAskHow.section_ask_how(request);
    }

    // Cho mẫu 1 câu cụ thể
    @Autowired
    private SectionAskModel sectionAskModel;
    @ForIntent("section_ask_model")
    public ActionResponse section_ask_example(ActionRequest request) {
        return sectionAskModel.section_ask_model(request);
    }

    // Cho 1 mẫu câu khác
    @Autowired
    private SectionAskOtherModel sectionAskOtherModel;
    @ForIntent("section_ask_other_model")
    public ActionResponse section_ask_other_model(ActionRequest request) {
        return sectionAskOtherModel.section_ask_other_model(request);
    }

    // Cho ví dụ cách dùng 1 mẫu câu
    @Autowired
    private PhraseSearchExample phraseSearchExample;
    @ForIntent("phrase_search_example")
    public ActionResponse phrase_search_example(ActionRequest request) {
        return phraseSearchExample.phrase_search_example(request);
    }

    // Cho ví dụ khác
    @Autowired
    private PhraseSearchOtherExample phraseSearchOtherExample;
    @ForIntent("phrase_search_other_example")
    public ActionResponse phrase_search_other_example(ActionRequest request) {
        return phraseSearchOtherExample.phrase_search_other_example(request);
    }

    // Test
    @Autowired
    private Test test;
    @ForIntent("test")
    public ActionResponse test(ActionRequest request) {
        return test.test(request);
    }
}