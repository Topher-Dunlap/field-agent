
# Field Agent


### Time Estimations
* Security Clearance Slice: Actual Hours - 10 hours
* Aliases Slice: Actual Hours - 6 hours
* Global Error Handling: 1.5
* TOTAL = 17.5 hours

### Actual Time
* Security Clearance Slice: Actual Hours - 
* Aliases Slice: Actual Hours -
* Global Error Handling: Actual Hours -



## Set Up

**Project Set Up**

* [x] Download and build project
* [x] Add .gitignore additions
* [x] Add readme.md file
* [x] Create Github repo
* [x] Push unaltered project
* [ ] Explore codebase

## Security Clearance Slices
**findAll()**
* [ ] Create the `SecurityController`
* [ ] Create the `SecurityClearanceService`
* [ ] Define the `SecurityClearanceJdbcTemplateRepository` findAll()
* [ ] Define the `SecurityClearanceService` findAll()
* [ ] Define the `SecurityController` findAll()
* [ ] Create HTTP request.
* [ ] Create the `Data` findAll() Tests
* [ ] Create the `Domain` findAll() Tests

**findByID()**
* [ ] Define the `SecurityClearanceJdbcTemplateRepository` findById()
* [ ] Define the `SecurityClearanceService` findById()
* [ ] Define the `SecurityController` findById()
* [ ] Create HTTP request.
* [ ] Create the `Data` findById() Tests
* [ ] Create the `Domain` findById() Tests

**add()**
* [ ] Define the `SecurityClearanceJdbcTemplateRepository` add()
* [ ] Define the `SecurityClearanceService` add()
* [ ] Define the `SecurityController` add()
* [ ] Create HTTP request.
* [ ] Create the `Data` add() Tests
* [ ] Create the `Domain` add() Tests

**update()**
* [ ] Define the `SecurityClearanceJdbcTemplateRepository` update()
* [ ] Define the `SecurityClearanceService` update()
* [ ] Define the `SecurityController` update()
* [ ] Create HTTP request.
* [ ] Create the `Data` update() Tests
* [ ] Create the `Domain` update() Tests

**delete()**
* [ ] Develop strategy for delete()
* [ ] Define the `SecurityClearanceJdbcTemplateRepository` delete()
* [ ] Define the `SecurityClearanceService` delete()
* [ ] Define the `SecurityController` delete()
* [ ] Create HTTP request.
* [ ] Create the `Data` delete() Tests
* [ ] Create the `Domain` delete() Tests



## Aliases Slices
**Fetch Agent**
* [ ] Fetch an individual agent with aliases attached

**add()**
* [ ] Define the `AgentJdbcTemplateRepository` add()
* [ ] Define the `AgentService` add()
* [ ] Define the `AgentController` add()
* [ ] Create HTTP request.
* [ ] Create the `Data` add() Tests
* [ ] Create the `Domain` add() Tests

**update()**
* [ ] Define the `AgentJdbcTemplateRepository` update()
* [ ] Define the `AgentService` update()
* [ ] Define the `AgentController` update()
* [ ] Create HTTP request.
* [ ] Create the `Data` update() Tests
* [ ] Create the `Domain` update() Tests

**delete()**
* [ ] Define the `AgentJdbcTemplateRepository` delete()
* [ ] Define the `AgentClearanceService` delete()
* [ ] Define the `AgentController` delete()
* [ ] Create HTTP request.
* [ ] Create the `Data` delete() Tests
* [ ] Create the `Domain` delete() Tests

## Global Error Handling
* [ ] Use the @ControllerAdvice annotation to register an exception handler for all controllers.
* [ ] Determine the most precise exception for data integrity failures and handle it with a specific data integrity message.
* [ ] For all other exceptions, create a general "sorry, not sorry" response that doesn't share exception details.
