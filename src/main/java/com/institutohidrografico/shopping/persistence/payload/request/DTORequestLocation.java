package com.institutohidrografico.shopping.persistence.payload.request;

import com.institutohidrografico.shopping.exception.annotation.UniqueNameCountry;
import lombok.Getter;
import org.locationtech.jts.geom.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @UniqueNameCountry
public class DTORequestLocation {

    private UUID id;
    private LocalDateTime localDateTime;
    private Point point;
    private LineString lineString;
    private Polygon polygon;
    private MultiPolygon multiPolygon;
}