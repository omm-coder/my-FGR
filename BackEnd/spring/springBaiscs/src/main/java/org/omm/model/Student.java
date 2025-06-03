package org.omm.model;



import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.omm.validation.AddressCriteria;

import org.omm.validation.NameCriteria;

import java.sql.Date;


@Data
public class Student {

    private int student_id;
    @NameCriteria(lower = 13,upper = 23, message = "name should be character between" +
            "{lower}-{upper}")
    private String student_name;
    @NotNull(message = "Please select One option")
    private String Student_gender;
    private String student_phone;
    @AddressCriteria
    private String student_address;
    private Date date_entry;


}

