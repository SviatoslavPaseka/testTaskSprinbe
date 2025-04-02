# testTaskSprinbe
Automation Testing Project for API 

This project is designed for automated API testing using the Rest Assured framework, Maven, TestNG, and Allure. It supports running tests in parallel with multi-threading capabilities, making it ideal for large-scale API testing.

Table of Contents
Project Overview

Technologies

Test Suites

How to Run Tests

Allure Reporting

Configuration

License

Project Overview
The project includes 3 main test suites for API testing:

Positive Tests: Test cases that validate the correct behavior of the API under normal conditions.

Negative Tests: Test cases that check how the API behaves with invalid inputs or error conditions.

Regression Tests: A comprehensive set of test cases to ensure the API’s functionality remains consistent after changes.

Features
Parallel Test Execution: Tests can be run in parallel using multiple threads, increasing the efficiency and speed of the test execution.

Allure Reporting: Beautiful and interactive reports for test execution details and results.

TestNG Suites: Organize and group tests with multiple XML suites.

Multithreaded Execution: Run tests in parallel to reduce overall test runtime.

Test Suites
The project includes the following TestNG XML suites:

testng-positive.xml: Contains positive test cases to validate the correct behavior of the API.

testng-negative.xml: Contains negative test cases to validate how the API behaves with invalid inputs.

testng-regression.xml: A suite for regression testing to ensure the API functions properly after code changes.

How to Run Tests
Prerequisites
Java 11 or higher

Maven

TestNG

Rest Assured

Allure (optional for reporting)

Running a Specific Test Suite
To run any of the test suites, use the following Maven command:

mvn clean test -DsuiteXmlFile=<suite-name.xml> -DthreadCount=3 -DparallelType=methods

Replace <suite-name.xml> with the desired test suite file (e.g., testng-positive.xml, testng-negative.xml, or testng-regression.xml).

-DthreadCount=3 specifies the number of threads to run in parallel.

-DparallelType=methods runs the tests in parallel at the method level (you can also use -DparallelType=tests for parallelizing test classes).

Example Commands
Run Positive Test Suite with 3 threads:

mvn clean test -DsuiteXmlFile=testng-positive.xml -DthreadCount=3 -DparallelType=methods

Run Negative Test Suite with 3 threads:

mvn clean test -DsuiteXmlFile=testng-negative.xml -DthreadCount=3 -DparallelType=methods

Run Regression Test Suite with 3 threads:

mvn clean test -DsuiteXmlFile=testng-regression.xml -DthreadCount=3 -DparallelType=methods

Allure Reporting
After running the tests, you can generate an Allure report with the following commands:

Generate the Allure Report:

mvn allure:report

Serve the Allure Report:

mvn allure:serve

This will open the Allure report in your default browser.

Configuration
Thread Count: You can adjust the number of threads for parallel execution by changing the value of -DthreadCount.

Parallel Type: You can choose to run tests in parallel at the method level or class level by modifying -DparallelType (e.g., methods or tests).
