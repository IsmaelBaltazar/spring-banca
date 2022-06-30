package com.nttdata.banca.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiveAccount {
    private String type;//Personal - Empresarial
    private int limit;
    private Float amount;
}
