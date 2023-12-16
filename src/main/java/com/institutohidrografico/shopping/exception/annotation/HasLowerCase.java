package com.institutohidrografico.shopping.exception.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import java.lang.annotation.*;

import static com.institutohidrografico.shopping.exception.Validator.hasLowerCase;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { HasLowerCase.ValidatorHasLowerCase.class })
@Documented
public @interface HasLowerCase {

    String message() default "{has.lower.case}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    public class ValidatorHasLowerCase implements ConstraintValidator<HasLowerCase, String> {

        @Override
        public void initialize(HasLowerCase constraintAnnotation) {
        }
        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            if (hasLowerCase(value)) {
                return true;
            } else {
                return false;
            }
        }
    }
}