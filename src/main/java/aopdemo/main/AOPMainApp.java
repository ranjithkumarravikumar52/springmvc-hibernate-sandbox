package aopdemo.main;

import aopdemo.dao.AccountDAO;
import aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPMainApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(aopdemo.config.DemoConfig.class);

        //get the bean from the spring container (this bean is your target class)
        AccountDAO accountDAO = annotationConfigApplicationContext.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = annotationConfigApplicationContext.getBean("membershipDAO", MembershipDAO.class);

        //call the business method (target beans calls some method)
        //when AOP is done, you can see some shady stuff here. OoooOoooOOo
        accountDAO.addAccount(null);
        accountDAO.getAccount(null);
        accountDAO.removeAccount(null);
        accountDAO.removeAccount(null);

        membershipDAO.addMembership(null);
        membershipDAO.getMembership(null);
        membershipDAO.updateMembership(null);
        membershipDAO.removeMembership(null);


        //close the context cos I'm nice like that
        annotationConfigApplicationContext.close();
    }
}
