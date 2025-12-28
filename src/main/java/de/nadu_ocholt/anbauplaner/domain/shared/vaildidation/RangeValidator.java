package de.nadu_ocholt.anbauplaner.domain.shared.vaildidation;


import de.nadu_ocholt.anbauplaner.domain.plant.RangeCm;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RangeValidator implements ConstraintValidator<ValidRange, RangeCm> {


    @Override
    public boolean isValid(RangeCm rangeCm, ConstraintValidatorContext constraintValidatorContext) {
        if (rangeCm == null) return true;

        return rangeCm.getMin().doubleValue() <= rangeCm.getMax().doubleValue();
    }
}
