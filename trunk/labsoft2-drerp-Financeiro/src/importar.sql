
INSERT INTO `financeiro-db`.`fin_planosaude` (`id`,`nome`) VALUES (1,'Amil');
INSERT INTO `financeiro-db`.`fin_planosaude` (`id`,`nome`) VALUES (2,'Dix Saude');
INSERT INTO `financeiro-db`.`fin_planosaude` (`id`,`nome`) VALUES (3,'Golden Cross');
INSERT INTO `financeiro-db`.`fin_planosaude` (`id`,`nome`) VALUES (4,'Sul America');
INSERT INTO `financeiro-db`.`fin_planosaude` (`id`,`nome`) VALUES (5,'Bradesco');
INSERT INTO `financeiro-db`.`fin_planosaude` (`id`,`nome`) VALUES (6,'Green Line');
INSERT INTO `financeiro-db`.`fin_planosaude` (`id`,`nome`) VALUES (7,'Medial Saude');
INSERT INTO `financeiro-db`.`fin_planosaude` (`id`,`nome`) VALUES (8,'Unimed Paulistana');
INSERT INTO `financeiro-db`.`fin_planosaude` (`id`,`nome`) VALUES (9,'Particular');

INSERT INTO `financeiro-db`.`fin_procedimento` (`id`,`nome`,`tipo`) VALUES (1,'Consulta Psiquiatrica',0);
INSERT INTO `financeiro-db`.`fin_procedimento` (`id`,`nome`,`tipo`) VALUES (2,'Consulta Geral',0);
INSERT INTO `financeiro-db`.`fin_procedimento` (`id`,`nome`,`tipo`) VALUES (3,'Exame de Urina',0);
INSERT INTO `financeiro-db`.`fin_procedimento` (`id`,`nome`,`tipo`) VALUES (4,'Teste Sanguineo',0);
INSERT INTO `financeiro-db`.`fin_procedimento` (`id`,`nome`,`tipo`) VALUES (5,'Seringa',1);
INSERT INTO `financeiro-db`.`fin_procedimento` (`id`,`nome`,`tipo`) VALUES (6,'Mascara',1);
INSERT INTO `financeiro-db`.`fin_procedimento` (`id`,`nome`,`tipo`) VALUES (7,'Aspirina',2);
INSERT INTO `financeiro-db`.`fin_procedimento` (`id`,`nome`,`tipo`) VALUES (8,'Calcio',2);


INSERT INTO `financeiro-db`.`fin_coluna` (`id`,`planoSaude_fk`) VALUES (1,1);
INSERT INTO `financeiro-db`.`fin_coluna` (`id`,`planoSaude_fk`) VALUES (2,2);
INSERT INTO `financeiro-db`.`fin_coluna` (`id`,`planoSaude_fk`) VALUES (3,3);
INSERT INTO `financeiro-db`.`fin_coluna` (`id`,`planoSaude_fk`) VALUES (4,4);
INSERT INTO `financeiro-db`.`fin_coluna` (`id`,`planoSaude_fk`) VALUES (5,5);
INSERT INTO `financeiro-db`.`fin_coluna` (`id`,`planoSaude_fk`) VALUES (6,6);
INSERT INTO `financeiro-db`.`fin_coluna` (`id`,`planoSaude_fk`) VALUES (7,7);
INSERT INTO `financeiro-db`.`fin_coluna` (`id`,`planoSaude_fk`) VALUES (8,8);
INSERT INTO `financeiro-db`.`fin_coluna` (`id`,`planoSaude_fk`) VALUES (9,9);

INSERT INTO `financeiro-db`.`fin_itemtabela` (`id`,`procedimento_fk`) VALUES (1,1);
INSERT INTO `financeiro-db`.`fin_itemtabela` (`id`,`procedimento_fk`) VALUES (2,2);
INSERT INTO `financeiro-db`.`fin_itemtabela` (`id`,`procedimento_fk`) VALUES (3,3);
INSERT INTO `financeiro-db`.`fin_itemtabela` (`id`,`procedimento_fk`) VALUES (4,4);
INSERT INTO `financeiro-db`.`fin_itemtabela` (`id`,`procedimento_fk`) VALUES (5,5);
INSERT INTO `financeiro-db`.`fin_itemtabela` (`id`,`procedimento_fk`) VALUES (6,6);
INSERT INTO `financeiro-db`.`fin_itemtabela` (`id`,`procedimento_fk`) VALUES (7,7);
INSERT INTO `financeiro-db`.`fin_itemtabela` (`id`,`procedimento_fk`) VALUES (8,8);

