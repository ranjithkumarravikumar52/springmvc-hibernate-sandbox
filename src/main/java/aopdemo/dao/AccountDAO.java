package aopdemo.dao;

import aopdemo.entity.Account;
import org.springframework.stereotype.Component;
/** Development process
        1. Create target object: AccountDAO
        2. Create Spring Java Config class*/
@Component
public class AccountDAO {
    public void addAccount(Account account){
        System.out.println("Adding new account into DB");
    }
    public void getAccount(Account account){
        System.out.println("Getting an existing account from DB");
    }
    public void updateAccount(Account account){
        System.out.println("Update existing account into DB");
    }
    public void removeAccount(Account account){
        System.out.println("Removing an account from DB");
    }

}
