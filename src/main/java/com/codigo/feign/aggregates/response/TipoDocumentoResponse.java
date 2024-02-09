package com.codigo.feign.aggregates.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocumentoResponse {
    private Long idTipoDocumento;
    private String codTipo;
    private String descTipo;
    private Integer estado;
}
