WITH project_durations AS (
    SELECT
        p.ID,
        c.NAME AS CLIENT_NAME,
        p.START_DATE,
        p.FINISH_DATE,
        DATE_PART('year', age(p.FINISH_DATE, p.START_DATE)) * 12 +
        DATE_PART('month', age(p.FINISH_DATE, p.START_DATE)) AS MONTH_COUNT
    FROM
        project p
            JOIN
        client c ON p.CLIENT_ID = c.ID
)
SELECT
    CLIENT_NAME,
    MONTH_COUNT
FROM
    project_durations
WHERE
    MONTH_COUNT = (SELECT MAX(MONTH_COUNT) FROM project_durations);
