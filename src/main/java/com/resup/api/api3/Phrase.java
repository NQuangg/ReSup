package com.resup.api.api3;

import lombok.Data;

@Data
public class Phrase {
    private String title;
    private String url;
    private String summary;

    public String getSummary() {
        return summary;
    }
}