WITH project_durations AS (
    SELECT
        p.ID,
        DATE_PART('year', age(p.FINISH_DATE, p.START_DATE)) * 12 +
        DATE_PART('month', age(p.FINISH_DATE, p.START_DATE)) AS DURATION_MONTHS
    FROM
        project p
),
     project_prices AS (
         SELECT
             p.ID,
             SUM(w.SALARY) * pd.DURATION_MONTHS AS PRICE
         FROM
             project p
                 JOIN
             project_worker pw ON p.ID = pw.PROJECT_ID
                 JOIN
             worker w ON pw.WORKER_ID = w.ID
                 JOIN
             project_durations pd ON p.ID = pd.ID
         GROUP BY
             p.ID, pd.DURATION_MONTHS
     ),
     project_names AS (
         SELECT
             p.ID,
             CONCAT('Project ', p.ID) AS NAME
         FROM
             project p
     )
SELECT
    pn.NAME,
    pp.PRICE
FROM
    project_prices pp
        JOIN
    project_names pn ON pp.ID = pn.ID
ORDER BY
    pp.PRICE DESC;

