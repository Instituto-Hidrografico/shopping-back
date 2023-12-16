package com.institutohidrografico.shopping.exception.annotation;

import com.institutohidrografico.shopping.persistence.payload.request.DTORequestFood;
import com.institutohidrografico.shopping.service.ServiceFood;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.annotation.*;

import static com.institutohidrografico.shopping.exception.Validator.isNull;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { UniqueNameFood.ValidatorUniqueNameFood.class })
@Documented
public @interface UniqueNameFood {

    String message() default "{unique.name.food}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    public class ValidatorUniqueNameFood implements ConstraintValidator<UniqueNameFood, DTORequestFood> {

        @Autowired
        private ServiceFood serviceFood;

        @Override
        public void initialize(UniqueNameFood constraintAnnotation) {
        }
        @Override
        public boolean isValid(DTORequestFood value, ConstraintValidatorContext context) {
            if (!isNull(value.getName()) && !serviceFood.existsByName(value.getName()) ||
                    !isNull(value.getName()) && !isNull(value.getId()) && !serviceFood.existsByNameAndIdNot(value.getName(), value.getId()) ) {
                return true;
            } else {
                return false;
            }
        }
    }
}