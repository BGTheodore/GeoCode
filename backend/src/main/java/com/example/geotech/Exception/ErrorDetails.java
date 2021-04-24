package com.example.geotech.Exception;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "error")
public class ErrorDetails {
    private Date timestamp;
    //General error message about nature of error
    private String message;

    //Specific errors in API request processing
    private List<String> details;


public ErrorDetails(String message, List<String> details) {
    super();
    this.message = message;
    this.details = details;
}

}

