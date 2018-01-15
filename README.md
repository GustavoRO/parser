### LOG PARSER 0.0.1 ####

# Build JAR:

mvn package

# Run JAR:
java -jar "LogParser-0.0.1-SNAPSHOT.jar" 2017-01-01.13:00:00 hourly 100 

1º Parameter: Initial date
2º Parameter: hourly/daily option of search
3º Parameter: Number of requests

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

# SQL Tests

### Get the number of requests grouped by IPs in a given time

select l.ip, count(l.ip)  FROM log_parser.full_log l
where time > '2017-01-01.00:00:00' and time < '2017-01-01.00:01:00'
group by l.ip

### List blocked IPs

select bl.ip, bl.quantity, bl.message from log_parser.blocked as bl;

### List the number of requests of a blocked IP

select bl.quantity from log_parser.blocked bl where bl.ip='192.168.234.82'
