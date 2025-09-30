select * from EMPLOYEES;
select * from JOBS;
select DEPARTMENT_ID,LOCATION_ID from DEPARTMENTS;


select FIRST_NAME,LAST_NAME,SALARY, SALARY * 1.15 porcentagem from EMPLOYEES;

-- PROCEDENCIA
select FIRST_NAME,LAST_NAME,SALARY,
       (SALARY + SALARY) * 1.15 porcentagem from EMPLOYEES;



select FIRST_NAME,LAST_NAME,JOB_ID,SALARY, COMMISSION_PCT, 2000 * COMMISSION_PCT from EMPLOYEES where COMMISSION_PCT is not null;


select FIRST_NAME "Nome",LAST_NAME "SobreNome",JOB_ID,SALARY "Salário ($)", COMMISSION_PCT from EMPLOYEES;

-- Utilizando operadores de concatenação
select FIRST_NAME || ' ' || LAST_NAME || ', data de admissão: ' || HIRE_DATE as funcionario
 from EMPLOYEES;


-- Utilizando operadores alternativo para aspas

select DEPARTMENT_NAME || q'[ Department's Manager Id:]' || MANAGER_ID "Departamento e Gerente" from DEPARTMENTS;


-- Linhas duplicadas
select DEPARTMENT_ID from EMPLOYEES;
select DISTINCT DEPARTMENT_ID from EMPLOYEES ORDER BY DEPARTMENT_ID;

SELECT DISTINCT FIRST_NAME, LAST_NAME FROM EMPLOYEES;
