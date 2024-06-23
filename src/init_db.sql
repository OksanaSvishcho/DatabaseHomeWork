CREATE TABLE worker (
                        ID SERIAL PRIMARY KEY,
                        NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) >= 2 AND LENGTH(NAME) <= 1000) ,
                        BIRTHDAY DATE NOT NULL CHECK (EXTRACT(YEAR FROM BIRTHDAY) > 1900),
                        LEVEL VARCHAR(20) NOT NULL CHECK (LEVEL IN ('Trainee', 'Junior', 'Middle', 'Senior')),
                        SALARY INT NOT NULL CHECK (SALARY >= 100 AND SALARY <= 100000)
);

CREATE TABLE client (
                        ID SERIAL PRIMARY KEY ,
                        NAME VARCHAR(1000) NOT NULL CHECK ( LENGTH(NAME) >= 2 AND LENGTH(NAME) <= 1000)
);

CREATE TABLE project (
                         ID SERIAL PRIMARY KEY,
                         CLIENT_ID INT NOT NULL,
                         START_DATE DATE NOT NULL,
                         FINISH_DATE DATE NOT NULL,
                         FOREIGN KEY (CLIENT_ID) REFERENCES client(ID)
);

CREATE TABLE project_worker (
                                PROJECT_ID INT NOT NULL ,
                                WORKER_ID INT NOT NULL ,
                                PRIMARY KEY (PROJECT_ID, WORKER_ID),
                                FOREIGN KEY (PROJECT_ID) REFERENCES project(ID),
                                FOREIGN KEY (WORKER_ID) REFERENCES worker(ID)
);