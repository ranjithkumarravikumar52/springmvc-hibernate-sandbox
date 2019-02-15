package aopdemo.main;

import aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPMainApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(aopdemo.config.DemoConfig.class);

        //get the bean from the spring container (this bean is your target class)
        AccountDAO accountDAO = annotationConfigApplicationContext.getBean("accountDAO", AccountDAO.class);

        //call the business method (target beans calls some method)
        //when AOP is done, you can see some shady stuff here. OoooOoooOOo
        accountDAO.addAccount();
        accountDAO.addAccount();

        //close the context cos I'm nice like that
        annotationConfigApplicationContext.close();
    }
}
