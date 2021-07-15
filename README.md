
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
* [x] Create the `Data` add() Tests
* [x] Create the `Domain` add() Tests

**update()**
* [x] Define the `SecurityClearanceJdbcTemplateRepository` update()
* [x] Define the `SecurityClearanceService` update()
* [x] Define the `SecurityClearenceController` update()
* [x] Create HTTP request.
* [x] Create the `Data` update() Tests
* [x] Create the `Domain` update() Tests

**delete()**
* [x] Develop strategy for delete()
* [x] Define the `SecurityClearanceJdbcTemplateRepository` delete()
* [x] Define the `SecurityClearanceService` delete()
* [x] Define the `SecurityClearenceController` delete()
* [x] Create HTTP request.
* [x] Create the `Data` delete() Tests
* [x] Create the `Domain` delete() Tests


## Aliases Slices
* [x] Create the `AliasJdbcTemplateRepository`
* [x] Create the `AliasJdbcTemplateRepositoryTest`
* [x] Create the `AliasRepository` interface
* [x] Create the `AliasService`
* [x] Create the `AliasServiceTest`
* [x] Create the `alias.http`
* [x] Create the `alias.controller`
* [x] Create the `alias.mapper`
* [x] Create the `Alias` model

**Fetch Agent**
* [ ] Fetch an individual agent with aliases attached

**add()**
* [x] Define the `AliasJdbcTemplateRepository` add()
* [x] Define the `AliasService` add()
* [x] Define the `AliasController` add()
* [x] Create HTTP request.
* [x] Create the `Data` add() Tests
* [x] Create the `Domain` add() Tests

**update()**
* [x] Define the `AliasJdbcTemplateRepository` update()
* [x] Define the `AliasService` update()
* [x] Define the `AliasController` update()
* [x] Create HTTP request.
* [x] Create the `Data` update() Tests
* [x] Create the `Domain` update() Tests

**delete()**
* [x] Define the `AliasJdbcTemplateRepository` delete()
* [x] Define the `AliasClearanceService` delete()
* [x] Define the `AliasController` delete()
* [x] Create HTTP request.
* [x] Create the `Data` delete() Tests
* [x] Create the `Domain` delete() Tests

## Global Error Handling
* [ ] Use the @ControllerAdvice annotation to register an exception handler for all controllers.
* [x] Determine the most precise exception for data integrity failures and handle it with a specific data integrity message.
* [x] For all other exceptions, create a general "sorry, not sorry" response that doesn't share exception details.

## High Level
* [ ] Change known good state procedure