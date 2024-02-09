package com.codigo.feign.controller;

import com.codigo.feign.aggregates.request.TipoDocumentoRequest;
import com.codigo.feign.aggregates.response.BaseResponse;
import com.codigo.feign.service.TipoDocumentoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tipodocumento")
public class TipoDocumentoController {
    private final TipoDocumentoService tipoDocumentoService;

    public TipoDocumentoController(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    @PostMapping("/crear")
    public BaseResponse crearTipoDocumento(@RequestBody TipoDocumentoRequest request){
        return tipoDocumentoService.crearTipoDocumento(request);
    }

    @GetMapping("/buscar")
    public BaseResponse findAllTipoDocumento(){
        return tipoDocumentoService.findAllTipoDoc();
    }
}
