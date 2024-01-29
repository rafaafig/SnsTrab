--1)Obter o produto cartesiano (i.e. CROSS JOIN) entre as tabelas Empregado e EmpregadoEfetivo, de acordo
--com a Figura 2. 

SELECT Empregado.idEmpregado AS ID_EMPREGADO, 
EmpregadoEfetivo.idEmpregado AS ID_EMPREGADO_EFETIVO 
FROM Empregado CROSS JOIN EmpregadoEfetivo order by 1,2;

--2) Obter toda a informação dos empregados efetivos, por ordem alfabética dos nomes e de acordo com a
--Figura 3. 

SELECT Empregado.idempregado,empregado.nome,empregado.datanascimento,empregado.nridentificacaocivil,
empregado.nif,empregadoefetivo.salariomensalbase
FROM Empregado
JOIN Empregadoefetivo ON empregado.idEmpregado = empregadoefetivo.idempregado order by empregado.nome;

--3) Obter as faltas dos empregados efetivos, de acordo com a Figura 4 
SELECT 
    empregadoEfetivo.idEmpregado,
    falta.dataInicio,
    falta.dataFim,
    falta.justificacao
FROM 
    empregadoEfetivo
JOIN 
    falta ON empregadoEfetivo.idEmpregado = falta.idEmpregado;
    
--4) Obter as faltas dos empregados temporários, de acordo com a Figura 5.
 
SELECT 
    empregado.nome,
    empregado.nrIdentificacaoCivil,
    empregadoTemporario.idEmpregado,
    falta.dataInicio,
    falta.dataFim,
    falta.justificacao
FROM 
    empregado
JOIN 
    empregadoTemporario ON empregado.idEmpregado = empregadoTemporario.idEmpregado
JOIN 
    falta ON empregadoTemporario.idEmpregado = falta.idEmpregado;
    
--5)Obter as avaliações dos empregados temporários, de acordo com a Figura 6.
SELECT DISTINCT
    Empregado.nome,
    Empregado.nrIdentificacaoCivil,
    EmpregadoDepartamento.idDepartamento,
    EmpregadoDepartamento.dataInicio,
    EmpregadoDepartamento.dataFim,
    Avaliacao.descricao
FROM 
    EmpregadoTemporario
INNER JOIN Empregado ON EmpregadoTemporario.idEmpregado = Empregado.idEmpregado
INNER JOIN EmpregadoDepartamento ON EmpregadoTemporario.idEmpregado = EmpregadoDepartamento.idEmpregado
INNER JOIN AvaliacaoTemporario ON EmpregadoTemporario.idEmpregado = AvaliacaoTemporario.idEmpregado
INNER JOIN Avaliacao ON AvaliacaoTemporario.idAvaliacao = Avaliacao.idAvaliacao;

--6)Obter o nome e o número de identificação civil de todos empregados que nunca faltaram

SELECT 
    empregado.nome,
    empregado.nrIdentificacaoCivil
FROM 
    empregado
WHERE NOT EXISTS (
    SELECT 1
    FROM falta
    WHERE falta.idEmpregado = empregado.idEmpregado
);

--7) Obter o identificador e a designação de todos os departamentos juntamente com a designação do
--respetivo departamento do nível hierárquico superior. O resultado apresentado deve estar de acordo com
--a Figura 8.
SELECT
    d.idDepartamento,
    d.designacao,
    ds.designacao AS designacaoSuperior
FROM
    departamento d
LEFT JOIN
    departamento ds ON d.idDepartamentoSuperior = ds.idDepartamento
    order by d.designacao desc;
    
--8)Obter pares de empregados distintos e com idades diferentes, de acordo com a Figura 9
SELECT
    e1.idEmpregado AS idEmpregado,
    e1.nome AS nome,
    e2.idEmpregado AS idEmpregado_1,
    e2.nome AS nome_1
FROM
    empregado e1
JOIN
    empregado e2 ON e1.idEmpregado < e2.idEmpregado -- Garante pares distintos
WHERE
    ABS(MONTHS_BETWEEN(e1.dataNascimento, e2.dataNascimento)) > 12; -- Condição de idade diferente
--9)Obter o nome e o número de identificação civil de todos os empregados que tiveram pelo menos uma
--avaliação "MUITO BOM". O resultado apresentado deve estar de acordo com a Figura 10.
SELECT
    empregado.nome,
    empregado.nrIdentificacaoCivil
FROM
    empregado
WHERE
    empregado.idEmpregado IN (
        SELECT
            idEmpregado
        FROM
            avaliacaoEfetivo
        WHERE
            idAvaliacao IN (SELECT idAvaliacao FROM avaliacao WHERE descricao = 'MUITO BOM')
        UNION
        SELECT
            idEmpregado
        FROM
            avaliacaoTemporario
        WHERE
            idAvaliacao IN (SELECT idAvaliacao FROM avaliacao WHERE descricao = 'MUITO BOM')
    );
    
--10) Obter a descrição das avaliações que são comuns a empregados efetivos e temporários, de acordo com a
--Figura 11.
SELECT
    descricao
FROM
    avaliacaoEfetivo
JOIN
    avaliacao ON avaliacaoEfetivo.idAvaliacao = avaliacao.idAvaliacao

INTERSECT

SELECT
    descricao
FROM
    avaliacaoTemporario
JOIN
    avaliacao ON avaliacaoTemporario.idAvaliacao = avaliacao.idAvaliacao;
    
--11) Obter o nome e o número de identificação civil dos empregados efetivos cujas férias têm todas duração
--superior a 15 dias
SELECT
    empregado.nome,
    empregado.nrIdentificacaoCivil
FROM
    empregado
JOIN
    empregadoEfetivo ON empregado.idEmpregado = empregadoEfetivo.idEmpregado
WHERE
    NOT EXISTS (
        SELECT 1
        FROM
            avaliacaoEfetivo
        JOIN
            avaliacao ON avaliacaoEfetivo.idAvaliacao = avaliacao.idAvaliacao
        WHERE
            avaliacaoEfetivo.idEmpregado = empregado.idEmpregado
            AND avaliacao.descricao != 'MUITO BOM'
    );

--12) Obter o nome e o número de identificação civil dos empregados efetivos cujas férias têm todas duração
--superior a 15 dias
SELECT
    empregado.nome,
    empregado.nrIdentificacaoCivil
FROM
    empregado
JOIN
    empregadoEfetivo ON empregado.idEmpregado = empregadoEfetivo.idEmpregado
WHERE
    NOT EXISTS (
        SELECT 1
        FROM
            ferias
        WHERE
            ferias.idEmpregado = empregado.idEmpregado
            AND ferias.dataFim - ferias.dataInicio <= 15
    )
ORDER BY
    empregado.nome asc, empregado.nrIdentificacaoCivil asc;