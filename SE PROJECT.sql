-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.26 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for sports_event
CREATE DATABASE IF NOT EXISTS `sports_event` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sports_event`;

-- Dumping structure for table sports_event.event
CREATE TABLE IF NOT EXISTS `event` (
  `id` varchar(25) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `location` varchar(150) DEFAULT NULL,
  `time` varchar(150) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `event_type` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table sports_event.event: ~30 rows (approximately)
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` (`id`, `name`, `location`, `time`, `date`, `event_type`) VALUES
	('1', 'Long jump', 'Denton', '9am-10am', '2022-04-24', 'UPCOMING'),
	('10', 'Baseball', 'Dallas', '1pm-2pm', '2022-04-19', 'UPCOMING'),
	('11', 'Baseball', 'Arkansas', '1pm-2pm', '2022-04-14', 'ONGOING'),
	('12', 'Baseball', 'Alaska', '11am-12am', '2022-04-12', 'ONGOING'),
	('13', 'Table Tennis', 'Kansas', '1pm-2pm', '2022-04-21', 'UPCOMING'),
	('14', 'Table Tennis', 'Buffalo', '1pm-2pm', '2022-04-20', 'UPCOMING'),
	('15', 'Football', 'Dallas', '10am-12pm', '2022-04-16', 'ONGOING'),
	('16', 'Running', 'Arkansas', '1pm-2pm', '2022-04-14', 'ONGOING'),
	('17', 'Tennis', 'Austin', '5pm-7pm', '2022-04-12', 'ONGOING'),
	('18', 'Squash', 'District of Columbia', '7pm-8pm', '2022-04-13', 'ONGOING'),
	('19', 'Badminton', 'Denton', '9am-11am', '2022-04-19', 'UPCOMING'),
	('2', 'High jump', 'Dallas', '9pm-10pm', '2022-04-15', 'ONGOING'),
	('20', 'Archery', 'Arizona', '8am-10am', '2022-04-19', 'UPCOMING'),
	('21', 'BASEBALL', 'illinois', '2pm-3pm', '2022-04-21', 'UPCOMING'),
	('22', 'CHESS', 'florida', '7pm-8pm', '2022-04-23', 'UPCOMING'),
	('23', 'TABLETENNIS', 'texas', '4pm-5pm', '2022-04-25', 'UPCOMING'),
	('24', 'VOLLEYBALL', 'Austin', '1pm-2pm', '2022-04-27', 'UPCOMING'),
	('25', 'CRICKET', 'arkansas', '', '2022-04-27', 'UPCOMING'),
	('26', 'VOLLEYBALL', 'connecticut', '10am-11am', '2022-04-19', 'UPCOMING'),
	('27', 'VOLLEYBALL', 'connecticut', '10am-11am', '2022-04-27', 'UPCOMING'),
	('28', 'VOLLEYBALL', 'connecticut', '1pm-2pm', '2022-04-20', 'UPCOMING'),
	('29', 'TABLETENNIS', 'colorado', '4pm-5pm', '2022-04-13', 'ONGOING'),
	('3', 'Badminton', 'Frisco', '2pm-3pm', '2022-04-23', 'UPCOMING'),
	('30', 'VOLLEYBALL', 'delaware', '4pm-5pm', '2022-04-17', 'ONGOING'),
	('4', 'Hockey', 'Little Elm', '1pm-3pm', '2022-04-16', 'ONGOING'),
	('5', 'Squash', 'San Fransisco', '12pm-2pm', '2022-04-22', 'UPCOMING'),
	('6', 'Weight Lifting', 'New York', '9am-11am', '2022-04-18', 'UPCOMING'),
	('7', 'Javeline', 'Atlanta', '9am-10am', '2022-04-14', 'ONGOING'),
	('8', 'Tennis', 'Austin', '5pm-7pm', '2022-04-17', 'UPCOMING'),
	('9', 'Archery', 'Plano', '9pm-11pm', '2022-04-25', 'UPCOMING');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;

