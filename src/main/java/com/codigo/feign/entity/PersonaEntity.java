package com.codigo.feign.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Timestamp;

@Entity
@Table(name = "persona")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long idPersona;

    @Column(name = "num_docu", nullable = false, length = 15)
    private String numDocu;

    @Column(name = "nombres", nullable = false, length = 150)
    private String nombres;

    @Column(name = "ape_pat", nullable = false, length = 150)
    private String apePat;

    @Column(name = "ape_mat", nullable = false, length = 150)
    private String apeMat;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @Column(name = "usua_crea", length = 45)
    private String usuaCrea;

    @Column(name = "date_create")
    private Timestamp dateCreate;

    @Column(name = "usua_modif", length = 45)
    private String usuaModif;

    @Column(name = "date_modif")
    private Timestamp dateModif;

    @Column(name = "usua_delet", length = 45)
    private String usuaDelet;

    @Column(name = "date_delet")
    private Timestamp dateDelet;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tipo_documento_id", nullable = false)
    private TipoDocumentoEntity tipoDocumento;
}
/*
id_persona SERIAL PRIMARY KEY,
num_docu VARCHAR(15) NOT NULL,
nombres VARCHAR(150) NOT NULL,
ape_pat VARCHAR(150) NOT NULL,
ape_mat VARCHAR(150) NOT NULL,
estado INT NOT NULL,
usua_crea VARCHAR(45),
date_create TIMESTAMP,
usua_modif VARCHAR(45),
date_modif TIMESTAMP,
usua_delet VARCHAR(45),
date_delet TIMESTAMP,
tipo_documento_id INT*/