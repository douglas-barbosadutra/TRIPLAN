SET FOREIGN_KEY_CHECKS = 0; 
TRUNCATE table eventi; 
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `triplanrest`.`eventi` (`id_evento`,`nameevento`,`meseevento`,`id_city`,`id_user`) VALUES (1,'oktoberfest','ottobre',7,4);
INSERT INTO `triplanrest`.`eventi` (`id_evento`,`nameevento`,`meseevento`,`id_city`,`id_user`) VALUES (2,'concerto baglioni','aprile',1,4);
INSERT INTO `triplanrest`.`eventi` (`id_evento`,`nameevento`,`meseevento`,`id_city`,`id_user`) VALUES (3,'maratona','settembre',8,4);
INSERT INTO `triplanrest`.`eventi` (`id_evento`,`nameevento`,`meseevento`,`id_city`,`id_user`) VALUES (4,'olimpiadi','luglio',6,4);
