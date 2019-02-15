package aopdemo.dao;

import aopdemo.entity.Account;
import aopdemo.entity.Membership;
import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public void addMembership(Membership membership){
        System.out.println("Adding new membership into DB Membership");
    }
    public void getMembership(Membership membership){
        System.out.println("Getting an existing membership from DB Membership");
    }
    public void updateMembership(Membership membership){
        System.out.println("Update existing membership into DB Membership");
    }
    public void removeMembership(Membership membership){
        System.out.println("Removing an membership from DB Membership");
    }
}
