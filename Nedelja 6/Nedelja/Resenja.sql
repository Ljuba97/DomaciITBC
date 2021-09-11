SELECT email, phone_number
FROM employees AS e
WHERE e.department_id IN (SELECT d.department_id FROM departments AS d
       		WHERE d.location_id IN (SELECT l.location_id FROM locations AS l
             	 WHERE l.country_id IN (SELECT c.country_id FROM countries AS c
               	    WHERE c.region_id IN (SELECT r.region_id FROM regions AS r
                            WHERE r.region_name = 'Europe'))))
GROUP BY phone_number, email
HAVING phone_number IS NOT NULL;


SELECT *
FROM dependents AS d
WHERE d.employee_id IN (SELECT e.employee_id FROM employees AS e
                        WHERE e.salary IN (SELECT MAX(salary) FROM employees));


SELECT c.country_name, SUM(salary)
FROM countries AS c
INNER JOIN locations AS l ON l.country_id = c.country_id
INNER JOIN departments AS d ON d.location_id = l.location_id
INNER JOIN employees AS e ON e.department_id = d.department_id
GROUP BY c.country_name
ORDER BY SUM(e.salary) DESC;
