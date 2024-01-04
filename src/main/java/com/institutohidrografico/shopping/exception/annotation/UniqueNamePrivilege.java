package com.institutohidrografico.shopping.exception.annotation;

import com.institutohidrografico.shopping.persistence.payload.request.DTORequestPrivilege;
import com.institutohidrografico.shopping.service.ServicePrivilege;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.annotation.*;

import static com.institutohidrografico.shopping.exception.Validator.isNull;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { UniqueNamePrivilege.ValidatorUniqueNamePrivilege.class })
@Documented
public @interface UniqueNamePrivilege {

    String message() default "{unique.name.privilege}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    class ValidatorUniqueNamePrivilege implements ConstraintValidator<UniqueNamePrivilege, DTORequestPrivilege> {

        @Autowired
        private ServicePrivilege servicePrivilege;

        @Override
        public boolean isValid(DTORequestPrivilege value, ConstraintValidatorContext context) {
            return !isNull(value.getName()) && !servicePrivilege.existsByName(value.getName()) ||
                    !isNull(value.getName()) && !isNull(value.getId()) && !servicePrivilege.existsByNameAndIdNot(value.getName(), value.getId());
        }
    }
}