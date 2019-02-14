package customermodule.controller;

import customermodule.dao.CustomerDAO;
import customermodule.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    // need to inject the customer dao
    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping("/list") //    @PostMapping("/list") //LOL
    public String listCustomers(Model theModel) {

        // get customers from the dao
        List<Customer> theCustomers = customerDAO.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }
}
