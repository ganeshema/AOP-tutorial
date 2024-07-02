// Import necessary classes
package com.ganeshgc.aoppracticeprojecttutorial.aspect;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect // Mark the class as an Aspect
@Component // Register the class as a Spring component
public class LoggingAspect {

    // Initialize the logger
    Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // Define a pointcut expression
    @Pointcut(value = "execution(* com.ganeshgc.aoppracticeprojecttutorial..*.*(..))")
    public void myPointCut() {
        // Pointcut method body is empty because it is just a marker for the pointcut expression
    }

    // Define an around advice
    @Around("myPointCut()")
    public Object applicationLogger(ProceedingJoinPoint joinPoint) throws Throwable {
        ObjectMapper objectMapper = new ObjectMapper(); // Create an ObjectMapper instance for JSON conversion
        String methodName = joinPoint.getSignature().getName(); // Get the name of the method being called
        String className = joinPoint.getTarget().getClass().toString(); // Get the class name where the method is defined
        Object[] args = joinPoint.getArgs(); // Get the arguments passed to the method

        // Log the method invocation with arguments before execution
        LOGGER.info("method Invoked " + className + ":" + methodName + "()" + " Arguments : " + objectMapper.writeValueAsString(args));

        // Proceed with the method execution
        Object result = joinPoint.proceed(args);

        // Log the method invocation with arguments after execution
        LOGGER.info("method Invoked " + className + ":" + methodName + "()" + " Arguments : " + objectMapper.writeValueAsString(args));

        return result; // Return the result of the method execution
    }
}
