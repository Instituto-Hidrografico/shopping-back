package com.institutohidrografico.shopping.persistence.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;
import org.locationtech.jts.geom.*;

@Getter @AllArgsConstructor
public class DTOResponseLocation {

    private UUID id;
    private LocalDateTime localDateTime;
    private Point point;
    private LineString lineString;
    private Polygon polygon;
    private MultiPolygon multiPolygon;
}