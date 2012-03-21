

INSERT INTO `financeiro-db`.`fin_requisicao` (`id`, `dataLimiteMilis`, `dataRequisicaoMilis`, `status`, `valor`) VALUES (2, 2234, 3234, 0, 111);
INSERT INTO `financeiro-db`.`fin_requisicao` (`id`, `dataLimiteMilis`, `dataRequisicaoMilis`, `status`, `valor`) VALUES (3, 1234, 3534, 1, 222);
INSERT INTO `financeiro-db`.`fin_requisicao` (`id`, `dataLimiteMilis`, `dataRequisicaoMilis`, `status`, `valor`) VALUES (4, 3334, 3244, 2, 333);
INSERT INTO `financeiro-db`.`fin_requisicao` (`id`, `dataLimiteMilis`, `dataRequisicaoMilis`, `status`, `valor`) VALUES (5, 3334, 3244, 3, 444);
INSERT INTO `financeiro-db`.`fin_requisicao` (`id`, `dataLimiteMilis`, `dataRequisicaoMilis`, `status`, `valor`) VALUES (6, 3334000, 3244, 0, 555);
INSERT INTO `financeiro-db`.`fin_requisicao` (`id`, `dataLimiteMilis`, `dataRequisicaoMilis`, `status`, `valor`) VALUES (7, 333400, 3244, 1, 666);
INSERT INTO `financeiro-db`.`fin_requisicao` (`id`, `dataLimiteMilis`, `dataRequisicaoMilis`, `status`, `valor`) VALUES (8, 3334, 3244, 2, 777);
INSERT INTO `financeiro-db`.`fin_requisicao` (`id`, `dataLimiteMilis`, `dataRequisicaoMilis`, `status`, `valor`) VALUES (9, 3334, 3244, 3, 888);


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


-- PEDIDOORCAMENTO
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `pagador_id`, `plano_id`) VALUES (1, 1, 1);
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `pagador_id`, `plano_id`) VALUES (2, 2, 2);
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `pagador_id`, `plano_id`) VALUES (3, 3, 3);
--INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `pagador_id`, `plano_id`) VALUES (4, 1, 1);
--INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `pagador_id`, `plano_id`) VALUES (5, 1, 1);
--INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `pagador_id`, `plano_id`) VALUES (6, 2, 2);