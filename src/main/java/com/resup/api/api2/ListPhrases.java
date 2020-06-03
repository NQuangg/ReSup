package com.resup.api.api2;

import lombok.Data;

@Data
public class ListPhrases {
    private String id;
    private String name;
    private String vi;

    public String getVi() {
        return vi;
    }

    public String getName() {
        return name;
    }
}

