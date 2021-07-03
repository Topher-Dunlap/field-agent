
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
* [x] Carry over inserts from test DB to production DB
* [x] Explore codebase

## Security Clearance Slices
**findAll()**
* [x] Create the `SecurityClearenceController`
* [x] Create the `SecurityClearanceService`
* [x] Define the `SecurityClearanceJdbcTemplateRepository` findAll()
* [x] Define the `SecurityClearanceService` findAll()
* [x] Define the `SecurityController` findAll()
* [X] Create HTTP request.
* [x] Create the `Data` findAll() Tests
* [x] Create the `Domain` findAll() Tests

**findByID()**
* [x] Define the `SecurityClearanceJdbcTemplateRepository` findById()
* [x] Define the `SecurityClearanceService` findById()
* [x] Define the `SecurityClearenceController` findById()
* [x] Create HTTP request.
* [x] Create the `Data` findById() Tests
* [x] Create the `Domain` findById() Tests

**add()**
* [x] Define the `SecurityClearanceJdbcTemplateRepository` add()
* [x] Define the `SecurityClearanceService` add()
* [x] Define the `SecurityClearenceController` add()
* [x] Create HTTP request.
* [x] Add duplicate validation.
* [ ] Create the `Data` add() Tests
* [ ] Create the `Domain` add() Tests

**update()**
* [ ] Define the `SecurityClearanceJdbcTemplateRepository` update()
* [ ] Define the `SecurityClearanceService` update()
* [ ] Define the `SecurityClearenceController` update()
* [ ] Create HTTP request.
* [ ] Create the `Data` update() Tests
* [ ] Create the `Domain` update() Tests

**delete()**
* [ ] Develop strategy for delete()
* [ ] Define the `SecurityClearanceJdbcTemplateRepository` delete()
* [ ] Define the `SecurityClearanceService` delete()
* [ ] Define the `SecurityClearenceController` delete()
* [ ] Create HTTP request.
* [ ] Create the `Data` delete() Tests
* [ ] Create the `Domain` delete() Tests



## Aliases Slices
* [ ] Create the `AliasJdbcTemplateRepository`
* [ ] Create the `AliasService`
* [ ] Create the `AliasService`

**Fetch Agent**
* [ ] Fetch an individual agent with aliases attached

**add()**
* [ ] Define the `AliasJdbcTemplateRepository` add()
* [ ] Define the `AliasService` add()
* [ ] Define the `SecurityClearenceController` add()
* [ ] Create HTTP request.
* [ ] Create the `Data` add() Tests
* [ ] Create the `Domain` add() Tests

**update()**
* [ ] Define the `AliasJdbcTemplateRepository` update()
* [ ] Define the `AliasService` update()
* [ ] Define the `AliasController` update()
* [ ] Create HTTP request.
* [ ] Create the `Data` update() Tests
* [ ] Create the `Domain` update() Tests

**delete()**
* [ ] Define the `AgentJdbcTemplateRepository` delete()
* [ ] Define the `AgentClearanceService` delete()
* [ ] Define the `AliasController` delete()
* [ ] Create HTTP request.
* [ ] Create the `Data` delete() Tests
* [ ] Create the `Domain` delete() Tests

## Global Error Handling
* [ ] Use the @ControllerAdvice annotation to register an exception handler for all controllers.
* [ ] Determine the most precise exception for data integrity failures and handle it with a specific data integrity message.
* [ ] For all other exceptions, create a general "sorry, not sorry" response that doesn't share exception details.

## High Level
* [ ] Change known good state procedure