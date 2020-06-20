package com.tu.carinfocore.persistance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CodesInfoDTO {

    @JsonProperty(value = "code")
    private String code;
    @JsonProperty(value = "descCode")
    private String descCode;

    @JsonProperty(value = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty(value = "descCode")
    public String getDescCode() {
        return descCode;
    }

    public void setDescCode(String descCode) {
        this.descCode = descCode;
    }
}
