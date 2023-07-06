package com.ShengQin.OneShot.ExceptionController;

import com.ShengQin.OneShot.Utils.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    //处理控制器的控制器异常
    @ExceptionHandler(NullPointerException.class)
    public String handleResourceNotFoundException(NullPointerException nullPointerException, HandlerMethod handlerMethod) {
        if (handlerMethod.getBeanType().getAnnotation(RestController.class) == null) throw nullPointerException;
        return Result.fail("缺少必要的参数",nullPointerException.getMessage());
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleException(Exception ex) {
//
//    }
}
