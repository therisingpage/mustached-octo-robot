package model;

import java.io.Serializable;
import model.OptionSet.Option;

/**
 * @author Lynn Kirabo
 * 
 * This class is called the automotive class.
 * It has a Name, Price and a collection of OptionSets.
 * It is the class through which is responsible for 
 * setting the optionset and option of the car
 *
 */
@SuppressWarnings("serial")
public class Automotive implements Serializable
{
	private String autoName;
	private float basePrice;
	private OptionSet [] optionSetArray;
	private int i = 0;
	
	public Automotive()
	{	}
	
	public Automotive(String n, int size, float x)
	{
		this.setAutoName(n);
		this.setOptionSetSize(size);
		this.setBasePrice(x);	
	}
	
	//Reading Function
	// Get operation
	public String getAutoName() 
	{
		return autoName;
	}

	public float getBasePrice() 
	{
		return basePrice;
	}

	public OptionSet getOpset(int i) 
	{
		return optionSetArray[i];
	}
	
	//Find Operation
	public String findOptionSetWithName(String name)
	{
		OptionSet os1 = new OptionSet();
		os1.setOptionSetName(name);
		
		return os1.displayOptionsArray();
	}
	
	public float findOptionPriceWithName(String name)
	{
		OptionSet os1 = new OptionSet();
		Option o1 = os1.new Option(name);
		
		return o1.getPrice();		
	}
	
	//Set Operation
	public void setAutoName(String autoName) 
	{
		this.autoName = autoName;
	}

	public void setBasePrice(float basePrice) 
	{
		this.basePrice = basePrice;
	}
	

	public void setOptionSetSize(int size)
	{
		int aSize = size;
		optionSetArray = new OptionSet[aSize];
	}
	

	public void setValuesOfOptionSet(String optionSetName, String theName, float xPrice) 
	{
		
		optionSetArray[i] = new OptionSet();
		optionSetArray[i].setOptionSetName(optionSetName);
		optionSetArray[i].setOptionsArray(theName, xPrice);
		i++;
	}
	
	public void setValuesOfOption(String osName, String aName, float yPrice)
	{
		for (int z = 0; z < optionSetArray.length; z++)
		{
			String compareName = osName;
			String tempNameVar = optionSetArray[z].getOptionSetName();
			if(tempNameVar.contains(compareName))
			{
				optionSetArray[z].setOptionsArray(aName, yPrice);
				z = optionSetArray.length - 1;
			}
		}	
	}
	
	//Delete Operation
	public void deleteAnOptionSet(String optionSetName)
	{
		for (int z = 0; z < optionSetArray.length; z++)
		{
			String compareName = optionSetName;
			String tempNameVar = optionSetArray[z].getOptionSetName();
			if(tempNameVar.contains(compareName))
			{
				optionSetArray[z] = null;
				optionSetArray[z] = optionSetArray[optionSetArray.length - 1];
				optionSetArray[optionSetArray.length - 1] = null;
				z = optionSetArray.length - 1;
			}
			
		}
	}
	
	public void deleteAnOption(String osName, String optionName)
	{
		for (int z = 0; z < optionSetArray.length; z++)
		{
			String compareName = osName;
			String tempNameVar = optionSetArray[z].getOptionSetName();
			if(tempNameVar.contains(compareName))
			{
				Option[] tempOptionsArray = optionSetArray[z].getOptionsArray();
				
				for (int aa = 0; aa < tempOptionsArray.length; aa++)
				{
					String deleteName = optionName;
					String compareToName = tempOptionsArray[aa].getName();
					if(compareToName.contains(deleteName))
					{
						tempOptionsArray[aa] = null;
						tempOptionsArray[aa] = tempOptionsArray[tempOptionsArray.length - 1];
						aa = tempOptionsArray.length - 1;
						z = optionSetArray.length - 1;
					}
				}
			}
		}
	}
	
	//Update Operation	
	public void updateValuesOfOptionSet(String oldOptionSetName, String newOptionSetName, String newoptionName, float newPrice)
	{
		for (int z = 0; z < optionSetArray.length; z++)
		{
			String compareName = oldOptionSetName;
			String tempNameVar = optionSetArray[z].getOptionSetName();
			if(tempNameVar.contains(compareName))
			{
				optionSetArray[z].setOptionSetName(newOptionSetName);
				optionSetArray[z].setOptionsArray(newoptionName, newPrice);
				z = optionSetArray.length - 1;
			}
		}	
	}
	
	public void updateValuesOfOption(String optionSetName, String oldOptionName, String newoptionName, float newPrice)
	{
		for (int z = 0; z < optionSetArray.length; z++)
		{
			String compareName = optionSetName;
			String tempNameVar = optionSetArray[z].getOptionSetName();
			if(tempNameVar.contains(compareName))
			{
				Option[] tempOptionsArray = optionSetArray[z].getOptionsArray();
				
				for (int aa = 0; aa < tempOptionsArray.length; aa++)
				{
					String deleteName = oldOptionName;
					String compareToName = tempOptionsArray[aa].getName();
					if(compareToName.contains(deleteName))
					{
						tempOptionsArray[aa].setName(newoptionName);
						tempOptionsArray[aa].setPrice(newPrice);
						aa = tempOptionsArray.length - 1;
						z = optionSetArray.length - 1;
					}
				}
			}
			
		}
	}

	public void createOptionSet(String optionSetName, int optionSetSize )
	{
		optionSetArray[i] = new OptionSet(optionSetName, optionSetSize);
		i++;
	}
	
	public void print()
	{
		int i;
		int len = optionSetArray.length;
		StringBuilder result = new StringBuilder();
		result.append(getAutoName());
		result.append("\n");
		result.append("$" + getBasePrice());
		for(i = 0; i < len; i++)
		{
			result.append(optionSetArray[i].printOptions());
		}
		
		System.out.print(result);
	}

	

}
