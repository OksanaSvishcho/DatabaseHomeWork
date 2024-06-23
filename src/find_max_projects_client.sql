WITH client_project_count AS (
    SELECT c.NAME, COUNT(p.ID) AS PROJECT_COUNT
    FROM client c
             JOIN project p ON c.ID = p.CLIENT_ID
    GROUP BY c.NAME
)
SELECT NAME, PROJECT_COUNT
FROM client_project_count
WHERE PROJECT_COUNT = (SELECT MAX(PROJECT_COUNT) FROM client_project_count);