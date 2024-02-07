package com.institutohidrografico.shopping.exception.annotation;

import com.institutohidrografico.shopping.exception.Validator;
import com.institutohidrografico.shopping.persistence.payload.request.DTORequestCountry;
import com.institutohidrografico.shopping.service.ServiceCountry;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { UniqueNameCountry.ValidatorUniqueNameCountry.class })
@Documented
public @interface UniqueNameCountry {

    String message() default "{unique.name.country}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    public class ValidatorUniqueNameCountry implements ConstraintValidator<UniqueNameCountry, DTORequestCountry> {

        @Autowired
        private ServiceCountry serviceCountry;

        @Override
        public void initialize(UniqueNameCountry constraintAnnotation) {
        }
        @Override
        public boolean isValid(DTORequestCountry value, ConstraintValidatorContext context) {
            if (!Validator.isNull(value.getName()) && !serviceCountry.existsByName(value.getName()) ||
                    !Validator.isNull(value.getName()) && !Validator.isNull(value.getId()) && !serviceCountry.existsByNameAndIdNot(value.getName(), value.getId()) ) {
                return true;
            } else {
                return false;
            }
        }
    }
}