package com.geometry.common.enums;

/**
 * Application Exception.
 *
 * @author Volodymyr Lykhvar
 */
public enum ApplicationException {

    JSON_PROCESSING("error_json_processing", "Error during json processing."),
    INTERNAL_ERROR("internal_error", "Internal server error happened."),
    INVALID_REQUEST_ARGUMENT("error_invalid_request_argument", "Invalid request argument.");

    private final String code;
    private final String text;

    ApplicationException(String code, String text) {
        this.text = text;
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public String getCode() {
        return code;
    }
}
