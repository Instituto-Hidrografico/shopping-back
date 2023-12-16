package com.institutohidrografico.shopping.exception.annotation;

import com.institutohidrografico.shopping.persistence.payload.request.DTORequestUser;
import com.institutohidrografico.shopping.service.ServiceUserEntity;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.annotation.*;

import static com.institutohidrografico.shopping.exception.Validator.isNull;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { UniqueUsername.ValidatorUniqueUsername.class })
@Documented
public @interface UniqueUsername {

    String message() default "{unique.user.name}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    public class ValidatorUniqueUsername implements ConstraintValidator<UniqueUsername, DTORequestUser> {

        @Autowired
        private ServiceUserEntity serviceUserEntity;

        @Override
        public void initialize(UniqueUsername constraintAnnotation) {
        }
        @Override
        public boolean isValid(DTORequestUser value, ConstraintValidatorContext context) {
            if (!isNull(value.getUsername()) && !serviceUserEntity.existsByName(value.getUsername()) ||
                    !isNull(value.getUsername()) && !isNull(value.getId()) && !serviceUserEntity.existsByNameAndIdNot(value.getUsername(), value.getId()) ) {
                return true;
            } else {
                return false;
            }
        }
    }
}