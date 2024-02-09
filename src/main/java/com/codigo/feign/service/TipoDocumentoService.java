package com.codigo.feign.service;

import com.codigo.feign.aggregates.request.TipoDocumentoRequest;
import com.codigo.feign.aggregates.response.BaseResponse;

public interface TipoDocumentoService {
    BaseResponse crearTipoDocumento(TipoDocumentoRequest tipoDocumentoRequest);
    BaseResponse findAllTipoDoc();

}
