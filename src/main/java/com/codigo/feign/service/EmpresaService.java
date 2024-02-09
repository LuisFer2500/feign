package com.codigo.feign.service;

import com.codigo.feign.aggregates.request.EmpresaRequest;
import com.codigo.feign.aggregates.response.BaseResponse;
import com.codigo.feign.aggregates.response.SunatResponse;
import com.codigo.feign.entity.EmpresaEntity;

public interface EmpresaService {
    BaseResponse crearEmpresa(EmpresaRequest empresaRequest);

    BaseResponse getInfoSunat(String numero);
}
