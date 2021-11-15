INSERT INTO AUTHOR(AUTHOR_ID, FIRST_NAME, LAST_NAME) VALUES
(NULL, 'Craig','Wells' ),
(NULL, 'Joshua','Bloch'),
(NULL, 'Alex','Antonov'),
(NULL, 'Joyce','Farrell'),
(NULL, 'Cay','Horstmann'), 
(NULL, 'Janet','Gregory'), 
(NULL, 'Greg','Turnquist'),
(NULL, 'Walter','Savich'),
(NULL, 'John','Carnell'),
(NULL, 'Al','Sweigart'),
(NULL, 'Mark','Lutz'),
(NULL, 'Eric','Matthes'),
(NULL, 'David','Flanagan'),
(NULL, 'Marijin','Haverbeke'),
(NULL, 'Eric','Freeman'),
(NULL, 'Dawn','Griffiths'),
(NULL, 'Josh','Skeen'),
(NULL, 'Linux','Kuriosity');

INSERT INTO BOOK (BOOK_ID, BOOK_TITLE, BOOK_YEAR, AUTHOR_ID) VALUES 
(NULL, 'Spring Boot in Action',                                                                     2018, 1.99,  (SELECT Author_ID from author where last_name = 'Wells')),
(NULL, 'Core Java for the Impatient',                                                               2018, 2.99,  (SELECT Author_ID from author where last_name = 'Horstmann')),
(NULL, 'Spring Microservices in Action',                                                            2016, 3.99,  (SELECT Author_ID from author where last_name = 'Carnell')),
(NULL, 'Java Programming',                                                                          2018, 4.99,  (SELECT Author_ID from author where last_name = 'Farrell')),
(NULL, 'Beginning Java Databases',                                                                  2001, 5.99,  (SELECT Author_ID from author where last_name = 'Carnell')),
(NULL, 'Effective Java',                                                                            2017, 6.99,  (SELECT Author_ID from author where last_name = 'Bloch')),
(NULL, 'Spring Boot 2.0',                                                                           2017, 7.99,  (SELECT Author_ID from author where last_name = 'Antonov')),
(NULL, 'Spring Boot Cookbook',                                                                      2015, 8.99,  (SELECT Author_ID from author where last_name = 'Antonov')),
(NULL, 'Learning spring Boot 2.0',                                                                  2017, 9.99,  (SELECT Author_ID from author where last_name = 'Turnquist')),
(NULL, 'Absolute Java',                                                                             2015, 10.99, (SELECT Author_ID from author where last_name = 'Savich')),
(NULL, 'Agile Testing',                                                                             2015, 11.99, (SELECT Author_ID from author where last_name = 'Gregory')),
(NULL, 'Java: An Introduction to Problem Solving',                                                  2017, 12.99, (SELECT Author_ID from author where last_name = 'Savich')),
(NULL, 'Automate the Boring Stuff with Python: Practical Programming for Total Beginners',          2015, 14.41, (SELECT Author_ID from author where last_name = 'Sweigart')),
(NULL, 'Programming Python: Powerful Object-Oriented Programming',                                  2011, 90.15, (SELECT Author_ID from author where last_name = "Lutz")),
(NULL, 'Python Crash Course, 2nd Edition: A Hands-On, Project-Based Introduction to Programming',   2019, 33.00, (SELECT Author_ID from author where last_name = 'Matthes')),
(NULL, 'JavaScript: The Definitive Guide: Master the Worlds Most-Used Programming Language',        2020, 73.27, (SELECT Author_ID from author where last_name = 'Flanagan')),
(NULL, 'Eloquent JavaScript, 3rd Edition: A Modern Introduction to Programming',                    2018, 42.02, (SELECT Author_ID from author where last_name = 'Haverbeke')),
(NULL, 'Head First JavaScript Programming: A Brain-Friendly Guide',                                 2014, 48.90, (SELECT Author_ID from author where last_name = 'Freeman'))
(NULL, 'ead First Kotlin: A Brain-Friendly Guide',                                                  2019, 61.47, (SELECT Author_ID from author where last_name = 'Griffiths')),
(NULL, 'Kotlin Programming: The Big Nerd Ranch Guide',                                              2018, 53.88, (SELECT Author_ID from author where last_name = 'Skeen')),
(NULL, 'KOTLIN: Interview QA',                                                                      2021, 0.00,  (SELECT Author_ID from author where last_name = 'Kuriosity'));