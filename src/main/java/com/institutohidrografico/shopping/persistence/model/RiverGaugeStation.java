package com.institutohidrografico.shopping.persistence.model;

import com.institutohidrografico.shopping.persistence.GenericAuditEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.locationtech.jts.geom.Point;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = true)
public class RiverGaugeStation extends GenericAuditEntity {

    private String title;
    private String chartArea;
    @Column(columnDefinition = "geography")
    private Point point;
}