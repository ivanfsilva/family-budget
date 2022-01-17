-- TABELA CATEGORIAS
INSERT INTO categorias ( id, lancamento, nome ) VALUES ( 1, 'RECEITA', 'Salário' );
INSERT INTO categorias ( id, lancamento, nome ) VALUES ( 2, 'RECEITA', 'Renda Extra' );
INSERT INTO categorias ( id, lancamento, nome ) VALUES ( 3, 'RECEITA', 'Outros' );

INSERT INTO categorias ( id, lancamento, nome ) VALUES ( 4, 'DESPESA_FIXA', 'Moradia' );
INSERT INTO categorias ( id, lancamento, nome ) VALUES ( 5, 'DESPESA_FIXA', 'Transporte' );
INSERT INTO categorias ( id, lancamento, nome ) VALUES ( 6, 'DESPESA_FIXA', 'Comunicação' );
INSERT INTO categorias ( id, lancamento, nome ) VALUES ( 7, 'DESPESA_FIXA', 'Lazer' );

INSERT INTO categorias ( id, lancamento, nome ) VALUES ( 8, 'DESPESA_EVENTUAL', 'NuBank' );
INSERT INTO categorias ( id, lancamento, nome ) VALUES ( 9, 'DESPESA_EVENTUAL', 'IPVA' );

-- TABELA ORCAMENTO
INSERT INTO orcamento ( tipo_lancamento, id, data, descricao, lancamento, valor, categoria_id ) VALUES ( 'receita', 1, '2022-01-17', 'Salário', 'RECEITA', 2600, 1 );
INSERT INTO orcamento ( tipo_lancamento, id, data, descricao, lancamento, valor, categoria_id ) VALUES ( 'receita', 2, '2022-01-17', 'Freela', 'RECEITA', 400, 2);
INSERT INTO orcamento ( tipo_lancamento, id, data, descricao, lancamento, valor, categoria_id ) VALUES ( 'receita', 3, '2022-01-17', 'Venda teclado mecânico', 'RECEITA', 420, 3);
INSERT INTO orcamento ( tipo_lancamento, id, data, descricao, lancamento, valor, categoria_id ) VALUES ( 'despesa', 4, '2022-01-17', 'Aluguel', 'DESPESA_FIXA', 1400, 4 );
