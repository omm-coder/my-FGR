package org.omm.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {

    private Long id;
    private String doorNo;
    private String streetName;
    private String areaName;
    private String state;
    private String country;
    private String zipCode;


}
