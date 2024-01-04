package com.institutohidrografico.shopping.exception.annotation;

import com.institutohidrografico.shopping.persistence.payload.request.DTORequestRole;
import com.institutohidrografico.shopping.service.ServiceRole;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.annotation.*;

import static com.institutohidrografico.shopping.exception.Validator.isNull;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { UniqueNameRole.ValidatorUniqueNameRole.class })
@Documented
public @interface UniqueNameRole {

    String message() default "{unique.name.role}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    public class ValidatorUniqueNameRole implements ConstraintValidator<UniqueNameRole, DTORequestRole> {

        @Autowired
        private ServiceRole serviceRole;

        @Override
        public boolean isValid(DTORequestRole value, ConstraintValidatorContext context) {
            return !isNull(value.getName()) && !serviceRole.existsByName(value.getName()) ||
                    !isNull(value.getName()) && !isNull(value.getId()) && !serviceRole.existsByNameAndIdNot(value.getName(), value.getId());
        }
    }
}