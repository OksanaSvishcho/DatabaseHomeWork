INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES
    ('John Doe', '1985-06-15', 'Senior', 7000),
    ('Jane Smith', '1990-11-20', 'Middle', 5000),
    ('Emily Johnson', '1992-03-10', 'Junior', 3000),
    ('Michael Brown', '1988-08-08', 'Senior', 8000),
    ('Jessica Davis', '1995-12-05', 'Trainee', 1000),
    ('Daniel Wilson', '1987-04-22', 'Middle', 4500),
    ('Emma Moore', '1991-05-13', 'Junior', 3200),
    ('Oliver Taylor', '1984-09-29', 'Senior', 7500),
    ('Sophia Anderson', '1996-02-17', 'Trainee', 950),
    ('Liam Thomas', '1989-01-25', 'Middle', 4800);


INSERT INTO client (NAME) VALUES
   ('ABC Corp'),
   ('XYZ Inc'),
   ('Global Solutions'),
   ('Tech Innovators'),
   ('Future Enterprises');


INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES
   (1, '2024-01-01', '2024-12-31'),
   (2, '2023-02-01', '2025-01-31'),
   (3, '2022-03-01', '2023-03-31'),
   (4, '2024-04-01', '2024-07-31'),
   (5, '2023-05-01', '2023-10-31'),
   (1, '2022-06-01', '2023-11-30'),
   (2, '2023-07-01', '2024-06-30'),
   (3, '2024-08-01', '2025-08-31'),
   (4, '2023-09-01', '2024-04-30'),
   (5, '2024-10-01', '2024-12-31');


INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
   (1, 1), (1, 2), (1, 3),
   (2, 4), (2, 5),
   (3, 6), (3, 7), (3, 8),
   (4, 9), (4, 10),
   (5, 1), (5, 4), (5, 7),
   (6, 2), (6, 5),
   (7, 3), (7, 6), (7, 8),
   (8, 9), (8, 1),
   (9, 10), (9, 2), (9, 3),
   (10, 4), (10, 5), (10, 6);
