SET FOREIGN_KEY_CHECKS = 0; 
TRUNCATE table hotel; 
SET FOREIGN_KEY_CHECKS = 1;
INSERT INTO `triplanrest`.`hotel` (`id_hotel`,`latitude`,`longitude`,`namehotel`,`numerostelle`,`id_city`,`id_user`) VALUES (1,41.3455,12.9876,'Excelsior',4,1,3);
INSERT INTO `triplanrest`.`hotel` (`id_hotel`,`latitude`,`longitude`,`namehotel`,`numerostelle`,`id_city`,`id_user`) VALUES (3,41.6545,2.9276,'Barceloneta',3,5,3);
