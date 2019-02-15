package customermodule.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    //setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    /**
     * Pointcut declarations for controller, service, DAO
     */


    //controller
    @Pointcut("execution(* customermodule.controller.*.*(..))")
    private void forControllerPackage(){}

    //service
    @Pointcut("execution(* customermodule.service.*.*(..))")
    private void forServicePackage(){}

    //DAO
    //service
    @Pointcut("execution(* customermodule.dao.*.*(..))")
    private void forDAOPackage(){}


    //special combine
    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow(){}

    //add @Before
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        //display method we are calling
        String methodSignature = joinPoint.getSignature().toShortString();
        logger.info("====> in @Before: calling method: "+methodSignature);

        //display the arguments to the method

    }




    //add @After
}
