package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    //this is where we add all of our related advices for logging

    /**
     * starting with an @Before advice
     * pointcut expression language: "execution(public void addAccount())"
     * but the below will match any addAccount() in any class, to avoid that put down the fully qualified name
     */
    /*@Before("execution(* add*(..))")
    public void beforeAddAccountAdvice() {
        System.out.print("========== Executing @Before advice on addAccount()");
    }*/
    /**
     * Match on method name using wildcards
     * starting with add in any class
     * @Before("execution(public void add*())")
     */


    /**
     * Match on method name using wildcards
     * start with processCreditCard in any class
     * processCreditCard*()
     */

    /**
     * Using wildcards on modifier and return type
     * Any modifier and any return type
     * @Before("execution(*  * processCredit*()")
     *
     *
     * Modifier is optional
     *
     */

    /**
     * any updateAccount()
     */
    /*@Before("execution(public void updateAccount())")
    public void beforeUpdateAccountAdvice() {
        System.out.println();
        System.out.println("==========");
        System.out.println("Executing @Before advice on updateAccount()");
        System.out.println("==========");
        System.out.println();
    }*/


    /**
     * Using Pointcut declarations
     * Get me all the C from CRUD
     */
    @Pointcut("execution(public void add*(..))")
    private void forCFromCRUD(){}

    @Before("forCFromCRUD()")
    public void beforeAddAnyWhere(){
        System.out.println("\n==========> Executing @Before advice on any method with add*() <==========");
    }


}
