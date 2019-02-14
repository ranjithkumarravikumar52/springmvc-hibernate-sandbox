package customermodule.dao;

import customermodule.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();
}
