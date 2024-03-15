package com.institutohidrografico.shopping.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.locationtech.jts.geom.Point;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = true)
public class LocalChart extends Chart {

    private String name;
    private String areaType; //[ ACESSO | PORTOS | TERMINAIS ]
    @Column(columnDefinition = "geography")
    private Point point;
}