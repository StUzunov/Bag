package com.Bag.request;

public class ValidationResponse {
    private final boolean valid;

    private final String message;

    public static final ValidationResponse OK = new ValidationResponse(true, null);

    public ValidationResponse(boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }

    public boolean isValid() {
        return valid;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ValidationResponse{" +
                "valid=" + valid +
                ", message='" + message + '\'' +
                '}';
    }
}
