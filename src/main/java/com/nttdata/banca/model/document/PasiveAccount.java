package com.nttdata.banca.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasiveAccount {
    private String type;//Ahorro - Cuenta Corriente - Plazo fijo
    private boolean commission;
    private boolean movementLimit;
    private Float amount;
    private int limit;
    private String dateMovement;//Only for Plazo Fijo
}
