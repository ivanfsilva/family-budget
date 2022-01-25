
-- TABELA ORCAMENTO - RECEITA
INSERT INTO receitas ( id, data, descricao, lancamento, valor ) VALUES ( 1, '2022-01-17', 'Salário', 'RECEITA', 2600 );
INSERT INTO receitas ( id, data, descricao, lancamento, valor ) VALUES ( 2, '2022-01-17', 'Freela', 'RECEITA', 400 );
INSERT INTO receitas ( id, data, descricao, lancamento, valor ) VALUES ( 3, '2022-01-17', 'Venda teclado mecânico', 'RECEITA', 420 );

-- TABELA ORCAMENTO - DESPESA
INSERT INTO despesas ( id, data, descricao, lancamento, valor, categoria ) VALUES ( 4, '2022-01-17', 'Aluguel', 'DESPESA_FIXA', 1400, 'MORADIA' );
INSERT INTO despesas ( id, data, descricao, lancamento, valor, categoria ) VALUES ( 5, '2022-01-17', 'Prestação do carro', 'DESPESA_FIXA', 699, 'TRANSPORTE' );
INSERT INTO despesas ( id, data, descricao, lancamento, valor, categoria ) VALUES ( 6, '2022-01-17', 'Água', 'DESPESA_FIXA', 90, 'MORADIA' );
INSERT INTO despesas ( id, data, descricao, lancamento, valor, categoria ) VALUES ( 7, '2022-01-17', 'Luz', 'DESPESA_FIXA', 140, 'MORADIA' );
INSERT INTO despesas ( id, data, descricao, lancamento, valor, categoria ) VALUES ( 8, '2022-01-17', 'Internet', 'DESPESA_FIXA', 99, 'MORADIA' );
INSERT INTO despesas ( id, data, descricao, lancamento, valor, categoria ) VALUES ( 9, '2022-01-17', 'Celular', 'DESPESA_FIXA', 49.90, 'MORADIA' );
INSERT INTO despesas ( id, data, descricao, lancamento, valor, categoria ) VALUES ( 10, '2022-01-17', 'Academia', 'DESPESA_FIXA', 80, 'LAZER' );

INSERT INTO despesas ( id, data, descricao, lancamento, valor, categoria ) VALUES ( 11, '2022-01-17', 'NuBank', 'DESPESA_EVENTUAL', 280, 'EDUCACAO' );
INSERT INTO despesas ( id, data, descricao, lancamento, valor, categoria ) VALUES ( 12, '2022-01-17', 'IPVA', 'DESPESA_EVENTUAL', 400, 'TRANSPORTE' );
