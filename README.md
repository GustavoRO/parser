# parser
Parser Test

# Main class: com.ef.Parser.java. Example on how to run:

java -cp "parser.jar" com.ef.Parser --accesslog=/path/to/file --startDate=2017-01-01.13:00:00 --duration=hourly --threshold=100 

# MySQL schema

CREATE TABLE `blocked` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


 CREATE TABLE `full_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `agent` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `request_type` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