INSERT INTO `financeiro-db`.`fin_log_planosaude` (`id`,`dataMS`,`tipo`,`nomeAntigo`,`nomeNovo`,`planoSaudeId`) VALUES (1,1335258603183,0,NULL,'Amil',1);
INSERT INTO `financeiro-db`.`fin_log_planosaude` (`id`,`dataMS`,`tipo`,`nomeAntigo`,`nomeNovo`,`planoSaudeId`) VALUES (2,1335258607509,0,NULL,'Dix Saude',2);
INSERT INTO `financeiro-db`.`fin_log_planosaude` (`id`,`dataMS`,`tipo`,`nomeAntigo`,`nomeNovo`,`planoSaudeId`) VALUES (3,1335258612213,0,NULL,'Golden Cross',3);
INSERT INTO `financeiro-db`.`fin_log_planosaude` (`id`,`dataMS`,`tipo`,`nomeAntigo`,`nomeNovo`,`planoSaudeId`) VALUES (4,1335258617253,0,NULL,'Sul America',4);
INSERT INTO `financeiro-db`.`fin_log_planosaude` (`id`,`dataMS`,`tipo`,`nomeAntigo`,`nomeNovo`,`planoSaudeId`) VALUES (5,1335258623759,0,NULL,'Bradesco',5);
INSERT INTO `financeiro-db`.`fin_log_planosaude` (`id`,`dataMS`,`tipo`,`nomeAntigo`,`nomeNovo`,`planoSaudeId`) VALUES (6,1335258641985,0,NULL,'Green Line',6);
INSERT INTO `financeiro-db`.`fin_log_planosaude` (`id`,`dataMS`,`tipo`,`nomeAntigo`,`nomeNovo`,`planoSaudeId`) VALUES (7,1335258647121,0,NULL,'Medial Saude',7);
INSERT INTO `financeiro-db`.`fin_log_planosaude` (`id`,`dataMS`,`tipo`,`nomeAntigo`,`nomeNovo`,`planoSaudeId`) VALUES (8,1335258652494,0,NULL,'Unimed Paulistana',8);

INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (1,1335258885880,1,1,1,NULL,'70.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (2,1335258889803,1,2,1,NULL,'71.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (3,1335258894466,1,3,1,NULL,'72.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (4,1335258900883,1,4,1,NULL,'73.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (5,1335258905245,1,5,1,NULL,'74.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (6,1335258909911,1,6,1,NULL,'75.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (7,1335258913884,1,7,1,NULL,'76.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (8,1335258918484,1,8,1,NULL,'77.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (9,1335258922348,1,9,1,NULL,'80.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (10,1335258928398,1,1,2,NULL,'60.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (11,1335258931943,1,2,2,NULL,'62.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (12,1335258935347,1,3,2,NULL,'64.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (13,1335258938442,1,4,2,NULL,'66.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (14,1335258941824,1,5,2,NULL,'68.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (15,1335258946120,1,6,2,NULL,'70.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (16,1335258967697,1,7,2,NULL,'72.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (17,1335258971353,1,8,2,NULL,'74.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (18,1335258976076,1,9,2,NULL,'75.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (19,1335258980144,1,1,3,NULL,'150.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (20,1335258985196,1,2,3,NULL,'155.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (21,1335258988413,1,3,3,NULL,'160.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (22,1335258991907,1,4,3,NULL,'165.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (23,1335258995331,1,5,3,NULL,'170.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (24,1335258999630,1,6,3,NULL,'175.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (25,1335259003451,1,7,3,NULL,'180.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (26,1335259006652,1,8,3,NULL,'185.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (27,1335259011916,1,9,3,NULL,'190.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (28,1335259040577,1,1,4,NULL,'30.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (29,1335259045124,1,2,4,NULL,'31.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (30,1335259048466,1,3,4,NULL,'32.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (31,1335259051488,1,4,4,NULL,'33.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (32,1335259054987,1,5,4,NULL,'34.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (33,1335259059609,1,6,4,NULL,'35.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (34,1335259062653,1,7,4,NULL,'36.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (35,1335259066806,1,8,4,NULL,'37.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (36,1335259070646,1,9,4,NULL,'38.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (37,1335259074789,1,1,5,NULL,'5.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (38,1335259079199,1,2,5,NULL,'5.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (39,1335259083284,1,3,5,NULL,'5.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (40,1335259085925,1,4,5,NULL,'5.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (41,1335259089405,1,5,5,NULL,'5.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (42,1335259092203,1,6,5,NULL,'5.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (43,1335259094925,1,7,5,NULL,'5.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (44,1335259097589,1,8,5,NULL,'5.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (45,1335259101183,1,9,5,NULL,'7.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (46,1335259156964,1,1,6,NULL,'1.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (47,1335259160310,1,2,6,NULL,'1.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (48,1335259162787,1,3,6,NULL,'2.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (49,1335259165307,1,4,6,NULL,'1.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (50,1335259167908,1,5,6,NULL,'1.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (51,1335259171454,1,6,6,NULL,'2.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (52,1335259173716,1,7,6,NULL,'2.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (53,1335259176261,1,8,6,NULL,'1.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (54,1335259179171,1,9,6,NULL,'4.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (55,1335259181788,1,1,7,NULL,'3.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (56,1335259192624,1,2,7,NULL,'4.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (57,1335259195292,1,3,7,NULL,'3.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (58,1335259197619,1,4,7,NULL,'4.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (59,1335259200116,1,5,7,NULL,'3.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (60,1335259202957,1,6,7,NULL,'4.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (61,1335259205155,1,7,7,NULL,'3.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (62,1335259207812,1,8,7,NULL,'4.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (63,1335259211316,1,9,7,NULL,'6.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (64,1335259215763,1,1,8,NULL,'10.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (65,1335259220972,1,2,8,NULL,'12.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (66,1335259224539,1,3,8,NULL,'13.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (67,1335259227204,1,4,8,NULL,'11.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (68,1335259230836,1,5,8,NULL,'16.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (69,1335259233819,1,6,8,NULL,'15.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (70,1335259236409,1,7,8,NULL,'11.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (71,1335259239012,1,8,8,NULL,'12.00');
INSERT INTO `financeiro-db`.`fin_log_valor` (`id`,`dataMS`,`tipo`,`planoSaudeId`,`procedimentoId`,`valorAntigo`,`valorNovo`) VALUES (72,1335259242477,1,9,8,NULL,'20.00');


INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (1,'70.00',1,1);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (2,'71.00',2,1);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (3,'72.00',3,1);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (4,'73.00',4,1);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (5,'74.00',5,1);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (6,'75.00',6,1);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (7,'76.00',7,1);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (8,'77.00',8,1);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (9,'60.00',1,2);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (10,'62.00',2,2);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (11,'64.00',3,2);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (12,'66.00',4,2);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (13,'68.00',5,2);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (14,'70.00',6,2);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (15,'72.00',7,2);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (16,'74.00',8,2);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (17,'150.00',1,3);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (18,'155.00',2,3);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (19,'160.00',3,3);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (20,'165.00',4,3);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (21,'170.00',5,3);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (22,'175.00',6,3);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (23,'180.00',7,3);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (24,'185.00',8,3);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (25,'30.00',1,4);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (26,'31.00',2,4);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (27,'32.00',3,4);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (28,'33.00',4,4);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (29,'34.00',5,4);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (30,'35.00',6,4);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (31,'36.00',7,4);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (32,'37.00',8,4);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (33,'5.00',1,5);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (34,'5.00',2,5);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (35,'5.00',3,5);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (36,'5.00',4,5);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (37,'5.00',5,5);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (38,'5.00',6,5);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (39,'5.00',7,5);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (40,'5.00',8,5);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (41,'1.00',1,6);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (42,'1.00',2,6);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (43,'2.00',3,6);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (44,'1.00',4,6);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (45,'1.00',5,6);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (46,'2.00',6,6);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (47,'2.00',7,6);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (48,'1.00',8,6);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (49,'80.00',9,1);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (50,'75.00',9,2);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (51,'190.00',9,3);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (52,'38.00',9,4);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (53,'7.00',9,5);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (54,'4.00',9,6);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (55,'3.00',1,7);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (56,'4.00',2,7);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (57,'3.00',3,7);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (58,'4.00',4,7);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (59,'3.00',5,7);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (60,'4.00',6,7);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (61,'3.00',7,7);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (62,'4.00',8,7);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (63,'6.00',9,7);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (64,'10.00',1,8);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (65,'12.00',2,8);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (66,'13.00',3,8);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (67,'11.00',4,8);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (68,'16.00',5,8);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (69,'15.00',6,8);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (70,'11.00',7,8);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (71,'12.00',8,8);
INSERT INTO `financeiro-db`.`fin_valor` (`id`,`valor`,`coluna_fk`,`itemTabela_fk`) VALUES (72,'20.00',9,8);



INSERT INTO `financeiro-db`.`fin_pagador` (`id`, `documento`, `infoBancaria`, `nome`) VALUES (100, '1111', '11110', 'Joao');
INSERT INTO `financeiro-db`.`fin_pagador` (`id`, `documento`, `infoBancaria`, `nome`) VALUES (101, '2222', '22220', 'Marolias');
INSERT INTO `financeiro-db`.`fin_pagador` (`id`, `documento`, `infoBancaria`, `nome`) VALUES (102, '3333', '33330', 'Eric');
INSERT INTO `financeiro-db`.`fin_pagador` (`id`, `documento`, `infoBancaria`, `nome`) VALUES (103, '1111', '11110', 'Joao');
INSERT INTO `financeiro-db`.`fin_pagador` (`id`, `documento`, `infoBancaria`, `nome`) VALUES (104, '2222', '22220', 'Marolias');
INSERT INTO `financeiro-db`.`fin_pagador` (`id`, `documento`, `infoBancaria`, `nome`) VALUES (105, '3333', '33330', 'Eric');
INSERT INTO `financeiro-db`.`fin_pagador` (`id`, `documento`, `infoBancaria`, `nome`) VALUES (106, '1111', '11110', 'Joao');
INSERT INTO `financeiro-db`.`fin_pagador` (`id`, `documento`, `infoBancaria`, `nome`) VALUES (107, '2222', '22220', 'Marolias');
INSERT INTO `financeiro-db`.`fin_pagador` (`id`, `documento`, `infoBancaria`, `nome`) VALUES (108, '3333', '33330', 'Eric');
INSERT INTO `financeiro-db`.`fin_pagador` (`id`, `documento`, `infoBancaria`, `nome`) VALUES (109, '1111', '11110', 'Joao');
INSERT INTO `financeiro-db`.`fin_pagador` (`id`, `documento`, `infoBancaria`, `nome`) VALUES (110, '2222', '22220', 'Marolias');
INSERT INTO `financeiro-db`.`fin_pagador` (`id`, `documento`, `infoBancaria`, `nome`) VALUES (111, '3333', '33330', 'Eric');

INSERT INTO `financeiro-db`.`fin_beneficiario` (`id`, `nome`, `tipoBeneficiario`) VALUES (100, 'eric', 0);
INSERT INTO `financeiro-db`.`fin_beneficiario` (`id`, `nome`, `tipoBeneficiario`) VALUES (101, 'eric', 0);
INSERT INTO `financeiro-db`.`fin_beneficiario` (`id`, `nome`, `tipoBeneficiario`) VALUES (102, 'eric', 0);
INSERT INTO `financeiro-db`.`fin_beneficiario` (`id`, `nome`, `tipoBeneficiario`) VALUES (103, 'eric', 0);
INSERT INTO `financeiro-db`.`fin_beneficiario` (`id`, `nome`, `tipoBeneficiario`) VALUES (104, 'eric', 0);
INSERT INTO `financeiro-db`.`fin_beneficiario` (`id`, `nome`, `tipoBeneficiario`) VALUES (105, 'eric', 0);
INSERT INTO `financeiro-db`.`fin_beneficiario` (`id`, `nome`, `tipoBeneficiario`) VALUES (106, 'eric', 0);
INSERT INTO `financeiro-db`.`fin_beneficiario` (`id`, `nome`, `tipoBeneficiario`) VALUES (107, 'eric', 0);
INSERT INTO `financeiro-db`.`fin_beneficiario` (`id`, `nome`, `tipoBeneficiario`) VALUES (108, 'eric', 0);
INSERT INTO `financeiro-db`.`fin_beneficiario` (`id`, `nome`, `tipoBeneficiario`) VALUES (109, 'eric', 0);
INSERT INTO `financeiro-db`.`fin_beneficiario` (`id`, `nome`, `tipoBeneficiario`) VALUES (110, 'eric', 0);


INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `departamento`, `status`, `valor`, `beneficiario_fk`, `pagador_fk`) VALUES (110, 1335754800000, 1337754800000, 1335754800000, 0, 1, 100.11, 100, 100);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `departamento`, `status`, `valor`, `beneficiario_fk`, `pagador_fk`) VALUES (111, 1336754800000, 1338754800000, 1336754800000, 1, 1, 200.11, 101, 101);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `departamento`, `status`, `valor`, `beneficiario_fk`, `pagador_fk`) VALUES (112, 1337754800000, 1339754800000, 1337754800000, 2, 1, 300.11, 102, 102);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `departamento`, `status`, `valor`, `beneficiario_fk`, `pagador_fk`) VALUES (113, 1338754800000, 1340754800000, 1338754800000, 0, 1, 400.11, 103, 103);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `departamento`, `status`, `valor`, `beneficiario_fk`, `pagador_fk`) VALUES (114, 1339754800000, 1341754800000, 1339754800000, 1, 1, 500.11, 104,104);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `departamento`, `status`, `valor`, `beneficiario_fk`, `pagador_fk`) VALUES (115, 1340754800000, 1342754800000, 1340754800000, 2, 1, 600.11, 105,105);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `departamento`, `status`, `valor`, `beneficiario_fk`, `pagador_fk`) VALUES (116, 1341754800000, 1343754800000, 1341754800000, 0, 1, 700.11, 106,106);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `departamento`, `status`, `valor`, `beneficiario_fk`, `pagador_fk`) VALUES (117, 1342754800000, 1344754800000, 1342754800000, 1, 1, 800.11, 107,107);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `departamento`, `status`, `valor`, `beneficiario_fk`, `pagador_fk`) VALUES (118, 1343754800000, 1345754800000, 1343754800000, 2, 1, 900.11, 108,108);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `departamento`, `status`, `valor`, `beneficiario_fk`, `pagador_fk`) VALUES (119, 1344754800000, 1346754800000, 1344754800000, 0, 1, 1000.11, 109,109);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `departamento`, `status`, `valor`, `beneficiario_fk`, `pagador_fk`) VALUES (120, 1345754800000, 1347754800000, 1345754800000, 1, 1, 1100.11, 110,110);

INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `departamento`, `status`, `valor`, `beneficiario_fk`, `pagador_fk`) VALUES (121, 1346754800000, 1337754800000, 1346754800000, 2, 1, 100.11, 101, 101);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `departamento`, `status`, `valor`, `beneficiario_fk`, `pagador_fk`) VALUES (122, 1347754800000, 1338754800000, 1347754800000, 0, 1, 200.11, 102, 102);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `departamento`, `status`, `valor`, `beneficiario_fk`, `pagador_fk`) VALUES (123, 1348754800000, 1339754800000, 1348754800000, 1, 1, 300.11, 103, 103);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `departamento`, `status`, `valor`, `beneficiario_fk`, `pagador_fk`) VALUES (124, 1349754800000, 1340754800000, 1349754800000, 2, 1, 400.11,104, 104);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `departamento`, `status`, `valor`, `beneficiario_fk`, `pagador_fk`) VALUES (125, 1350754800000, 1341754800000, 1350754800000, 3, 1, 500.11, 105, 105);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `departamento`, `status`, `valor`, `beneficiario_fk`, `pagador_fk`) VALUES (126, 1351754800000, 1342754800000, 1351754800000, 0, 1, 600.11, 106, 106);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `departamento`, `status`, `valor`, `beneficiario_fk`, `pagador_fk`) VALUES (127, 1352754800000, 1343754800000, 1352754800000, 1, 1, 700.11, 107, 107);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `departamento`, `status`, `valor`, `beneficiario_fk`, `pagador_fk`) VALUES (128, 1353754800000, 1344754800000, 1353754800000, 2, 1, 800.11, 108, 108);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `departamento`, `status`, `valor`, `beneficiario_fk`, `pagador_fk`) VALUES (129, 1354754800000, 1345754800000, 1354754800000, 3, 1, 900.11, 109, 109);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `departamento`, `status`, `valor`, `beneficiario_fk`, `pagador_fk`) VALUES (130, 1355754800000, 1346754800000, 1355754800000, 0, 1, 1000.11, 110, 110);
INSERT INTO `financeiro-db`.`fin_contapagar` (`id`, `dataLimiteMilis`, `dataRealizacaoMilis`, `dataRequisicaoMilis`, `departamento`, `status`, `valor`, `beneficiario_fk`, `pagador_fk`) VALUES (131, 1356754800000, 1347754800000, 1356754800000, 1, 1, 1100.11, 101, 101);


INSERT INTO `financeiro-db`.`fin_contareceber` (`id`, `dataRealizacaoMilis`, `status`, `valor`) VALUES (100, 1327111200000, 1, 111);
INSERT INTO `financeiro-db`.`fin_contareceber` (`id`, `dataRealizacaoMilis`, `status`, `valor`) VALUES (101, 1328111200000, 1, 222.22);
INSERT INTO `financeiro-db`.`fin_contareceber` (`id`, `dataRealizacaoMilis`, `status`, `valor`) VALUES (102, 1329111200000, 1, 333.22);
INSERT INTO `financeiro-db`.`fin_contareceber` (`id`, `dataRealizacaoMilis`, `status`, `valor`) VALUES (103, 1330111200000, 1, 444.22);
INSERT INTO `financeiro-db`.`fin_contareceber` (`id`, `dataRealizacaoMilis`, `status`, `valor`) VALUES (104, 1331111200000, 1, 555.22);
INSERT INTO `financeiro-db`.`fin_contareceber` (`id`, `dataRealizacaoMilis`, `status`, `valor`) VALUES (105, 1332111200000, 1, 666.22);
INSERT INTO `financeiro-db`.`fin_contareceber` (`id`, `dataRealizacaoMilis`, `status`, `valor`) VALUES (106, 1333111200000, 1, 777.22);
INSERT INTO `financeiro-db`.`fin_contareceber` (`id`, `dataRealizacaoMilis`, `status`, `valor`) VALUES (107, 1334111200000, 1, 888.22);
INSERT INTO `financeiro-db`.`fin_contareceber` (`id`, `dataRealizacaoMilis`, `status`, `valor`) VALUES (108, 1335111200000, 1, 999.22);
INSERT INTO `financeiro-db`.`fin_contareceber` (`id`, `dataRealizacaoMilis`, `status`, `valor`) VALUES (109, 1336111200000, 1, 1000.22);
INSERT INTO `financeiro-db`.`fin_contareceber` (`id`, `dataRealizacaoMilis`, `status`, `valor`) VALUES (110, 1337111200000, 1, 111.22);
INSERT INTO `financeiro-db`.`fin_contareceber` (`id`, `dataRealizacaoMilis`, `status`, `valor`) VALUES (111, 1338111200000, 1, 222.22);
INSERT INTO `financeiro-db`.`fin_contareceber` (`id`, `dataRealizacaoMilis`, `status`, `valor`) VALUES (112, 1339111200000, 1, 133.22);
INSERT INTO `financeiro-db`.`fin_contareceber` (`id`, `dataRealizacaoMilis`, `status`, `valor`) VALUES (113, 1340111200000, 1, 666.22);
INSERT INTO `financeiro-db`.`fin_contareceber` (`id`, `dataRealizacaoMilis`, `status`, `valor`) VALUES (114, 1341111200000, 1, 777.22);
INSERT INTO `financeiro-db`.`fin_contareceber` (`id`, `dataRealizacaoMilis`, `status`, `valor`) VALUES (115, 1342111200000, 1, 444.22);
INSERT INTO `financeiro-db`.`fin_contareceber` (`id`, `dataRealizacaoMilis`, `status`, `valor`) VALUES (116, 1343111200000, 1, 111.22);
INSERT INTO `financeiro-db`.`fin_contareceber` (`id`, `dataRealizacaoMilis`, `status`, `valor`) VALUES (117, 1344111200000, 1, 999.22);
INSERT INTO `financeiro-db`.`fin_contareceber` (`id`, `dataRealizacaoMilis`, `status`, `valor`) VALUES (118, 1345111200000, 1, 444.22);
INSERT INTO `financeiro-db`.`fin_contareceber` (`id`, `dataRealizacaoMilis`, `status`, `valor`) VALUES (119, 1346111200000, 1, 666.22);


INSERT INTO `financeiro-db`.`fin_fatura` (`id`, `planoSaude_id`, `contaReceber_id`) VALUES (100, 1, 100);
INSERT INTO `financeiro-db`.`fin_fatura` (`id`, `planoSaude_id`, `contaReceber_id`) VALUES (101, 2, 101);
INSERT INTO `financeiro-db`.`fin_fatura` (`id`, `planoSaude_id`, `contaReceber_id`) VALUES (102, 3, 102);
INSERT INTO `financeiro-db`.`fin_fatura` (`id`, `planoSaude_id`, `contaReceber_id`) VALUES (103, 4, 103);
INSERT INTO `financeiro-db`.`fin_fatura` (`id`, `planoSaude_id`, `contaReceber_id`) VALUES (104, 5, 104);
INSERT INTO `financeiro-db`.`fin_fatura` (`id`, `planoSaude_id`, `contaReceber_id`) VALUES (105, 6, 105);
INSERT INTO `financeiro-db`.`fin_fatura` (`id`, `planoSaude_id`, `contaReceber_id`) VALUES (106, 7, 106);
INSERT INTO `financeiro-db`.`fin_fatura` (`id`, `planoSaude_id`, `contaReceber_id`) VALUES (107, 8, 107);
INSERT INTO `financeiro-db`.`fin_fatura` (`id`, `planoSaude_id`, `contaReceber_id`) VALUES (108, 9, 108);
INSERT INTO `financeiro-db`.`fin_fatura` (`id`, `planoSaude_id`, `contaReceber_id`) VALUES (109, 1, 109);
INSERT INTO `financeiro-db`.`fin_fatura` (`id`, `planoSaude_id`, `contaReceber_id`) VALUES (111, 2, 111);
INSERT INTO `financeiro-db`.`fin_fatura` (`id`, `planoSaude_id`, `contaReceber_id`) VALUES (112, 3, 112);
INSERT INTO `financeiro-db`.`fin_fatura` (`id`, `planoSaude_id`, `contaReceber_id`) VALUES (113, 4, 113);
INSERT INTO `financeiro-db`.`fin_fatura` (`id`, `planoSaude_id`, `contaReceber_id`) VALUES (114, 5, 114);
INSERT INTO `financeiro-db`.`fin_fatura` (`id`, `planoSaude_id`, `contaReceber_id`) VALUES (115, 6, 115);
INSERT INTO `financeiro-db`.`fin_fatura` (`id`, `planoSaude_id`, `contaReceber_id`) VALUES (116, 7, 116);
INSERT INTO `financeiro-db`.`fin_fatura` (`id`, `planoSaude_id`, `contaReceber_id`) VALUES (117, 8, 117);
INSERT INTO `financeiro-db`.`fin_fatura` (`id`, `planoSaude_id`, `contaReceber_id`) VALUES (118, 9, 118);
INSERT INTO `financeiro-db`.`fin_fatura` (`id`, `planoSaude_id`, `contaReceber_id`) VALUES (119, 1, 119);

INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `dataPedidoMilis`, `pagador_id`, `plano_id`) VALUES (101, 1335754800000, 100, 1);
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `dataPedidoMilis`, `pagador_id`, `plano_id`) VALUES (102, 1336754800000, 101, 2);
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `dataPedidoMilis`, `pagador_id`, `plano_id`) VALUES (103, 1337754800000, 102, 3);
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `dataPedidoMilis`, `pagador_id`, `plano_id`) VALUES (104, 1338754800000, 103, 4);
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `dataPedidoMilis`, `pagador_id`, `plano_id`) VALUES (105, 1339754800000, 104, 5);
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `dataPedidoMilis`, `pagador_id`, `plano_id`) VALUES (106, 1340754800000, 105, 6);
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `dataPedidoMilis`, `pagador_id`, `plano_id`) VALUES (107, 1341754800000, 106, 7);
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `dataPedidoMilis`, `pagador_id`, `plano_id`) VALUES (108, 1342754800000, 107, 8);
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `dataPedidoMilis`, `pagador_id`, `plano_id`) VALUES (109, 1343754800000, 108, 9);
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `dataPedidoMilis`, `pagador_id`, `plano_id`) VALUES (110, 1344754800000, 109, 1);
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `dataPedidoMilis`, `pagador_id`, `plano_id`) VALUES (111, 1345754800000, 110, 2);
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `dataPedidoMilis`, `pagador_id`, `plano_id`) VALUES (112, 1346754800000, 111, 3);
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `dataPedidoMilis`, `pagador_id`, `plano_id`) VALUES (113, 1347754800000, 100, 4);
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `dataPedidoMilis`, `pagador_id`, `plano_id`) VALUES (114, 1348754800000, 101, 5);
INSERT INTO `financeiro-db`.`fin_pedidoorcamento` (`id`, `dataPedidoMilis`, `pagador_id`, `plano_id`) VALUES (115, 1349754800000, 102, 6);

