# CSC402-Final-Project
My final project for CSC402 at the University of Rhode Island in the fall of 2015.

This project is a program that compiles a simple domain-specific language into a batch file for the purposes of creating a simple animation.  The grammar of the DSL can be found in the "anim.g" file within the AST folder.

The program basically works by builting an abstract syntax tree, then visiting the leaves of the tree to generate code, concatenates the code into a gigantic string, then outputs that string.

The files "402 Final Proposal" and "402 Final Report" explain some of the thought process behind the projet that I handed in to my professor.

The Test folder includes some example code written in the anim DSL that you can run through to see their output.

Below is an explanation of how to get it to work in Eclipse.  The project was originally done in with gedit and the command line on an Ubuntu Virtual Machine provided by the instructor, so this is a slight workaround to use Eclipse in Windows.

1: Obtain the files and create an Eclipse project:

Pull the project files down from the repo.
In Eclipse, create a new java project. (For our purposes, we'll call it 402FINAL.)
Open the 402FINAL folder.
Select the files within the AST folder from your file system, and drag them to the src folder in Eclipse.
Choose to copy them to it the project.

2: Making the necessary ANTLR files working with Eclipse:

Go to http://www.antlr.org/download/antlr-4.5.2-complete.jar to get the ANTLR jar file.
Right click on the 402FINAL project folder, and select properties.
Select Java Build Path, then select Add External JARs.
Select the ANTLR file within your file system.
Click Apply.

3: Telling Eclipse to send a file to the program as a parameter:

While the 402FINAL project is selected, under the "Run" menu, select "Run Configurations."
Click the "New Launch Configuration" button.
Select the "Arguments" tab.
Under "Program arguments," insert the full path of the .anim file you wish to use.  (If the path includes a space, Eclipse might not like it.)

4: Telling Eclipse to pipe the output into a file:

While the 402FINAL project is selected, under the "Run" menu, select "Run Configurations."
Select the "Common" tab.
Check the "Output File" checkbox.
Click the "File System..." button.
In the "File name:" field, enter the file name and extension of the output. (I suggest output.bat)

Once all that is done, click Run.
Navigate to output.bat and double click it to run it.

Credit goes to the creators of these helpful links:

http://www.oursland.net/tutorials/antlr/AntlrEclipse.html
http://stackoverflow.com/questions/8107980/working-with-file-in-eclipse
http://stackoverflow.com/questions/5714053/how-can-we-redirect-eclipse-console-output-to-a-file

One last thing: You may have noticed that Git gives you all sorts of warnings about "replacing LF with CRLF."  It shouldn't cause a problem, and it worked fine when I tested it.  Just in case, I have included a zip file of the files which should hopefully not be altered in the same way.
