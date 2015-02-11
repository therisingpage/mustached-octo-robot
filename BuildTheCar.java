package buildCar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import utils.ReadFile;
import model.Automotive;

/**
 * @author Lynn Kirabo
 * This is class called BuildTheCar
 * It is responsible for setting the filename 
 * and calling the ReadFile class to parse the file
 * Creating an Automotive Object
 * Saving that object to a file
 * Reading in that saved file into the program
 * Printing the content of the read in file.
 *
 */

@SuppressWarnings("serial")
public class BuildTheCar implements Serializable
{

	public static void main(String[] args) 
	{
		
		/*
		 * Create An Automotive Object
		 *
		 * */
		
		String filename = "CarConfiguration.txt";
		ReadFile myFile = new ReadFile();
		Automotive FordZTW = null;
		FordZTW = myFile.buildAutoObject(filename, FordZTW);
		FordZTW.print();
		
		/*
		 * Write The Automotive Object to file
		 *
		 * */
		try 
		{
			FileOutputStream fileStream = new FileOutputStream("myAutoMoto.ser");
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			os.writeObject(FordZTW);
			os.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.print("Sorry, Could not create file");
		} 
		catch (IOException e) 
		{
			System.out.print("Sorry, Could not write file");
		} 
		finally 
		{	}
		
		/*
		 * Read Serialized file back in
		 *
		 * */
		try {
			FileInputStream inputStream = new FileInputStream("myAutoMoto.ser");
			ObjectInputStream os = new ObjectInputStream(inputStream);
			Automotive serialFordZTW = (Automotive) os.readObject();
			System.out.println("\n\n------------------- Below is the input from the Serialized File ---------------");
			serialFordZTW.print();
			os.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.print("Cannot connect to file");
		} 
		catch (IOException e) 
		{
			System.out.print("Cannot read the file");
		} 
		catch (ClassNotFoundException e)
		{
			System.out.print("Class Not Found");		
			
		}
		finally
		{	}
		
	}

}
