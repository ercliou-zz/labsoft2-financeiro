
INSERT INTO `financeiro-db`.`fin_salario` (`id`, `dataLimiteMilis`, `dataRequisicaoMilis`, `status`, `valor`, `cargo`, `departamento`, `horasTrabalhadas`) VALUES (1, 485967348, 345348589, 0, 2452, 'Estgiario', 0, 123);

--REQUISICAO_TRANSFERENCIA
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `status`, `valor`, `departamento`) VALUES (1, 3334, 1323741600000, 3244, 1, 888, 0);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `status`, `valor`, `departamento`) VALUES (2, 2234, 1327111200000, 3234, 1, 111, 1);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `status`, `valor`, `departamento`) VALUES (3, 1234, 1329789600000, 3534, 1, 222, 2);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `status`, `valor`, `departamento`) VALUES (4, 3334, 1323828000000, 3244, 1, 333, 3);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `status`, `valor`, `departamento`) VALUES (5, 3334, 1331694000000, 3244, 1, 444, 0);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `status`, `valor`, `departamento`) VALUES (6, 3334000, null, 3244, 0, 555, null);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `status`, `valor`, `departamento`) VALUES (7, 333400, null, 3244, 0, 666, null);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `status`, `valor`, `departamento`) VALUES (8, 3334, null, 3244, 0, 777, null);


--TRANSFERENCIA
--INSERT INTO `financeiro-db`.`fin_transferencia` (`id`, `categoria`, `dataRealizacaoMilis`, `valor`, `requisicao_fk`) VALUES (1, 0, 1323741600000, 111, 1); 
--Dec 13 2011
--INSERT INTO `financeiro-db`.`fin_transferencia` (`id`, `categoria`, `dataRealizacaoMilis`, `valor`, `requisicao_fk`) VALUES (2, 1, 1327111200000, 222, 2); 
--Jan 21 2012
--INSERT INTO `financeiro-db`.`fin_transferencia` (`id`, `categoria`, `dataRealizacaoMilis`, `valor`, `requisicao_fk`) VALUES (3, 2, 1329789600000, 333, 3); 
--Feb 21 2012
--INSERT INTO `financeiro-db`.`fin_transferencia` (`id`, `categoria`, `dataRealizacaoMilis`, `valor`, `requisicao_fk`) VALUES (4, 3, 1323828000000, 444, 4); 
--Dez 14 2011
--INSERT INTO `financeiro-db`.`fin_transferencia` (`id`, `categoria`, `dataRealizacaoMilis`, `valor`, `requisicao_fk`) VALUES (5, 4, 1331694000000, 555, 5); 
--March 14 2012


--PROCEDIMENTO
INSERT INTO `financeiro-db`.`fin_procedimento` (`id`, `nome`) VALUES (1, 'Siringa');
INSERT INTO `financeiro-db`.`fin_procedimento` (`id`, `nome`) VALUES (2, 'Extração do globo ocular esquerdo');
INSERT INTO `financeiro-db`.`fin_procedimento` (`id`, `nome`) VALUES (3, 'Implante de ímã');
INSERT INTO `financeiro-db`.`fin_procedimento` (`id`, `nome`) VALUES (4, 'Remoção do terceiro mamilo');
INSERT INTO `financeiro-db`.`fin_procedimento` (`id`, `nome`) VALUES (5, 'Sangue tipo AB');
INSERT INTO `financeiro-db`.`fin_procedimento` (`id`, `nome`) VALUES (6, 'Fígado');

-- PAGADOR
INSERT INTO `financeiro-db`.`fin_pagador` (`id`, `documento`, `infoBancaria`, `nome`) VALUES (1, '1111', '11110', 'Joao');
INSERT INTO `financeiro-db`.`fin_pagador` (`id`, `documento`, `infoBancaria`, `nome`) VALUES (2, '2222', '22220', 'Marolias');
INSERT INTO `financeiro-db`.`fin_pagador` (`id`, `documento`, `infoBancaria`, `nome`) VALUES (3, '3333', '33330', 'Eric');

