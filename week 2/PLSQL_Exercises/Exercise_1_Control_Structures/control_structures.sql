-- Scenario 1: Apply 1% discount to loan interest for customers above 60
BEGIN
    FOR cust IN (SELECT * FROM Customers) LOOP
        IF cust.age > 60 THEN
            UPDATE Loans SET interest_rate = interest_rate - 1 WHERE customer_id = cust.customer_id;
        END IF;
    END LOOP;
END;
/

-- Scenario 2: Set IsVIP for customers with balance > 10,000
BEGIN
    FOR cust IN (SELECT * FROM Customers) LOOP
        IF cust.balance > 10000 THEN
            UPDATE Customers SET IsVIP = TRUE WHERE customer_id = cust.customer_id;
        END IF;
    END LOOP;
END;
/

-- Scenario 3: Reminders for loans due within 30 days
BEGIN
    FOR loan IN (
        SELECT * FROM Loans WHERE due_date BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan for Customer ID ' || loan.customer_id || ' is due on ' || loan.due_date);
    END LOOP;
END;
/