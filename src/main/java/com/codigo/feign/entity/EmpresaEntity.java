package com.codigo.feign.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "empresa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Long idEmpresa;
    @Column(name = "num_docu")
    private String numDocu;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "nom_comercial")
    private String nomComercial;
    private int estado;
    @Column(name = "usua_crea")
    private String usuaCrea;
    @Column(name = "date_create")
    private Timestamp dateCreate;
    @Column(name = "usua_modif")
    private String usuaModif;
    @Column(name = "date_modif")
    private Timestamp dateModif;
    @Column(name = "usua_delet")
    private String usuaDelet;
    @Column(name = "date_delet")
    private Timestamp dateDelet;
    @ManyToOne
    @JoinColumn(name = "tipo_documento_id")
    private TipoDocumentoEntity tipoDocumentoId;
}
