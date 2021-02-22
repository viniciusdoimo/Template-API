package com.viniciusdoimo.template.api.response;

import com.viniciusdoimo.template.api.utils.enums.EnumTypeError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
public class Response<T> {

    private T data;
    private List<Error> errors;

    public Response() {
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public List<Error>getErrors() {
        if (errors == null) {
            errors = new ArrayList<>();
        }
        return errors;
    }

    public void addError(EnumTypeError typeError, String cause) {
        this.getErrors().add(new Error(typeError.getTypeItem(), cause));
    }

    public void addAllErrors(HashMap<EnumTypeError, String> hashMapErros) {
        hashMapErros.forEach(this::addError);
    }

}
