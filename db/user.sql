SET FOREIGN_KEY_CHECKS = 0; 
TRUNCATE table user; 
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `triplanrest`.`user` (`id_user`,`password`,`user_type`,`username`) VALUES (1,'super','1','super');
INSERT INTO `triplanrest`.`user` (`id_user`,`password`,`user_type`,`username`) VALUES (2,'admin','2','admin');
INSERT INTO `triplanrest`.`user` (`id_user`,`password`,`user_type`,`username`) VALUES (3,'silvio','3','silviohotel');
INSERT INTO `triplanrest`.`user` (`id_user`,`password`,`user_type`,`username`) VALUES (4,'roma','4','comuneroma');
INSERT INTO `triplanrest`.`user` (`id_user`,`password`,`user_type`,`username`) VALUES (5,'alex','5','alex');
