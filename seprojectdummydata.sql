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

-- Dumping data for table sports_event.event: ~10 rows (approximately)
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` (`id`, `name`, `location`, `time`, `date`, `event_type`) VALUES
	('1', 'Long jump', 'Chennai', '9:00 - 10:00', '2021-10-04', 'UPCOMING'),
	('10', '100 M Dash', 'Kolkatta', '11:00 - 12:00', '2021-10-06', 'UPCOMING'),
	('2', 'High jump', 'Chennai', '9:00 - 10:00', '2021-10-03', 'ONGOING'),
	('3', 'Badminton', 'Mumbai', '14:00 - 15:00', '2021-11-03', 'UPCOMING'),
	('4', 'Hockey', 'Delhi', '10:00 - 11:00', '2021-10-03', 'ONGOING'),
	('5', 'Squash', 'Delhi', '10:00 - 11:00', '2021-10-04', 'UPCOMING'),
	('6', 'Weight Lifting', 'Delhi', '9:00 - 10:00', '2021-10-04', 'UPCOMING'),
	('7', 'Javeline', 'Mumbai', '9:00 - 10:00', '2021-10-04', 'ONGOING'),
	('8', 'Tennis', 'Kolkatta', '9:00 - 10:00', '2021-10-05', 'UPCOMING'),
	('9', 'Archery', 'Kolkatta', '11:00 - 12:00', '2021-10-05', 'UPCOMING');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;

-- Dumping data for table sports_event.message: ~3 rows (approximately)
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` (`id`, `text`, `user_id`, `time`) VALUES
	('1', 'Helllp', '1', '2021-10-15 01:45:07'),
	('2', 'Good morning', '2', '2021-10-15 17:18:44');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;

-- Dumping data for table sports_event.participant: ~50 rows (approximately)
/*!40000 ALTER TABLE `participant` DISABLE KEYS */;
INSERT INTO `participant` (`id`, `name`, `event_id`) VALUES
	('1', 'john', '1'),
	('10', 'Nicolas', '3'),
	('11', 'Caroline', '3'),
	('12', 'Prince', '4'),
	('13', 'William', '4'),
	('14', 'Charles', '4'),
	('15', 'Meghan', '4'),
	('16', 'Kate', '4'),
	('17', 'Peter', '5'),
	('18', 'James', '5'),
	('19', 'Perpetua', '5'),
	('2', 'don', '1'),
	('20', 'Christy', '5'),
	('21', 'Anderson', '5'),
	('22', 'Beth', '6'),
	('23', 'Mary', '6'),
	('24', 'Lisa', '6'),
	('25', 'Jose', '6'),
	('26', 'Pete', '6'),
	('27', 'Mitchel', '7'),
	('28', 'Cameron', '7'),
	('29', 'Phil', '7'),
	('3', 'Gwen', '1'),
	('30', 'Jay', '7'),
	('31', 'Luke', '7'),
	('32', 'Haley', '8'),
	('33', 'Alex', '8'),
	('34', 'Lilly', '8'),
	('35', 'Claire', '8'),
	('36', 'Gloria', '8'),
	('37', 'Sheldon', '9'),
	('38', 'Howard', '9'),
	('39', 'Raj', '9'),
	('4', 'john', '2'),
	('40', 'Leonard', '9'),
	('41', 'Bob', '9'),
	('42', 'Penny', '10'),
	('43', 'Bernadette', '10'),
	('44', 'Amie', '10'),
	('45', 'Flora', '10'),
	('46', 'Harriet', '10'),
	('47', 'Vicky', '1'),
	('48', 'Shelly', '1'),
	('49', 'Cliff', '2'),
	('5', 'michael', '2'),
	('50', 'Sabrina', '2'),
	('6', 'bolt', '2'),
	('7', 'Robert', '3'),
	('8', 'Mike', '3'),
	('9', 'Sam', '3');
/*!40000 ALTER TABLE `participant` ENABLE KEYS */;

-- Dumping data for table sports_event.user: ~1 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `email`, `phone`) VALUES
	('1', 'john', 'root', 'abcd@gmail.com', '+194066444'),
	('2', 'wick', 'root1', 'wick@gmail.com', '+194000440');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
