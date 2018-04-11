select * from store_client;CREATE TABLE `store_client` (
  `ID_CLIENT` int(10) NOT NULL,
  `NM_CLIENT` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_CLIENT`)
);


CREATE TABLE `store_order` (
  `ID_ORDER` int(11) NOT NULL,
  `DT_ORDER` date NOT NULL,
  `PRODUCT_NAME_ORDER` varchar(45) NOT NULL,
  `PRODUCT_VALUE_ORDER` decimal(5,2) NOT NULL,
  `PRODUCT_QUANTITY_ORDER` int(11) NOT NULL,
  `TOTAL_VALUE_ORDER` decimal(10,2) NOT NULL,
  `ID_CLIENT` int(11) NOT NULL,
  PRIMARY KEY (`ID_ORDER`),
  KEY `FK_ORDER_CLIENT_idx` (`ID_CLIENT`),
  CONSTRAINT `FK_ORDER_CLIENT` FOREIGN KEY (`ID_CLIENT`) REFERENCES `store_client` (`ID_CLIENT`) ON DELETE NO ACTION ON UPDATE NO ACTION
);


INSERT INTO store_client
    (ID_CLIENT,NM_CLIENT)
VALUES
    (1,'Roberto'),
    (2,'Clarissa'),
    (3,'Rodrigo'),
    (4,'Amanda'),
    (5,'José'),
    (6,'Paulo'),
    (7,'Bianca'),
    (8,'Cléber'),
    (9,'Felipe'),
    (10,'Maria');