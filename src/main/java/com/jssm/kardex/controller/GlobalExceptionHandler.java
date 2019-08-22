package com.jssm.kardex.controller;

import com.jssm.kardex.exception.CreateException;
import com.jssm.kardex.exception.ProductNotFoundException;
import com.jssm.kardex.exception.DeleteException;
import com.jssm.kardex.exception.UpdateException;
import com.jssm.kardex.util.ApiError;
import com.jssm.kardex.util.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({DeleteException.class})
    public ResponseEntity<ApiError> handleDeleteException(DeleteException ex){
        return new ResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, Constants.DELETE_ERROR), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ProductNotFoundException.class})
    public ResponseEntity<ApiError> handleProductNotFoundException(ProductNotFoundException ex){
        return new ResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, Constants.PRODUCT_NOT_FOUND_ERROR), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({UpdateException.class})
    public ResponseEntity<ApiError> handleUpdateException(UpdateException ex){
        return new ResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, Constants.UPDATE_ERROR), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({CreateException.class})
    public ResponseEntity<ApiError> handleUpdateException(CreateException ex){
        return new ResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, Constants.CREATE_ERROR), HttpStatus.BAD_REQUEST);
    }

}
