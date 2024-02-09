package com.codigo.feign.service.implement;

import com.codigo.feign.aggregates.constants.Constants;
import com.codigo.feign.aggregates.request.EmpresaRequest;
import com.codigo.feign.aggregates.response.BaseResponse;
import com.codigo.feign.aggregates.response.SunatResponse;
import com.codigo.feign.feignclient.SunatClient;
import com.codigo.feign.repository.EmpresaRepository;
import com.codigo.feign.service.EmpresaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaImpl implements EmpresaService {
    private final EmpresaRepository empresaRepository;

    private final SunatClient sunatClient;

    public EmpresaImpl(EmpresaRepository empresaRepository, SunatClient sunatClient) {
        this.empresaRepository = empresaRepository;
        this.sunatClient = sunatClient;
    }

    @Value("${token.api}")
    private String tokenApi;

    @Override
    public BaseResponse crearEmpresa(EmpresaRequest empresaRequest) {
        return null;
    }

    @Override
    public BaseResponse getInfoSunat(String numero) {
        SunatResponse response = getExecute(numero);
        if(response != null){
            return new BaseResponse(Constants.CODE_SUCCESS, Constants.MESS_SUCCESS, Optional.of(response));
        }
        return new BaseResponse(Constants.CODE_ERROR, Constants.MESS_ERROR, Optional.empty());
    }

    private SunatResponse getExecute(String numero){
        String token = "Bearer "+tokenApi;
        return sunatClient.getInfo(numero, token);
    }
}
