CREATE TABLE PERSON(ID int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), FIRSTNAME varchar(50) NOT NULL, LASTNAME varchar(100) NOT NULL, EMAIL varchar(45) NOT NULL UNIQUE, ADDRESS varchar(45) NOT NULL, CITY varchar(45) NOT NULL, PASSWORD varchar(100), DTYPE varchar(31));
CREATE TABLE GROUPS(ID int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), NAME varchar(50) NOT NULL, DESCRIPTION varchar(300));
CREATE TABLE PERSON_GROUPS(GROUPS_ID int NOT NULL,
 EMAIL varchar(45) NOT NULL,
 FOREIGN KEY (GROUPS_ID) REFERENCES GROUPS(ID),
 FOREIGN KEY (EMAIL) REFERENCES PERSON(EMAIL)

);
CREATE TABLE ORDER_STATUS(
ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
STATUS VARCHAR(45) NOT NULL,
DESCRIPTION VARCHAR(200),
PRIMARY KEY(ID)
);
CREATE TABLE CUSTOMER_ORDER(
ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
AMOUNT FLOAT(52) NOT NULL,
DATE_CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL,
CUSTOMER_ID INT NOT NULL,
STATUS_ID INT NOT NULL,
FOREIGN KEY(CUSTOMER_ID) REFERENCES PERSON(ID),
FOREIGN KEY(STATUS_ID) REFERENCES ORDER_STATUS(ID),
PRIMARY KEY(ID)
);
CREATE TABLE CATEGORY(
ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
NAME VARCHAR(45) NOT NULL,
TAGS VARCHAR(45),
PRIMARY KEY(ID)
);
CREATE TABLE PRODUCT(
ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
NAME VARCHAR(45) NOT NULL,
PRICE DECIMAL(10,2) NOT NULL,
DESCRIPTION VARCHAR(45) NOT NULL,
IMG VARCHAR(45),
CATEGORY_ID INT NOT NULL,
IMG_SRC BLOB(1073741823),
PRIMARY KEY(ID),
FOREIGN KEY(CATEGORY_ID) REFERENCES CATEGORY(ID) 
);
CREATE TABLE ORDER_DETAIL(
ORDER_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
PRODUCT_ID INT NOT NULL,
QTY INT NOT NULL,
CONSTRAINT SQL_ORDER_PRODUCT_PK PRIMARY KEY (ORDER_ID,PRODUCT_ID),
FOREIGN KEY(PRODUCT_ID) REFERENCES PRODUCT(ID),
FOREIGN KEY(ORDER_ID) REFERENCES CUSTOMER_ORDER(ID)
);



