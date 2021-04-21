package com.example.soap_demo.model;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "NumberToWordsResult"
})
@XmlRootElement(name = "NumberToWordsResponse")
public class NumberToWordsResponse {
    @XmlElement(name = "NumberToWordsResult", required = true)
    private String NumberToWordsResult;
}
