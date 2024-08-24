# Database Transaction Example

## Tables

### Table 1: `Accounts`
This table stores information about users' bank accounts.

```sql
-- Table: Accounts
CREATE TABLE Accounts (
    AccountID INT PRIMARY KEY,
    AccountHolderName VARCHAR(100),
    Balance DECIMAL(10, 2)
);
````
-- Initial Data in Accounts Table

````sql
INSERT INTO Accounts (AccountID, AccountHolderName, Balance)
VALUES (1, 'John Doe', 1000),
       (2, 'Jane Smith', 1500),
       (3, 'Alice Johnson', 2000);

````
       
| AccountID | AccountHolderName | Balance |
|-----------|-------------------|---------|
| 1         | John Doe          | 1000    |
| 2         | Jane Smith        | 1500    |
| 3         | Alice Johnson     | 2000    |




### Table 2: `Transactions`

````sql
-- Table: Transactions
CREATE TABLE Transactions (
    TransactionID INT PRIMARY KEY,
    FromAccountID INT,
    ToAccountID INT,
    Amount DECIMAL(10, 2),
    Status VARCHAR(10)
);

````
````sql
-- Initial Data in Transactions Table
INSERT INTO Transactions (TransactionID, FromAccountID, ToAccountID, Amount, Status)
VALUES (1, 1, 2, 200, 'Pending'),
       (2, 3, 1, 500, 'Pending');

````


This table records transactions between accounts.

| TransactionID | FromAccountID | ToAccountID | Amount | Status  |
|---------------|---------------|-------------|--------|---------|
| 1             | 1             | 2           | 200    | Pending |
| 2             | 3             | 1           | 500    | Pending |

## Example Transaction Scenario

Let's say John Doe (AccountID 1) wants to transfer $200 to Jane Smith (AccountID 2). This operation involves two steps:
1. Deduct $200 from John Doe's account.
2. Add $200 to Jane Smith's account.

### Before Transaction

**Accounts Table:**

-- Accounts Table Before Transaction
````sql
SELECT * FROM Accounts;
````


| AccountID | AccountHolderName | Balance |
|-----------|-------------------|---------|
| 1         | John Doe          | 1000    |
| 2         | Jane Smith        | 1500    |
| 3         | Alice Johnson     | 2000    |

**Transactions Table:**

````sql
SELECT * FROM Accounts;
````

| TransactionID | FromAccountID | ToAccountID | Amount | Status  |
|---------------|---------------|-------------|--------|---------|
| 1             | 1             | 2           | 200    | Pending |
| 2             | 3             | 1           | 500    | Pending |

### During Transaction (Atomicity in Action)

Suppose the transaction starts:

1. **Deduct $200 from John Doe's account:**

-- Deducting $200 from John Doe's account

````sql
UPDATE Accounts
SET Balance = Balance - 200
WHERE AccountID = 1;
````

-- New balance should be $800


-- New balance should be $1700
   - New balance: $1000 - $200 = $800
2. **Add $200 to Jane Smith's account:**
-- Adding $200 to Jane Smith's account

````sql
UPDATE Accounts
SET Balance = Balance + 200
WHERE AccountID = 2;
````
     - New balance: $1500 + $200 = $1700

However, imagine a system failure occurs between these two operations.

### After Successful Transaction (Commit)

If the transaction completes successfully, the tables would be updated as follows:
````sql

START TRANSACTION;

UPDATE Accounts
SET Balance = Balance - 200
WHERE AccountID = 1;

-- Check for errors here; if none, continue
-- In a script, you would check for success of the above command

UPDATE Accounts
SET Balance = Balance + 200
WHERE AccountID = 2;

-- Check for errors again; if none, commit
COMMIT;

-- If any errors were detected, instead of committing, you would:
-- ROLLBACK;


````

**Accounts Table:**

| AccountID | AccountHolderName | Balance |
|-----------|-------------------|---------|
| 1         | John Doe          | 800     |
| 2         | Jane Smith        | 1700    |
| 3         | Alice Johnson     | 2000    |














### After Transaction Failure (Rollback)

Due to the failure, the database performs a rollback to maintain consistency:

````sql
-- Start the transaction
START TRANSACTION;

-- Step 1: Deduct $200 from John Doe's account
UPDATE Accounts
SET Balance = Balance - 200
WHERE AccountID = 1;

-- Simulate an error: try to update a non-existent account
-- This will cause an error because AccountID 999 doesn't exist
UPDATE Accounts
SET Balance = Balance + 200
WHERE AccountID = 999;

-- Since the above command fails, you should now rollback
ROLLBACK;

-- Check the results after rollback
SELECT * FROM Accounts;

-- Notice that no changes were made to the table, as the transaction was rolled back.


-- Accounts Table After Rollback
SELECT * FROM Accounts;

-- Output:

**Accounts Table:**

| AccountID | AccountHolderName | Balance |
|-----------|-------------------|---------|
| 1         | John Doe          | 600   |
| 2         | Jane Smith        | 1900    |
| 3         | Alice Johnson     | 2000    |
````


**Transactions Table:**

````sql
-- Transactions Table After Rollback
UPDATE Transactions
SET Status = 'Failed'
WHERE TransactionID = 1;

SELECT * FROM Transactions;

````



| TransactionID | FromAccountID | ToAccountID | Amount | Status  |
|---------------|---------------|-------------|--------|---------|
| 1             | 1             | 2           | 200    | Failed  |
| 2             | 3             | 1           | 500    | Pending |



**Transactions Table:**

````sql
-- Transactions Table After Commit
UPDATE Transactions
SET Status = 'Success'
WHERE TransactionID = 1;

SELECT * FROM Transactions;

-- Output:
````


| TransactionID | FromAccountID | ToAccountID | Amount | Status  |
|---------------|---------------|-------------|--------|---------|
| 1             | 1             | 2           | 200    | Success |
| 2             | 3             | 1           | 500    | Pending |

## Key Concepts Illustrated

1. **Atomicity**: The transaction either completes fully or not at all.
2. **Consistency**: The database remains in a consistent state before and after the transaction.
3. **Isolation**: Intermediate states are not visible to other transactions.
4. **Durability**: Once the transaction is committed, the changes persist even if there's a failure afterward.

----------------------------------



