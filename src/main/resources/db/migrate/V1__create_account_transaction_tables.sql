CREATE TABLE if not exists Account
(
    account_id LONG  NOT NULL,
    account_type ENUM('CHECKING', 'SAVING', 'FIXED')  NOT NULL,
    client_id NVARCHAR(40)  NOT NULL,
    balance DOUBLE NOT NULL,
    withdraw_allowed BOOLEAN,
    CONSTRAINT PK_Account PRIMARY KEY  (account_id)
);

CREATE TABLE if not exists Transaction
(
    client_id NVARCHAR(40) NOT NULL,
    acc_id NVARCHAR(40) NOT NULL,
    account_type ENUM('CHECKING', 'SAVING', 'FIXED') NOT NULL,
    amount DOUBLE NOT NULL,
    CONSTRAINT PK_Transaction PRIMARY KEY (client_id),
    //FOREIGN KEY(acc_id) references Account(account_id)
);
