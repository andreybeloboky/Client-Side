**[GitHub]** The purpose of this assignment is to build a simple console-based Java client application that connects to the SmartHomeHub server over TCP and sends sensor data in text format. The program establishes a socket connection to localhost on port 8080, reads a line of input from the user, sends this line to the server, and waits for a response. After receiving the server’s message, the client prints it to the console and closes the connection. The project is implemented in Java and uses standard input/output streams for communication.

Getting started

You can run the Java client on your machine by opening a terminal.

**Step 1:** Install JDK 21 or newer.

**Step 2:** Open a terminal and navigate to the folder where the Client.java file is located.

**Step 3:** Compile the program using the javac command. For example: javac Client.java

**Step 4:** After compilation, run the program using the java command: java org.example.Client. The program will start, wait for user input, and then send the entered text to the SmartHomeHub server.

To use the client, you must have the SmartHomeHub server running on localhost at port 8080. The client reads a single line from the console, sends it to the server, and prints the server’s response. If the server returns a valid acknowledgment, the client displays it. If the server closes the connection or an error occurs, the client prints an error message.