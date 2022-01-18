-- TABELA CATEGORIAS
INSERT INTO categorias ( id, lancamento, nome ) VALUES ( 1, 'RECEITA', 'Salário' );
INSERT INTO categorias ( id, lancamento, nome ) VALUES ( 2, 'RECEITA', 'Renda Extra' );
INSERT INTO categorias ( id, lancamento, nome ) VALUES ( 3, 'RECEITA', 'Outros' );

INSERT INTO categorias ( id, lancamento, nome ) VALUES ( 4, 'DESPESA_FIXA', 'Moradia' );
INSERT INTO categorias ( id, lancamento, nome ) VALUES ( 5, 'DESPESA_FIXA', 'Transporte' );
INSERT INTO categorias ( id, lancamento, nome ) VALUES ( 6, 'DESPESA_FIXA', 'Comunicação' );
INSERT INTO categorias ( id, lancamento, nome ) VALUES ( 7, 'DESPESA_FIXA', 'Lazer' );

INSERT INTO categorias ( id, lancamento, nome ) VALUES ( 8, 'DESPESA_EVENTUAL', 'Cartão de Crédito' );

-- TABELA ORCAMENTO
INSERT INTO orcamento ( tipo_lancamento, id, data, descricao, lancamento, valor, categoria_id ) VALUES ( 'receita', 1, '2022-01-17', 'Salário', 'RECEITA', 2600, 1 );
INSERT INTO orcamento ( tipo_lancamento, id, data, descricao, lancamento, valor, categoria_id ) VALUES ( 'receita', 2, '2022-01-17', 'Freela', 'RECEITA', 400, 2);
INSERT INTO orcamento ( tipo_lancamento, id, data, descricao, lancamento, valor, categoria_id ) VALUES ( 'receita', 3, '2022-01-17', 'Venda teclado mecânico', 'RECEITA', 420, 3);

INSERT INTO orcamento ( tipo_lancamento, id, data, descricao, lancamento, valor, categoria_id ) VALUES ( 'despesa', 4, '2022-01-17', 'Aluguel', 'DESPESA_FIXA', 1400, 4 );
INSERT INTO orcamento ( tipo_lancamento, id, data, descricao, lancamento, valor, categoria_id ) VALUES ( 'despesa', 5, '2022-01-17', 'Prestação do carro', 'DESPESA_FIXA', 699, 5 );
INSERT INTO orcamento ( tipo_lancamento, id, data, descricao, lancamento, valor, categoria_id ) VALUES ( 'despesa', 6, '2022-01-17', 'Água', 'DESPESA_FIXA', 90, 4 );
INSERT INTO orcamento ( tipo_lancamento, id, data, descricao, lancamento, valor, categoria_id ) VALUES ( 'despesa', 7, '2022-01-17', 'Luz', 'DESPESA_FIXA', 140, 4 );
INSERT INTO orcamento ( tipo_lancamento, id, data, descricao, lancamento, valor, categoria_id ) VALUES ( 'despesa', 8, '2022-01-17', 'Internet', 'DESPESA_FIXA', 99, 6 );
INSERT INTO orcamento ( tipo_lancamento, id, data, descricao, lancamento, valor, categoria_id ) VALUES ( 'despesa', 9, '2022-01-17', 'Celular', 'DESPESA_FIXA', 49.90, 6 );
INSERT INTO orcamento ( tipo_lancamento, id, data, descricao, lancamento, valor, categoria_id ) VALUES ( 'despesa', 10, '2022-01-17', 'Academia', 'DESPESA_FIXA', 80, 7 );

INSERT INTO orcamento ( tipo_lancamento, id, data, descricao, lancamento, valor, categoria_id ) VALUES ( 'despesa', 11, '2022-01-17', 'NuBank', 'DESPESA_EVENTUAL', 280, 7 );
INSERT INTO orcamento ( tipo_lancamento, id, data, descricao, lancamento, valor, categoria_id ) VALUES ( 'despesa', 12, '2022-01-17', 'IPVA', 'DESPESA_EVENTUAL', 280, 4 );
