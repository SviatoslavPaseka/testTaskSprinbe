# 🚀 testTaskSprinbe

**Automation Testing Project for API**

This project is designed for automated API testing, leveraging a powerful combination of industry-standard tools: **Rest Assured**, **Maven**, **TestNG**, and **Allure**. It's built to efficiently test your APIs, supporting parallel execution with multi-threading to handle even the most extensive test suites.

## 📚 Table of Contents

- [Project Overview](#project-overview)
- [🛠️ Technologies](#-technologies)
- [🧪 Test Suites](#-test-suites)
- [📊 Allure Reporting](#-allure-reporting)
- [⚙️ Configuration](#️-configuration)

### 💡 Project Overview

This project provides a structured framework for API testing, organized into three key test suites:

- **✅ Positive Tests:** Focus on validating the API's expected behavior under normal, successful conditions.
- **❌ Negative Tests:** Designed to assess the API's robustness by testing its response to invalid inputs and error scenarios.
- **🔄 Regression Tests:** A comprehensive set of tests to ensure that new changes or updates haven't introduced any regressions or broken existing functionality.

### ✨ Features

- **⚡ Parallel Test Execution:** Significantly reduce test execution time by running tests concurrently using multiple threads.
- **💎 Allure Reporting:** Generate beautiful, interactive, and informative reports detailing test execution status, steps, and attachments.
- **⚙️ TestNG Suites:** Utilize TestNG's suite management for flexible organization and grouping of test cases through XML configurations.
- **🧵 Multithreaded Execution:** Enhance efficiency by executing tests in parallel, optimizing resource utilization and minimizing overall test runtime.

### 🛠️ Technologies

This project utilizes the following technologies:

- **Java (11 or higher):** The programming language used for writing the tests.
- **Maven:** A powerful build automation tool for managing project dependencies and executing tests.
- **TestNG:** A robust testing framework for Java, providing annotations, test organization, and parallel execution capabilities.
- **Rest Assured:** A Java library for simplifying the testing of RESTful APIs.
- **Allure:** A flexible and lightweight reporting framework that generates visually appealing test reports.

## 🧪 Test Suites

The project is organized using the following TestNG XML suite files:

- **`testng-positive.xml`:** Contains test cases dedicated to validating the positive scenarios of the API.
- **`testng-negative.xml`:** Includes test cases designed to verify the API's behavior when provided with invalid or erroneous inputs.
- **`testng-regression.xml`:** A comprehensive suite encompassing tests to ensure the API's core functionalities remain stable after any modifications.

## 🏃 How to Run Tests

### Prerequisites

Before running the tests, ensure you have the following installed:

- **Java 11 or higher:** Download and install the latest version of Java Development Kit.
- **Maven:** Download and install Apache Maven.
- **TestNG:** Typically managed as a dependency through Maven.
- **Rest Assured:** Included as a dependency in the project's `pom.xml`.
- **Allure (optional for reporting):** Can be installed separately for generating detailed reports.

### Running a Specific Test Suite

To execute a specific test suite, use the following Maven command in your project's root directory:

```bash
mvn clean test -DsuiteXmlFile=<suite-name.xml> -DthreadCount=3 -DparallelType=methods
```
Replace ```<suite-name.xml>``` with the name of the desired test suite file (e.g., testng-positive.xml, testng-negative.xml, or testng-regression.xml).

Explanation of parameters:

Run Positive Test Suite with 3 threads:
mvn clean test -DsuiteXmlFile=testng-positive.xml -DthreadCount=3 -DparallelType=methods

## 📊 Allure Reporting
After the test execution is complete, you can generate and view the Allure report to gain detailed insights into the test results.

Generate the Allure Report:
```
mvn allure:report
```
Serve the Allure Report (opens in your default browser):

```
mvn allure:serve
```

These commands will process the test results and open an interactive HTML report in your web browser, providing a clear overview of the test execution, including pass/fail status, test steps, and any attached information.

⚙️ Configuration
You can customize the test execution through the following Maven properties:

Thread Count: Modify the -DthreadCount value in the Maven command to control the number of parallel threads used for running tests. Adjust this based on your system's resources and the desired level of parallelism.
Parallel Type: Change the -DparallelType parameter to either methods (parallelize at the individual test method level) or tests (parallelize at the test class level) to suit your testing needs.
