package aopdemo.dao;

import org.springframework.stereotype.Component;
/** Development process
        1. Create target object: AccountDAO
        2. Create Spring Java Config class*/
@Component
public class AccountDAO {
    public void addAccount(){
        System.out.println(getClass() + ": Doing my DB work: Adding an account");
    }
}
