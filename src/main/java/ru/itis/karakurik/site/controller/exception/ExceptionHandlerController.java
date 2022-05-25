package ru.itis.karakurik.site.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionHandlerController {


    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ModelAndView forbidden() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("exception/access_denied");
        return mav;
    }


//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public String serverException() {
//        log.error("Server error");
//        return "exception/exception_page";
//    }

//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    @ExceptionHandler(HttpClientErrorException.Forbidden.class)
//    public String forbidden(ModelMap map, HttpClientErrorException.Forbidden exception) {
////        log.error("forbidden");
//        map.put("exception", exception);
//        return "exception/exception";
//    }

//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(NotFoundException.class)
//    public String notFoundException(ModelMap map, NotFoundException exception) {
////        log.error(exception.getClassName() + " not found");
//        map.put("exception", exception);
//        return "exception/exception";
//    }

    ////    @ResponseStatus(HttpStatus.NOT_FOUND)
////    @ExceptionHandler()
////    public ModelAndView notFoundException(Exception exception) {
////        ModelAndView mav = new ModelAndView();
////        mav.addObject("exception", exception);
////        mav.setViewName("exception/exception_not_found");
////        return mav;
////    }
//
//    @ExceptionHandler(Throwable.class)
//    @ResponseBody
//    public String handleError(Throwable throwable) {
//        log.error(throwable.toString());
//        log.error(throwable.getMessage());
//        return "Неизвестная ошибка";
//    }
//
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleError(Exception ex) {
        return "Неизвестная ошибка";
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public String handleError() {
        return "Неизвестная ошибка";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public String _404Exception(NoHandlerFoundException e) {
        return "exception/exception";
    }
}