-- Dumping structure for table sports_event.message
CREATE TABLE IF NOT EXISTS `message` (
  `id` varchar(25) NOT NULL,
  `text` varchar(1000) DEFAULT NULL,
  `user_id` varchar(25) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table sports_event.message: ~11 rows (approximately)
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` (`id`, `text`, `user_id`, `time`) VALUES
	('1', '<p>Hello, I am looking to participate in basketball event</p>', '101', '2021-10-22T18:46:33.000Z'),
	('10', '<p>ert</p>', '10', '2022-04-02T14:42:01.000Z'),
	('11', '', '10', '2022-04-02T14:42:36.000Z'),
	('2', '<p>Hey charan, we have a position open. Please feel free to join</p>', '104', '2021-10-27T21:39:46.000Z'),
	('3', '<p>Thankyou</p><p><br></p>', '101', '2021-10-27T22:52:58.000Z'),
	('4', '<p>When will the football event starts?</p>', '103', '2021-10-27T22:54:45.000Z'),
	('5', '<p>I joined the tennis event</p>', '107', '2021-10-30T02:58:37.000Z'),
	('6', '<p>Hi Guys</p>', '105', '2021-10-30T14:55:07.000Z'),
	('7', '<p>neat</p>', '12', '2021-12-04T15:21:15.000Z'),
	('8', '<p>lets play baseball</p>', '13', '2021-12-04T16:48:52.000Z'),
	('9', '<p>heollo howl areu</p>', '10', '2022-02-16T18:36:15.000Z');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;

-- Dumping structure for table sports_event.participant
CREATE TABLE IF NOT EXISTS `participant` (
  `id` varchar(25) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `event_id` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `event_id` (`event_id`),
  CONSTRAINT `participant_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table sports_event.participant: ~19 rows (approximately)
/*!40000 ALTER TABLE `participant` DISABLE KEYS */;
INSERT INTO `participant` (`id`, `name`, `event_id`) VALUES
	('10', 'johndoe', '11'),
	('101', 'Charan', '2'),
	('102', 'Anudeep', '9'),
	('103', 'Abhiram', '3'),
	('104', 'Aditya', '15'),
	('105', 'Chaitanya', '20'),
	('106', 'Saikrishna', '19'),
	('107', 'Manvitha', '11'),
	('108', 'Nithesh', '11'),
	('11', 'Charan', '11'),
	('12', 'bric', '1'),
	('13', 'akhanda', '10'),
	('14', 'akhanda', '12'),
	('15', 'akhanda', '25'),
	('16', 'akhanda', '13'),
	('17', 'akhanda', '17'),
	('18', 'akhanda', '28'),
	('19', 'akhanda', '18'),
	('9', 'akhanda', '11');
/*!40000 ALTER TABLE `participant` ENABLE KEYS */;

-- Dumping structure for table sports_event.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` varchar(25) NOT NULL,
  `username` varchar(150) DEFAULT NULL,
  `password` varchar(150) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `phone` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table sports_event.user: ~15 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `email`, `phone`) VALUES
	('10', 'akhanda', 'Software1!', 'akhanda@wakanda.com', '9848022338'),
	('101', 'Charan', 'charan123', 'charan@gmail.com', '9490758219'),
	('102', 'Anudeeep', 'anudeep123', 'anudeep@gmail.com', '9103425487'),
	('103', 'Abhiram', 'abhiram123', 'abhiram@gmail.com', '9213476123'),
	('104', 'Aditya', 'aditya123', 'aditya@gmail.com', '7245612837'),
	('105', 'Chaitanya', 'chaitanya123', 'chaitanya@unt.com', '9832357872'),
	('106', 'Saikrishna', 'saikrishna123', 'saikrishna@unt.com', '7612756234'),
	('107', 'Manvitha', 'manvitha123', 'smanvitha@unt.com', '9867256721'),
	('108', 'Nithesh', 'nithesh123', 'nithesh@unt.com', '5672135888'),
	('109', 'superuser', 'superuser', 'superuser@unt.com', '9988772345'),
	('11', 'asfa', '123456', 'asda@hmail.com', '9848444444'),
	('12', 'johndoe', 'nope', 'johndoe@gmail.com', '555-555-5555'),
	('13', 'bric', 'password', 'brice@mail.com', '8061234567'),
	('14', 'Raajitha', '123', 'dajshdlsahl@kadjka.csodj', '9876543210'),
	('15', 'abcd1', 'Helloworld1!', 'abcd@gmail.com', '9999999999');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
