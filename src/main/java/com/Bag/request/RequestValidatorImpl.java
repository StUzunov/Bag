package com.Bag.request;

import org.springframework.stereotype.Component;

@Component
public class RequestValidatorImpl implements RequestValidator {

    @Override
    public void validate(final Validated target) throws Exception {
        final ValidationResponse validationResponse = target.validate();

        if (!validationResponse.isValid()) {
            throw new Exception(validationResponse.getMessage());
        }
    }
}