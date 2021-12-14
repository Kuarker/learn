package com.kuarker.learn.advice;

import com.kuarker.common.vo.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-12-13
 **/
@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public R errorHandler(Exception ex) {
        return R.error(ex.getMessage());
    }

//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView errorHandler(Exception ex) {
//
//        ModelAndView view = new ModelAndView();
//        view.setViewName("/error");
//        return view;
//    }

}
