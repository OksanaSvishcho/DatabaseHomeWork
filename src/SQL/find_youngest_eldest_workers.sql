WITH oldest_worker AS (
    SELECT 'OLDEST' AS TYPE, NAME, BIRTHDAY
    FROM worker
    WHERE BIRTHDAY = (SELECT MIN(BIRTHDAY) FROM worker)
),
     youngest_worker AS (
         SELECT 'YOUNGEST' AS TYPE, NAME, BIRTHDAY
         FROM worker
         WHERE BIRTHDAY = (SELECT MAX(BIRTHDAY) FROM worker)
     )
SELECT * FROM oldest_worker
UNION ALL
SELECT * FROM youngest_worker;
