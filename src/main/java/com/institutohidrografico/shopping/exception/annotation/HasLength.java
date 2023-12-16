package com.institutohidrografico.shopping.exception.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import java.lang.annotation.*;

import static com.institutohidrografico.shopping.exception.Validator.hasLength;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { HasLength.ValidatorHasLength.class })
@Documented
public @interface HasLength {

    String message() default "{has.length}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    public class ValidatorHasLength implements ConstraintValidator<HasLength, String> {

        @Override
        public void initialize(HasLength constraintAnnotation) {
        }
        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            if (hasLength(8, value)) {
                return true;
            } else {
                return false;
            }
        }
    }
}