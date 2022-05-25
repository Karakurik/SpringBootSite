package ru.itis.karakurik.site.aspects.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggerAspect {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterThrowing(pointcut = "execution(* ru.itis.karakurik.site.controller..*(..))", throwing = "ex")
    public void catchException(Exception ex) {
        logger.error("Error: ", ex);
    }

    @Pointcut("@annotation(ru.itis.karakurik.site.aspects.logging.Logger)")
    public void logAspectAnnotation() {
    }

    @Around("logAspectAnnotation()")
    public Object logControllers(ProceedingJoinPoint joinPoint) throws Throwable {

        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return logHelp(joinPoint, userDetails.getUsername(), className, methodName);
        } catch (Exception exception) {
            return logHelp(joinPoint, "unidentified user", className, methodName);
        }
    }

    public Object logHelp(ProceedingJoinPoint joinPoint, String userName, String className, String methodName) throws Throwable {
        logger.info(String.format("%s launch method %s in class %s", userName, methodName, className));
        Object retVal = joinPoint.proceed();
        logger.info(String.format("%s invoke method %s in class %s", userName, methodName, className));
        return retVal;
    }
}
