package com.resup.api.api1;

import lombok.Data;

@Data
public class ListPart {
    private String id;
    private String name;
    private String vi;

    public String getVi() {
        return vi;
    }
}
