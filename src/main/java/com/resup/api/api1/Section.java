package com.resup.api.api1;

import com.resup.api.api1.ListPart;
import lombok.Data;

@Data
public class Section {
    private String name;
    private String id;
    private String vi;
    private ListPart listPart[];

    public String getName() {
        return name;
    }

    public String getVi() {
        return vi;
    }

    public ListPart[] getListPart() {
        return listPart;
    }
}