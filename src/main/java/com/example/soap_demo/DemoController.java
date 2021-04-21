package com.example.soap_demo;

import com.example.soap_demo.model.NumberToWords;
import com.example.soap_demo.model.NumberToWordsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    SOAPConnector soapConnector;

    @GetMapping("/{number}")
    public String getStuff(@PathVariable String number) {
        NumberToWords numberToWords = new NumberToWords();
        numberToWords.setUbiNum(number);

        String url = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso";

        NumberToWordsResponse response = (NumberToWordsResponse) soapConnector.callWebService(url, numberToWords);

        return response.getNumberToWordsResult();
    }
}
