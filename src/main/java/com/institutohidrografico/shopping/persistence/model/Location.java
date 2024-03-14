package com.institutohidrografico.shopping.persistence.model;

import com.institutohidrografico.shopping.persistence.GenericAuditEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.locationtech.jts.geom.*;

import java.time.LocalDateTime;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = true)
public class Location extends GenericAuditEntity {

    private LocalDateTime localDateTime;
    @Column(columnDefinition = "geography")
    private Point point;
    @Column(columnDefinition = "geography")
    private LineString lineString;
    @Column(columnDefinition = "geography")
    private Polygon polygon;
    @Column(columnDefinition = "geography")
    private MultiPolygon multiPolygon;
}