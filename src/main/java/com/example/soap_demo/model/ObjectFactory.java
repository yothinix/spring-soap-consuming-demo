package com.example.soap_demo.model;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
    public ObjectFactory() { }

    public NumberToWords createNumberToWords() {
        return new NumberToWords();
    }

    public NumberToWordsResponse createNumberToWordsResponse() {
        return new NumberToWordsResponse();
    }
}
