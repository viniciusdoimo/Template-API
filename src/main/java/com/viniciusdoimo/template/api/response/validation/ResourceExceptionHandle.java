package com.viniciusdoimo.template.api.response.validation;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.viniciusdoimo.template.api.response.Response;
import com.viniciusdoimo.template.api.utils.enums.EnumTypeError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
@ControllerAdvice
public class ResourceExceptionHandle {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<String>> handle(MethodArgumentNotValidException exception) {
        Response<String> response = new Response<>();
        response.setData("");
        exception.getBindingResult().getFieldErrors().forEach(e ->
                response.addError(EnumTypeError.FIELD_INVALID, e.getField() + ": " + e.getDefaultMessage()));
        return ResponseEntity.badRequest().body(response);
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<Response<String>> handle(HttpMessageConversionException exception) {
        if (exception instanceof HttpMessageNotReadableException) {
            return getResponseInstance(EnumTypeError.JSON_INVALID, exception.getCause().getMessage());
        }
        return getResponseInstance(EnumTypeError.JSON_INVALID,
                "Json read error: " + exception.getCause().getMessage());
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<Response<String>> handle(JsonProcessingException exception) {
        if (exception instanceof JsonMappingException || exception instanceof JsonParseException) {
            return getResponseInstance(EnumTypeError.JSON_INVALID,
                    "Error converter json:" + exception.getCause().getMessage());
        }
        return getResponseInstance(EnumTypeError.JSON_INVALID, "Json read error");
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Response<String>> handle(MissingServletRequestParameterException exception) {
        return getResponseInstance(EnumTypeError.JSON_INVALID,
                "Mandatory parameter: " + exception.getParameterName());
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<String>> handle(Exception ex) {
        ex.printStackTrace();
        return getResponseInstance(EnumTypeError.ERROR,
                "Exception Generic: " + ex.getMessage());
    }

    private ResponseEntity<Response<String>> getResponseInstance(EnumTypeError typeError, String message) {
        Response<String> response = new Response<>();
        response.setData("");
        response.addError(typeError, message);
        return ResponseEntity.badRequest().body(response);
    }
}
