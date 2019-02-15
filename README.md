# Customer Relationship Management (CRM)

## CRUD operations

| Feature        | Operation           | CustomerDAO  |
| ------------- |:-------------:| -----:|
| List customers       | R | getCustomers() |
| Add a new customer       | C | saveCustomer() |
| Update a customer      | U      |   getCustomer(), updateCustomer() |
| Delete a customer | D      |    getCustomer(), deleteCustomer() |

### Process flow
* On our customer entity we are using spring MVC + Hibernate
* Customer Controller <-> Customer DAO (Responsible for interfacing with the database)
* Customer Controller <-> View
* We pass around model(data) from Customer DAO <-> Database

### List customers
* POJO(Entity class Customer)
* CustomerDAO
* CustomerController
* list-customer.jsp

### Add customer
* Update list-customer
    * New "add customer" button    
* Create HTML form for new customer
* Process Form data
    * Controller<->Service<->DAO
* sort the data displayed

### Update customer
* update link to each customer
    * using customer id
* Pre-populate the form to update the form
    * using the id to fetch data from DB and populate the form
* Controller<->Customer Service<->Customer DAO
* Two ways to perform save
    * save -> INSERT new record
    * update -> UPDATE existing record
    * saveOrUpdate if(primaryKey) empty then INSERT new customer else UPDATE existing customer

### Delete customer
* Prompt me before delete (cos you never know)
* Each row has a delete link
* Get the updated ones back to our list
* Controller<->Customer Service<->Customer DAO (same as earlier)
***
## Service layer design pattern
* using @Service annotation applied to service implementation
    1. Define the service interface
    2. Define the service implementation
        * Inject the CustomerDAO

***
## Spring AOP + Logger
* Adding AOP
* Till now we have our architecture something like this
    * View <-> Controller <-> Service <-> DAO <-> DB
* Using AOP, our architecture will evolve into something like this
    * @Before -> View -> @Before -> Controller -> @Before -> Service -> @Before -> DAO
    * @After <- View <- @After <- Controller <- @After <- Service <- @After <- DAO
* Create point cut declaration to match only the above layers (we dont include model for now)
***
## AOP overview
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
        * this gives an array of arguments, loop through them to display it or do any business logic on the type of arguments
***
* @AfterReturning:
    * Runs after the successful method execution and no exception
    * @AfterReturning(pointcut = "execution("")", returning = "result")
        * To display the return value 
    * Post processing
        * Modify data of the return value before we send it to the calling method
        * In other words, modified data is returned to the calling method
        * However we must be careful in doing this
***
* @AfterThrowing
    * runs after method if exception is thrown
    * easier to understand the process flow when a sequence diagram can be visualized
    * to access the execption
        * @AfterThrowing(pointcut="execution()", throwing = "theException")
        * Use JoinPoint to get any method values
    * exception is read in this whole aspect area, it is actually thrown when its reaching the calling method
***
* @After
    * runs regardless of sucess method completion but before returning value to calling method (Visualize in sequence diagram)
    * for an exception, @after will execute before @afterthrowing, however it doesnt have an access to exception
***
* @Around
    * runs before and after method execution
    * combination of @Before and @After
    * pre-processing and post-processing data
    * Instrumentation/profiling code
        * How long does it take for a section of code to run?
    * Managing exceptions
        * swallow/hold/throw
    * The handle to target method is done using ProceedingJoinPoint
        * .proceed() to continue executing the main task
***
* Use java.util.logger.info(String s) instead sout to have everything printed to logger stream
    * This is to avoid two different output streams
    * spring uses logger and sout uses system
***


## Spring configuration guide
* [Use these files](https://github.com/ranjithkumarravikumar52/springmvc-starter-files) to jump start the configuration
* The above files contain pom.xml which has overridden default maven plugins which avoids the problem of ClassNotFoundException for mysql connector
* Make sure the artifact is Web Application: Exploded

## Issues
* Best way to setup my maven architecture is to use the default structure and manually restructure the project folders
* [@Web annotation couldn't resolve](https://stackoverflow.com/questions/26089902/webservlet-annotation-doesnt-work-with-tomcat-8)
    * min servlet-api version should be 3
* [Resources](https://stackoverflow.com/questions/19748980/spring-mvc-css-and-javascript-is-not-working-properly) folder stays in webapp folder not in java folder
* How to enable coloring to our logs? Or how is filtering done to log files?

## Credits
* Learned how to do these cool things from a [cool guy](https://www.udemy.com/user/chaddarby2/)
