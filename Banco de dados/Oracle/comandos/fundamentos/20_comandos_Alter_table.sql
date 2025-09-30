--
-- Seção 15 
-- Comandos DDL 
--
-- Aula 2 - Alterando a Estrutura da Tabela
--

-- ALTER TABLE – Adicionando uma coluna

ALTER TABLE projects
ADD (department_id NUMBER(3)); 

DESC projects

-- ALTER TABLE – Removendo uma coluna

ALTER TABLE projects
DROP COLUMN department_id; 

DESC projects

-- ALTER TABLE – Adicionando uma coluna

ALTER TABLE projects
ADD (department_id NUMBER(4) NOT NULL); 

DESC projects

-- ALTER TABLE – Adicionando uma coluna

ALTER TABLE projects
MODIFY (project_code VARCHAR2(6));
                             
DESC PROJECTS
               
-- ALTER TABLE – Renomeando uma coluna

ALTER TABLE projects
RENAME COLUMN project_name TO name;

DESC projects

-- ALTER TABLE – READ ONLY

ALTER TABLE employees READ ONLY;

desc employees;

select * from employees;
select * from jobs;

delete from EMPLOYEES where EMPLOYEE_ID = 1;

insert into EMPLOYEES(EMPLOYEE_ID,  FIRST_NAME,last_name,email,HIRE_DATE,job_id) VALUES
(1,'Renan', 'Sereia', 'renan@2gmail.com', SYSDATE,'AD_PRES');

-- ALTER TABLE – READ WRITE

ALTER TABLE employees READ WRITE;