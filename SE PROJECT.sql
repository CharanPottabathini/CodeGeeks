create schema se_project;
use  se_project;


CREATE TABLE IF NOT EXISTS `user` (
  `id` varchar(25) NOT NULL,
  `username` varchar(150) DEFAULT NULL,
  `password` varchar(150) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `phone` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `user` (`id`, `username`, `password`, `email`, `phone`) VALUES
	('101', 'Charan', 'charan123', 'charan@gmail.com', '9490758219'),
	('102', 'Anudeeep', 'anudeep123', 'anudeep@gmail.com', '9103425487'),
	('103', 'Abhiram', 'abhiram123', 'abhiram@gmail.com', '9213476123'),
	('104', 'Aditya', 'aditya123', 'aditya@gmail.com', '7245612837'),
	('105', 'Chaitanya', 'chaitanya123', 'chaitanya@unt.com', '9832357872'),
    ('106', 'Saikrishna', 'saikrishna123', 'saikrishna@unt.com', '7612756234'),
    ('107', 'Manvitha', 'manvitha123', 'smanvitha@unt.com', '9867256721'),
    ('108', 'Nithesh', 'nithesh123', 'nithesh@unt.com', '5672135888'),
    ('109', 'superuser', 'superuser', 'superuser@unt.com', '9988772345');

CREATE TABLE IF NOT EXISTS `event` (
  `id` varchar(25) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `location` varchar(150) DEFAULT NULL,
  `time` varchar(150) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `event_type` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


INSERT INTO `event` (`id`, `name`, `location`, `time`, `date`, `event_type`) VALUES
	('1', 'Long jump', 'Denton', '9am-10am', '2021-10-04', 'UPCOMING'),
    ('2', 'High jump', 'Dallas', '9pm-10pm', '2021-10-03', 'ONGOING'),
    ('3', 'Badminton', 'Frisco', '2pm-3pm', '2021-11-03', 'UPCOMING'),
	('4', 'Hockey', 'Little Elm', '1pm-3pm', '2021-10-03', 'ONGOING'),
	('5', 'Squash', 'San Fransisco', '12pm-2pm', '2021-10-04', 'UPCOMING'),
	('6', 'Weight Lifting', 'New York', '9am-11am', '2021-10-04', 'UPCOMING'),
	('7', 'Javeline', 'Atlanta', '9am-10am', '2021-10-04', 'ONGOING'),
	('8', 'Tennis', 'Austin', '5pm-7pm', '2021-10-05', 'UPCOMING'),
	('9', 'Archery', 'Plano', '9pm-11pm', '2021-10-05', 'UPCOMING'),
	('10', 'Baseball', 'Dallas', '1pm-2pm', '2021-11-29', 'UPCOMING'),
	('11', 'Baseball', 'Arkansas', '1pm-2pm', '2021-11-20', 'ONGOING'),
	('12', 'Baseball', 'Alaska', '11am-12am', '2021-11-20', 'ONGOING'),
	('13', 'Table Tennis', 'Kansas', '1pm-2pm', '2021-11-29', 'UPCOMING'),
	('14', 'Table Tennis', 'Buffalo', '1pm-2pm', '2021-11-28', 'UPCOMING'),
	('15', 'Football', 'Dallas', '10am-12pm', '2021-11-22', 'ONGOING'),
	('16', 'Running', 'Arkansas', '1pm-2pm', '2021-11-22', 'ONGOING'),
	('18', 'Squash', 'District of Columbia', '7pm-8pm', '2021-11-22', 'ONGOING'),
	('19', 'Badminton', 'Denton', '9am-11am', '2021-11-29', 'UPCOMING'),	
	('20', 'Archery', 'Arizona', '8am-10am', '2021-11-29', 'UPCOMING');
	

CREATE TABLE IF NOT EXISTS `message` (
  `id` varchar(25) NOT NULL,
  `text` varchar(1000) DEFAULT NULL,
  `user_id` varchar(25) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);



INSERT INTO `message` (`id`, `text`, `user_id`, `time`) VALUES
	('1', '<p>Hello, I am looking to participate in basketball event</p>', '101', '2021-10-22T18:46:33.000Z'),
	('2', '<p>Hey charan, we have a position open. Please feel free to join</p>', '104', '2021-10-27T21:39:46.000Z'),
	('3', '<p>Thankyou</p><p><br></p>', '101', '2021-10-27T22:52:58.000Z'),
	('4', '<p>When will the football event starts?</p>', '103', '2021-10-27T22:54:45.000Z'),
	('5', '<p>I joined the tennis event</p>', '107', '2021-10-30T02:58:37.000Z'),
	('6', '<p>Hi Guys</p>', '105', '2021-10-30T14:55:07.000Z');




CREATE TABLE IF NOT EXISTS `participant` (
  `id` varchar(25) NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `event_id` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `event_id` (`event_id`),
  CONSTRAINT `participant_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`)
);



INSERT INTO `participant` (`id`, `name`, `event_id`) VALUES
	('101', 'Charan', '2'),
	('102', 'Anudeep', '9'),
	('104', 'Aditya', '15'),
	('103', 'Abhiram', '3'),
	('107', 'Manvitha', '11'),
	('105', 'Chaitanya', '20'),
	('106', 'Saikrishna', '19'),
	('108', 'Nithesh', '11');

