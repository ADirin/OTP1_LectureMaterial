
## Implementing and Testing Functionalities of an Account Class

### Objective:
The objective of this assignment is to develop a class to illustrate bank account functionality and create a corresponding JUnit test case to verify its correctness.

### Steps:

1. **Create Files:**
    - Create two files: `Account.java` and `AccountTest.java`.

2. **Implement Account Class:**
    - Implement the `Account` class in `Account.java`.
    - The `Account` class must include the following methods and member variables:
        - A `double` member variable to hold the current account balance.
        - `public Account() {...}`: The default constructor should initialize the balance to `0.0`.
        - `public void deposit(double amount) {...}`: A deposit method to add money to the account.
        - `public double withdraw(double amount) {...}`: A withdraw method that withdraws the given amount from the account. If the amount given can be withdrawn, it should return that amount. If not, it should return `0.0`.
        - `public double getBalance() {...}`: A method to get the current balance in the account.

3. **Write Test Cases:**
    - Write test cases for the `Account` class in `AccountTest.java`.
    - Test cases should cover various scenarios including depositing money, withdrawing money, and checking balance.
    
4. **Execute Test Cases:**
    - Execute the test cases and ensure they pass successfully.
    
## Submission Instructions
1. Take a screenshot of the output showing the results of your tests.
2. Include your name in the screenshot for identification.
3. Submit the screenshot to the designated folder in Moodle as per classroom instructions.
