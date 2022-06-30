package com.nttdata.banca.model.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import springfox.documentation.swagger.schema.ApiModelBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customers")
@ApiModel
public class Customer {
    @Transient
    public static final String SEQUENCE_NAME = "customer_sequence";
    @Id
    @ApiModelProperty(position = 1)
    private long idCustomer;
    @ApiModelProperty(example = "Lima")
    private String city;
    @ApiModelProperty(example = "false", dataType = "boolean")
    private Boolean deleteState;
    @ApiModelProperty("Av. Example 000 Los Olivos")
    private String address;
    @ApiModelProperty(example = "personal")
    private String type;//personal or enterprise
    private EnterpriseCustomer enterpriseCustomer;
    private PersonalCustomer personalCustomer;

}

