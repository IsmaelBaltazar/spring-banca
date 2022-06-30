package com.nttdata.banca.model.document;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customers")
public class PersonalCustomer{
    @Transient
    public static final String SEQUENCE_NAME = "personal_sequence";
    private String name;
    private String lastname;
    private String dni;
}
