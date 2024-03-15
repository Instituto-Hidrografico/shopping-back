package com.institutohidrografico.shopping.persistence.model;

import com.institutohidrografico.shopping.persistence.GenericAuditEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = true)
public class ChartArea extends GenericAuditEntity {

    private String name;
}
