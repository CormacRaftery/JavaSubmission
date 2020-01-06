Author: Cormac Raftery
Id: G00348802

This is a project given to me for Advanced object oriented programming by John Healy. All code is derived from the code stubs given to the students by John Healy.

The ngrams.war file should deploy when placed in the apache tomcat webapp folder which should then make ngrams available at the localhost. There should be a text box for entry, an option list and a submission button. However this only interacts with the serviceHandler class. To involve all of the classes it is advised to open the classes file in an IDE and run the parser class.

ngrams.war - A Java Web Application Archive  containing my API and JSP/Servlets

src - A directory that contains the packaged source code for my application.

design.png - A UML class diagram of my API design.
docs - A directory containing the JavaDocs for my application. 

Structure - The war file should deploy correctly and detect a file by the name of "wili-2018-Small-Edited.txt" when the file is placed in the ngrams folder.

README - Describes each element of the project.

UML - Generated UML of the project.

JavaDocs - I commented all the code and classes and generated a javaDocs in the file docs.

Message Queue - When text is submitted via the service handler on the localhost the text, jobId and option should be added to the inQueue.

Language Detection - The file is broken into n-grams and added to the database when the parser class is run but does not detect the language when given a string.

Cohesion - The classes do all interact with eachother as depicted in the UML diagram.

Coupling - All classes are loosely couple with eachother.

Extras - All code is fully commented with the application running from the command line when the parser class is run.

