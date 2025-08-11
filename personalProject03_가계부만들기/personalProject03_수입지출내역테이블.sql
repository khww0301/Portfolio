CREATE TABLE transaction_history (
    id NUMBER(10) PRIMARY KEY,
    member_id VARCHAR2(20) NOT NULL,
    type VARCHAR2(10) CHECK (type IN ('INCOME', 'EXPENSE')) NOT NULL,
    category VARCHAR2(50),
    amount NUMBER(12,2) NOT NULL,
    created_at DATE DEFAULT SYSDATE,
    CONSTRAINT fk_transaction_member 
        FOREIGN KEY (member_id) 
        REFERENCES member (member_id)
        ON DELETE CASCADE
);