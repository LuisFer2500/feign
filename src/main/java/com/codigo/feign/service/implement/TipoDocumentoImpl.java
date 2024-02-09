package com.codigo.feign.service.implement;

import com.codigo.feign.aggregates.constants.Constants;
import com.codigo.feign.aggregates.request.TipoDocumentoRequest;
import com.codigo.feign.aggregates.response.BaseResponse;
import com.codigo.feign.aggregates.response.TipoDocumentoResponse;
import com.codigo.feign.entity.TipoDocumentoEntity;
import com.codigo.feign.repository.TipoDocumentoRepository;
import com.codigo.feign.service.TipoDocumentoService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoDocumentoImpl implements TipoDocumentoService {
    private final TipoDocumentoRepository tipoDocumentoRepository;

    public TipoDocumentoImpl(TipoDocumentoRepository tipoDocumentoRepository) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }

    @Override
    public BaseResponse crearTipoDocumento(TipoDocumentoRequest tipoDocumentoRequest) {
        TipoDocumentoEntity tipoDocumento = tipoDocumentoRepository.findByCodTipo(tipoDocumentoRequest.getCodTipo());
        if(tipoDocumento == null){
            TipoDocumentoResponse response = new TipoDocumentoResponse();
            TipoDocumentoEntity entity = new TipoDocumentoEntity();
            entity.setCodTipo(tipoDocumentoRequest.getCodTipo());
            entity.setDescTipo(tipoDocumentoRequest.getDescTipo());
            entity.setEstado(1);
            entity.setDateCreate(getTimeStamp());
            entity.setUsuaCrea("Luis");

            TipoDocumentoEntity entityDB = tipoDocumentoRepository.save(entity);
            response.setIdTipoDocumento(entityDB.getIdTipoDocumento());
            response.setCodTipo(entityDB.getCodTipo());
            response.setDescTipo(entityDB.getDescTipo());
            response.setEstado(entityDB.getEstado());
            return new BaseResponse(Constants.CODE_SUCCESS, Constants.MESS_SUCCESS, Optional.of(response));
        }
        return new BaseResponse(Constants.CODE_ERROR, Constants.MESS_ERROR, Optional.empty());
    }

    @Override
    public BaseResponse findAllTipoDoc() {
        List<TipoDocumentoEntity> entityDB = tipoDocumentoRepository.findAll();
        if(!entityDB.isEmpty()){
            List<TipoDocumentoResponse> response = entityDB.stream().map(this::convertirTipoDocumentoResponse).collect(Collectors.toList());
            return new BaseResponse(Constants.CODE_SUCCESS, Constants.MESS_SUCCESS, Optional.of(response));
        }
        return new BaseResponse(Constants.CODE_ERROR, Constants.MESS_ERROR, Optional.empty());
    }

    private Timestamp getTimeStamp(){
        long currentTime =System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(currentTime);
        return timestamp;
    }

    private TipoDocumentoResponse convertirTipoDocumentoResponse(TipoDocumentoEntity entity){
        TipoDocumentoResponse response = new TipoDocumentoResponse();
        response.setIdTipoDocumento(entity.getIdTipoDocumento());
        response.setCodTipo(entity.getCodTipo());
        response.setDescTipo(entity.getDescTipo());
        response.setEstado(entity.getEstado());
        return response;
    }
}
