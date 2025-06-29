-- Scenario 1: Process monthly interest
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET balance = balance + (balance * 0.01)
    WHERE account_type = 'SAVINGS';
END;
/

-- Scenario 2: Update employee bonus
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(dept_id IN NUMBER, bonus_pct IN NUMBER) AS
BEGIN
    UPDATE Employees
    SET salary = salary + (salary * bonus_pct / 100)
    WHERE department_id = dept_id;
END;
/

-- Scenario 3: Transfer funds
CREATE OR REPLACE PROCEDURE TransferFunds(
    from_acc IN NUMBER,
    to_acc IN NUMBER,
    amount IN NUMBER
) AS
    insufficient_balance EXCEPTION;
    from_balance NUMBER;
BEGIN
    SELECT balance INTO from_balance FROM Accounts WHERE account_id = from_acc;
    IF from_balance < amount THEN
        RAISE insufficient_balance;
    END IF;

    UPDATE Accounts SET balance = balance - amount WHERE account_id = from_acc;
    UPDATE Accounts SET balance = balance + amount WHERE account_id = to_acc;
EXCEPTION
    WHEN insufficient_balance THEN
        DBMS_OUTPUT.PUT_LINE('Insufficient balance in source account.');
END;
/