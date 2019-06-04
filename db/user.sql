SET FOREIGN_KEY_CHECKS = 0; 
TRUNCATE table user; 
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `triplanrest`.`user` (`id_user`,`password`,`user_type`,`username`) VALUES (1,'super','superuser','super');
INSERT INTO `triplanrest`.`user` (`id_user`,`password`,`user_type`,`username`) VALUES (2,'admin','touroperator','admin');
INSERT INTO `triplanrest`.`user` (`id_user`,`password`,`user_type`,`username`) VALUES (3,'silvio','gestorehotel','silviohotel');
INSERT INTO `triplanrest`.`user` (`id_user`,`password`,`user_type`,`username`) VALUES (4,'roma','gestoreeventi','comuneroma');
INSERT INTO `triplanrest`.`user` (`id_user`,`password`,`user_type`,`username`) VALUES (5,'alex','user','alex');
