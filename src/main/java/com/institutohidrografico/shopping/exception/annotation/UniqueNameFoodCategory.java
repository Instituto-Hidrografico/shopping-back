package com.institutohidrografico.shopping.exception.annotation;

import com.institutohidrografico.shopping.persistence.payload.request.DTORequestFoodCategory;
import com.institutohidrografico.shopping.service.ServiceFoodCategory;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.annotation.*;

import static com.institutohidrografico.shopping.exception.Validator.isNull;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { UniqueNameFoodCategory.ValidatorUniqueNameFoodCategory.class })
@Documented
public @interface UniqueNameFoodCategory {

    String message() default "{unique.name.food.category}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    class ValidatorUniqueNameFoodCategory implements ConstraintValidator<UniqueNameFoodCategory, DTORequestFoodCategory> {

        @Autowired
        private ServiceFoodCategory serviceFoodCategory;

        @Override
        public boolean isValid(DTORequestFoodCategory value, ConstraintValidatorContext context) {
            return !isNull(value.getName()) && !serviceFoodCategory.existsByName(value.getName()) ||
                    !isNull(value.getName()) && !isNull(value.getId()) && !serviceFoodCategory.existsByNameAndIdNot(value.getName(), value.getId());
        }
    }
}