-- PLANOS SAUDE
INSERT INTO `financeiro-db`.`fin_planosaude` (`id`, `nome`) VALUES (1, 'Unimed');
INSERT INTO `financeiro-db`.`fin_planosaude` (`id`, `nome`) VALUES (2, 'Nipomed');
INSERT INTO `financeiro-db`.`fin_planosaude` (`id`, `nome`) VALUES (3, 'Intermedica');
INSERT INTO `financeiro-db`.`fin_planosaude` (`id`, `nome`) VALUES (4, 'Amil');
INSERT INTO `financeiro-db`.`fin_planosaude` (`id`, `nome`) VALUES (5, 'Mamil');
INSERT INTO `financeiro-db`.`fin_planosaude` (`id`, `nome`) VALUES (6, 'Mamilu');
INSERT INTO `financeiro-db`.`fin_planosaude` (`id`, `nome`) VALUES (7, 'Murilo');

-- PLANOSAUDELOG
INSERT INTO `financeiro-db`.`fin_log_planosaude` (`id`, `dataMS`, `tipo`, `nomeAntigo`, `nomeNovo`, `planoSaudeId`) VALUES (1, 1323741600000, 0, 'aaa', 'AAA', 1);
INSERT INTO `financeiro-db`.`fin_log_planosaude` (`id`, `dataMS`, `tipo`, `nomeAntigo`, `nomeNovo`, `planoSaudeId`) VALUES (2, 1327111200000, 1, 'bbb', 'BBB', 2);
INSERT INTO `financeiro-db`.`fin_log_planosaude` (`id`, `dataMS`, `tipo`, `nomeAntigo`, `nomeNovo`, `planoSaudeId`) VALUES (3, 1329789600000, 2, 'ccc', 'CCC', 3);
INSERT INTO `financeiro-db`.`fin_log_planosaude` (`id`, `dataMS`, `tipo`, `nomeAntigo`, `nomeNovo`, `planoSaudeId`) VALUES (4, 1323828000000, 1, 'ddd', 'DDD', 4);


-- PEDIDOORCAMENTO
--Dec 13 2011
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `dataPedidoMilis`, `pagador_id`, `plano_id`) VALUES (1, 1323741600000, 1, 1);
--Jan 21 2012
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `dataPedidoMilis`, `pagador_id`, `plano_id`) VALUES (2, 1327111200000, 2, 2);
--Feb 21 2012
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `dataPedidoMilis`, `pagador_id`, `plano_id`) VALUES (3, 1329789600000, 3, 3);
--Dez 14 2011
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `dataPedidoMilis`, `pagador_id`, `plano_id`) VALUES (4, 1323828000000, 1, 1);
--March 14 2012
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `dataPedidoMilis`, `pagador_id`, `plano_id`) VALUES (5, 1331694000000, 1, 1);
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `dataPedidoMilis`, `pagador_id`, `plano_id`) VALUES (6, 1331694000000, 1, 1);

--PEDIDO_PROCEDIMENTO
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (1, 1);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (1, 2);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (1, 3);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (1, 4);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (1, 5);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (2, 2);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (2, 3);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (2, 4);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (3, 3);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (3, 4);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (4, 5);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (5, 6);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (6, 6);

--ORCAMENTO
INSERT INTO `financeiro-db`.`fin_orcamento` (`id`, `valorFinal`, `pedido_fk`) VALUES (1, 100.11, 1);
INSERT INTO `financeiro-db`.`fin_orcamento` (`id`, `valorFinal`, `pedido_fk`) VALUES (2, 200.22, 2);
INSERT INTO `financeiro-db`.`fin_orcamento` (`id`, `valorFinal`, `pedido_fk`) VALUES (3, 300.33, 3);
INSERT INTO `financeiro-db`.`fin_orcamento` (`id`, `valorFinal`, `pedido_fk`) VALUES (4, 400.44, 4);
INSERT INTO `financeiro-db`.`fin_orcamento` (`id`, `valorFinal`, `pedido_fk`) VALUES (5, 500.55, 5);
INSERT INTO `financeiro-db`.`fin_orcamento` (`id`, `valorFinal`, `pedido_fk`) VALUES (6, 600.66, 6);

