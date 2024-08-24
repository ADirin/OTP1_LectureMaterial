# Database Transaction Example

## Tables

### Table 1: `Accounts`
This table stores information about users' bank accounts.

| AccountID | AccountHolderName | Balance |
|-----------|-------------------|---------|
| 1         | John Doe          | 1000    |
| 2         | Jane Smith        | 1500    |
| 3         | Alice Johnson     | 2000    |

### Table 2: `Transactions`
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

| AccountID | AccountHolderName | Balance |
|-----------|-------------------|---------|
| 1         | John Doe          | 1000    |
| 2         | Jane Smith        | 1500    |
| 3         | Alice Johnson     | 2000    |

**Transactions Table:**

| TransactionID | FromAccountID | ToAccountID | Amount | Status  |
|---------------|---------------|-------------|--------|---------|
| 1             | 1             | 2           | 200    | Pending |
| 2             | 3             | 1           | 500    | Pending |

### During Transaction (Atomicity in Action)

Suppose the transaction starts:

1. **Deduct $200 from John Doe's account:**
   - New balance: $1000 - $200 = $800
2. **Add $200 to Jane Smith's account:**
   - New balance: $1500 + $200 = $1700

However, imagine a system failure occurs between these two operations.

### After Transaction Failure (Rollback)

Due to the failure, the database performs a rollback to maintain consistency:

**Accounts Table:**

| AccountID | AccountHolderName | Balance |
|-----------|-------------------|---------|
| 1         | John Doe          | 1000    |
| 2         | Jane Smith        | 1500    |
| 3         | Alice Johnson     | 2000    |

**Transactions Table:**

| TransactionID | FromAccountID | ToAccountID | Amount | Status  |
|---------------|---------------|-------------|--------|---------|
| 1             | 1             | 2           | 200    | Failed  |
| 2             | 3             | 1           | 500    | Pending |

### After Successful Transaction (Commit)

If the transaction completes successfully, the tables would be updated as follows:

**Accounts Table:**

| AccountID | AccountHolderName | Balance |
|-----------|-------------------|---------|
| 1         | John Doe          | 800     |
| 2         | Jane Smith        | 1700    |
| 3         | Alice Johnson     | 2000    |

**Transactions Table:**

| TransactionID | FromAccountID | ToAccountID | Amount | Status  |
|---------------|---------------|-------------|--------|---------|
| 1             | 1             | 2           | 200    | Success |
| 2             | 3             | 1           | 500    | Pending |

## Key Concepts Illustrated

1. **Atomicity**: The transaction either completes fully or not at all.
2. **Consistency**: The database remains in a consistent state before and after the transaction.
3. **Isolation**: Intermediate states are not visible to other transactions.
4. **Durability**: Once the transaction is committed, the changes persist even if there's a failure afterward.
