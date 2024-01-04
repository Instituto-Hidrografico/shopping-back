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
@Constraint(validatedBy = { UniqueEmail.ValidatorUniqueEmail.class })
@Documented
public @interface UniqueEmail {

    String message() default "{unique.email}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    public class ValidatorUniqueEmail implements ConstraintValidator<UniqueEmail, DTORequestUser> {

        @Autowired
        private ServiceUserEntity serviceUserEntity;

        @Override
        public boolean isValid(DTORequestUser value, ConstraintValidatorContext context) {
            if (!isNull(value.getEmail()) && !serviceUserEntity.existsByEmail(value.getEmail()) ||
                    !isNull(value.getEmail()) && !isNull(value.getId()) && !serviceUserEntity.existsByEmailAndIdNot(value.getEmail(), value.getId()) ) {
                return true;
            } else {
                return false;
            }
        }
    }
}