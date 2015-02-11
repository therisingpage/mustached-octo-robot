package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import model.Automotive;


/**
 * @author Lynn Kirabo
 * This is class called ReadFile
 * It is responsible for reading in the file 
 * and setting the configurations of the car.
 * It has an inner class called Option
 *
 */
public class ReadFile
{
	
	public Automotive buildAutoObject(String fileName, Automotive myMoto)
	{
		BufferedReader configReader = null;
		String configLine = null;
		
		try
		{
			configReader  = new BufferedReader(new FileReader(fileName));
		}
		catch(FileNotFoundException e)
		{
			System.err.println("The File " + fileName + " does not exist");
            System.exit(2);
		}
		finally
		{	}
		
		try
        {
			configLine = configReader.readLine();
        }
        catch(IOException e)
        {
            System.err.println("An error occured while trying to read the line.");
            System.exit(2);
        } 
		finally
		{	}
		
		while(configLine != null)
	    {
			StringTokenizer st = new StringTokenizer(configLine);
			while(st.hasMoreTokens())
			{
				//myMoto.setValuesOfOptionSet(OptionSetName, theName, xPrice);
				String tempString = st.nextToken("\n");
				String [] parseString;
				String tempSize, tempPrice, tempSetName, tempSetOption, motoName;
				int convertSize; 
				float convertPrice, basePrice;
				
				
				//The delimiter : below will only be found on the first line, that contains Name of object and Number of options
				if (tempString.contains(":")) 
				{
					parseString = tempString.split("\\:");
					motoName = parseString[0];
					basePrice = Float.valueOf(parseString[1]);
					tempSize = parseString[2].trim();
					convertSize = Integer.parseInt(tempSize);
					myMoto = new Automotive(motoName, convertSize, basePrice);
				}
				
				//The delimiter = below will only be found with the OptionSet names.
				if (tempString.contains("=")) 
				{
					parseString = tempString.split("\\=");
					tempSize = parseString[1].trim();
					convertSize = Integer.parseInt(tempSize);
					myMoto.createOptionSet(parseString[0], convertSize);
				}
				
				//The delimiter , will only be found with the combination of OptionSet names, Options and their prices.
				if (tempString.contains(",")) 
				{
					parseString = tempString.split("\\,");
					tempSetName = parseString[0];
					tempSetOption = parseString[1];
					tempPrice = parseString[2].trim();
					convertPrice = Float.valueOf(tempPrice);
					myMoto.setValuesOfOption(tempSetName, tempSetOption, convertPrice);
										
				}
				
				//The delimiter " " will only be found on lines spacing the content
				if(tempString.contains(" "))
				{
					continue;
				}
							
			}
				
			try
            {
				configLine = configReader.readLine();				
            }
            catch(IOException e)
            {
                System.err.println("An error occured while trying to read the line.");
                System.exit(2);
            }
			finally
			{	}
	    }
		
		
		try
		{
			configReader.close();
		}
		catch(IOException e)
		{
			System.err.println("An error occured while trying to close the file.");
			System.exit(1);
		}
		finally
		{	}
		
		return myMoto;
		
	}
}
