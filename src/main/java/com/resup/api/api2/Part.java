package com.resup.api.api2;

import com.resup.api.api2.ListPhrases;
import lombok.Data;

@Data
public class Part {
    private String id;
    private String name;
    private String vi;
    private ListPhrases[] listPhrases;

    public ListPhrases[] getListPhrases() {
        return listPhrases;
    }
}
