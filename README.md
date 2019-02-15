# springmvc-hibernate-sandbox
* Customer Relationship Management (CRM)
* CRUD operations on customer entity using spring MVC + Hibernate

* In a web app, 
    1. List customers
    2. Add a new customer
    3. Update a customer
    4. Delete a customer
* Process flow
    * Customer Controller <-> Customer DAO (Responsible for interfacing with the database)
    * Customer Controller <-> View
    * We pass around model(data) from Customer DAO <-> Database
* Customer DAO
    * saveCustomer()
    * getCustomer()
    * getCustomers()
    * updateCustomer()
    * deleteCustomer()
* List customers
    * POJO(Entity class Customer)
    * CustomerDAO
    * CustomerController
    * list-customer.jsp
* Service layer design pattern
    * using @Service annotation applied to service implementation
        1. Define the service interface
        2. Define the service implementation
            * Inject the CustomerDAO
* Add customer
    * Update list-customer
        * New "add customer" button
    * Create HTML form for new customer
    * Process Form data
        * Controller<->Service<->DAO
    * sort the data displayed
* Update customer
    * update link to each customer
        * using customer id
    * Pre-populate the form to update the form
        * using the id to fetch data from DB and populate the form
    * Controller<->Customer Service<->Customer DAO
    * Two ways to perform save
        * save -> INSERT new record
        * update -> UPDATE existing record
        * saveOrUpdate if(primaryKey) empty then INSERT new customer else UPDATE existing customer
# Spring configure
* [Use these files](https://github.com/ranjithkumarravikumar52/springmvc-starter-files) to jump start the configuration
* The above files contain pom.xml which has overridden default maven plugins which avoids the problem of ClassNotFoundException for mysql connector
* Make sure the artifact is Web Application: Exploded

# Issues
* Best way to setup my maven architecture is to use the default structure and manually restructure the project folders
* [@Web annotation couldn't resolve](https://stackoverflow.com/questions/26089902/webservlet-annotation-doesnt-work-with-tomcat-8)
    * min servlet-api version should be 3
* [Resources](https://stackoverflow.com/questions/19748980/spring-mvc-css-and-javascript-is-not-working-properly) folder stays in webapp folder not in java folder

# Credits
* Learned how to do these cool things from a [cool guy](https://www.udemy.com/user/chaddarby2/)
