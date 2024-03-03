package com.institutohidrografico.shopping.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.postgis.jdbc.geometry.MultiPolygon;
import net.postgis.jdbc.geometry.Point;
import net.postgis.jdbc.geometry.Polygon;
import org.hibernate.envers.Audited;
import net.postgis.jdbc.geometry.*;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = true)
public class Location extends GenericEntity {

    @Column(columnDefinition = "geography")
    private Point point;
    @Column(columnDefinition = "geography")
    private LineString lineString;
    @Column(columnDefinition = "geography")
    private Polygon polygon;
    @Column(columnDefinition = "geography")
    private MultiPolygon multiPolygon;
}