INSERT INTO `financeiro-db`.`fin_orcamento` (`id`, `valorFinal`, `pedido_fk`) VALUES (101, 111, 101);
INSERT INTO `financeiro-db`.`fin_orcamento` (`id`, `valorFinal`, `pedido_fk`) VALUES (102, 222, 102);
INSERT INTO `financeiro-db`.`fin_orcamento` (`id`, `valorFinal`, `pedido_fk`) VALUES (103, 333, 103);
INSERT INTO `financeiro-db`.`fin_orcamento` (`id`, `valorFinal`, `pedido_fk`) VALUES (104, 444, 104);
INSERT INTO `financeiro-db`.`fin_orcamento` (`id`, `valorFinal`, `pedido_fk`) VALUES (105, 555, 105);
INSERT INTO `financeiro-db`.`fin_orcamento` (`id`, `valorFinal`, `pedido_fk`) VALUES (106, 666, 106);
INSERT INTO `financeiro-db`.`fin_orcamento` (`id`, `valorFinal`, `pedido_fk`) VALUES (107, 777, 107);
INSERT INTO `financeiro-db`.`fin_orcamento` (`id`, `valorFinal`, `pedido_fk`) VALUES (108, 888, 108);
INSERT INTO `financeiro-db`.`fin_orcamento` (`id`, `valorFinal`, `pedido_fk`) VALUES (109, 999, 109);
INSERT INTO `financeiro-db`.`fin_orcamento` (`id`, `valorFinal`, `pedido_fk`) VALUES (110, 1111, 110);
INSERT INTO `financeiro-db`.`fin_orcamento` (`id`, `valorFinal`, `pedido_fk`) VALUES (111, 111, 111);
INSERT INTO `financeiro-db`.`fin_orcamento` (`id`, `valorFinal`, `pedido_fk`) VALUES (112, 222, 112);
INSERT INTO `financeiro-db`.`fin_orcamento` (`id`, `valorFinal`, `pedido_fk`) VALUES (113, 333, 113);
INSERT INTO `financeiro-db`.`fin_orcamento` (`id`, `valorFinal`, `pedido_fk`) VALUES (114, 444, 114);
INSERT INTO `financeiro-db`.`fin_orcamento` (`id`, `valorFinal`, `pedido_fk`) VALUES (115, 555, 115);



INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (101, 1);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (101, 2);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (101, 3);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (101, 4);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (101, 5);

INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (102, 2);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (102, 3);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (102, 4);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (102, 5);

INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (103, 7);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (103, 3);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (103, 4);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (103, 5);

INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (104, 7);

INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (105, 7);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (105, 8);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (105, 6);

INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (106, 7);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (106, 8);

INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (107, 8);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (107, 1);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (107, 6);

INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (108, 5);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (108, 6);

INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (109, 8);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (109, 4);

INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (110, 7);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (110, 6);

INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (111, 6);

INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (112, 1);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (113, 2);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (114, 3);
INSERT INTO `financeiro-db`.`fin_pedido_procedimento` (`PEDIDO_ID`, `PROCEDIMENTO_ID`) VALUES (114, 1);