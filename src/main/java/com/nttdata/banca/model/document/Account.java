package com.nttdata.banca.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "accounts")
public class Account {
    @Transient
    public static final String SEQUENCE_NAME = "account_sequence";

    @Id
    private long idAccount;
    private long idCustomer;
    private String number;
    private PasiveAccount pasiveAccount;
    private ActiveAccount activeAccount;
}
