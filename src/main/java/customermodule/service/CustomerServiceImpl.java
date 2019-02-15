package customermodule.service;

import customermodule.dao.CustomerDAO;
import customermodule.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//spring will scan this using component scanning
@Service
public class CustomerServiceImpl implements CustomerService {

    //inject customerDAO
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional //the whole point of our service layer is to put transactions over here instead of directly onto DAO implementation
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        return customerDAO.getCustomer(theId);
    }
}
