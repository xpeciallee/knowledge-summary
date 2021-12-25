
```
CREATE DATABASE test;
CREATE TABLE user_index2 ( 
  id INT auto_increment PRIMARY KEY, 
  first_name VARCHAR (16), 
  last_name VARCHAR (16),
  id_card VARCHAR (18), 
  information text, 
  KEY name (first_name, last_name),
  FULLTEXT KEY (information),
  UNIQUE KEY (id_card) 
  );

CREATE TABLE `user`(
id INT  AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(20),
`id_card` VARCHAR(18),
UNIQUE KEY(id_card)
)
INSERT INTO `user`(`name`,`id_card`) VALUES('liyuanhang','123456789')

CREATE INDEX `name_index` ON `user`(`name`)

EXPLAIN SELECT * FROM `user` WHERE NAME LIKE "liyuanhan%"


```
