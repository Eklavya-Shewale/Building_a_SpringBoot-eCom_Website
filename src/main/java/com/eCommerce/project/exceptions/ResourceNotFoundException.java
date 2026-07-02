package com.eCommerce.project.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    String resourceName;
    String fieldName;
    long fieldValue;
    String field;

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(Throwable cause, String fieldName, String resourceName, String field) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, field), cause);
        this.fieldName = fieldName;
        this.resourceName = resourceName;
        this.field = field;
    }

    public ResourceNotFoundException(Throwable cause, String resourceName, String field, long fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, field, fieldValue), cause);
        this.resourceName = resourceName;
        this.field = field;
        this.fieldValue = fieldValue;
    }
}
