package com.institutohidrografico.shopping.exception.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import java.lang.annotation.*;

import static com.institutohidrografico.shopping.exception.Validator.hasUpperCase;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { HasUpperCase.ValidatorHasUpperCase.class })
@Documented
public @interface HasUpperCase {

    String message() default "{has.upper.case}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    public class ValidatorHasUpperCase implements ConstraintValidator<HasUpperCase, String> {

        @Override
        public void initialize(HasUpperCase constraintAnnotation) {
        }
        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            if (hasUpperCase(value)) {
                return true;
            } else {
                return false;
            }
        }
    }
}