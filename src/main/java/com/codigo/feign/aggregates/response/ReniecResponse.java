package com.codigo.feign.aggregates.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReniecResponse {
    private String nombres;
    private String apellidoPaterno;
    private String tipoDocumento;
    private String numeroDocumento;
    private String digitoVerificador;
}