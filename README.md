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
* Delete customer
    * Prompt me before delete (cos you never know)
    * Each row has a delete link
    * Get the updated ones back to our list
    * Controller<->Customer Service<->Customer DAO (same as earlier)
***
* AOP (using psvm() for now)
    * Code Tangling
    * Code scattering
    * possible solutions?
        * Inheritance
        * Delegation
* Cross-cutting concerns
* Updated process
    * logging<->security<->controller<->logging<->security<->service<->logging<->security<->DAO<->DB
    * Done using Proxy design pattern
* Difference between Spring AOP vs AspectJ? Start with Spring AOP and later move to AspectJ
* Dependency? We need both Spring AOP and AspectJ
    * Spring AOP is lightweight compared to AspectJ
* Advice 
    * @Before
    * @AfterReturning
        * Use cases: Logging, security, transactions(member @Transaction? I member!)
        * Audit logging
        * API management
* Development process
    1. Create target object: AccountDAO
    2. Create Spring Java Config class
    3. Create main app and call the target bean method
    4. Create an Aspect with @Before advice
* Be aware of absolute path names for pointcut expressions
    * By return type, package, class name, method name, method parameters
    *Spring AOP supports only public and * modifiers
* Re-use pointcut expressions?
    * Copy/paste? not ideal
    1. Create a pointcut declarations
    2. Apply to multiple advices
* Share and combine pointcut declarations
    * logical operators AND, OR, NOT
    * if(expr1() && expr2())
* Order of advices
    * Unordered based on spring aop
    * however it can refactored to be ordered using @Order annotation
    * @Order(1), @Order(2) ... class level annotation (visualize it as boarding a flight, this will help a lot to understand)
    * lower numbers have higher preference
* Don't make your aspect class too fat
* How do we read method arguments?
    * Access(With JoinPoints) and display method signature (joinPoints.getMethodSignature())
    * Access(With JoinPoints) and display method arguments (joinPoints.getMethodArguments())


# Spring configuration guide
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
