ChatSCS (Chat System Using OpenAI GPT)

This project is a simple chat system that utilizes OpenAI's GPT (Generative Pre-trained Transformer) model to generate responses based on user input. It includes a graphical user interface (GUI) for easy interaction.

Features
User Interaction: Users can enter messages in the input area of the GUI.
Response Generation: The system generates responses using OpenAI's GPT model.
Graphical User Interface (GUI): Provides a user-friendly interface for communication.
Error Handling: Handles errors gracefully, displaying an error message if an exception occurs during response generation.

Prerequisites
Java Development Kit (JDK)
Internet connection (for API communication with OpenAI)

Getting Started
Clone the Repository: Clone this repository to your local machine -> git clone https://github.com/your-username/chatSCS.git
Compile the Code: Compile the Java files using a Java compiler -> javac com/example/demo/*.java
Run the Application: Execute the main Java file to start the chat system -> java com.example.demo.App

Usage
The GUI window will appear with an input area labeled "Send Message".
Type your message in the input area.
Click the "Generate Response" button to send the message and receive a response.
The response will appear in the output area labeled "The response".

Configuration (OpenAI API Key)
To use the OpenAI GPT model for response generation, you need to obtain an API key from OpenAI. 
Replace the placeholder API key in the OpenAIConnection.java file with your actual API key.
con.setRequestProperty("Authorization", "Bearer your_api_key_here");
