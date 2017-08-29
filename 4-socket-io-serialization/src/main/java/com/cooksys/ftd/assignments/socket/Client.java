package com.cooksys.ftd.assignments.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.xml.bind.JAXBException;

import com.cooksys.ftd.assignments.socket.model.Config;
import com.cooksys.ftd.assignments.socket.model.Student;

public class Client {

    /**
     * The client should load a {@link com.cooksys.ftd.assignments.socket.model.Config} object from the
     * <project-root>/config/config.xml path, using the "port" and "host" properties of the embedded
     * {@link com.cooksys.ftd.assignments.socket.model.RemoteConfig} object to create a socket that connects to
     * a {@link Server} listening on the given host and port.
     *
     * The client should expect the server to send a {@link com.cooksys.ftd.assignments.socket.model.Student} object
     * over the socket as xml, and should unmarshal that object before printing its details to the console.
     */
    public static void main(String[] args) {
        
    	//File file = new File("config.xml");
    	
    	Config config = Utils.loadConfig("C:/Users/ftd-1/code/combined-assignments/4-socket-io-serialization/config/config.xml", Utils.createJAXBContext());
    	try (Socket client = new Socket(config.getRemote().getHost(), config.getRemote().getPort());){
			
			Student student = (Student) Utils.createJAXBContext().createUnmarshaller().unmarshal(client.getInputStream());
			System.out.println(student);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
    	
    }
    
}
