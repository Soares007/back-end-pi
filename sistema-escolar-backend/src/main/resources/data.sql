INSERT INTO TBL_CLASS_SUBJECTS (name, description, teacher, starttime, endtime, dayofweek) 
VALUES (
  'Matemática Discreta', 
  'MATEMÁTICA DISCRETA - 80 aulas Objetivo: Compreender e aplicar os conceitos fundamentais da matemática para computação em situações-problema dentro do contexto do curso, Ementa: Teoria dos conjuntos. Indução matemática. Análise combinatória. Lógica formal. Relações. Funções. Grafos e árvores.', 
  '', 
  '15:10', 
  '16:50',
  'Quinta-feira'
);

INSERT INTO TBL_TEACHERS (cpf, name, school_subject) 
VALUES ('12314342242', 'Tadeu', 'ES');

INSERT INTO TBL_STUDENTS (full_name, user_name, password, email) 
VALUES ('Gabriel Souza', 'gabriel.souza', '12345678', 'gabriel.souza@gmail.com');

INSERT INTO TBL_COORDINATOR (user_name, password) 
VALUES ('Gabriel.Souza', '1234567890');
