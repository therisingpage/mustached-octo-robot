package model;

import java.io.Serializable;

/**
 * @author Lynn Kirabo
 * This is class called OptionSet.
 * It has an inner class called Option
 *
 */
@SuppressWarnings("serial")
public class OptionSet implements Serializable
{
	private String optionSetName;
	private Option [] optionsArray;
	//private int i = 0;
	int index1 = 0;
	
	protected OptionSet()
	{ }
	
	protected OptionSet(String n, int size)
	{
		this.setOptionSetName(n);
		this.setOptionSetSize(size);		
	}
	
	protected String getOptionSetName() 
	{
		return optionSetName;
	}
	
	protected Option [] getOptionsArray()
	{
		return optionsArray;
		
	}
	
	protected void setOptionsArray(String anName, float m) 
	{
		optionsArray[index1] = new Option();
		optionsArray[index1].setName(anName);
		optionsArray[index1].setPrice(m);
		index1++;	
	}
	
	protected void setOptionSetName(String opt_name) 
	{
		optionSetName = opt_name;
	}
	
	protected void setOptionSetSize(int size)
	{
		optionsArray = new Option[size];
	}
	
	protected Option[] findOptionSetWithName(String name)
	{
		return optionsArray;
	}
	
	protected Option findOption(String name)
	{
		Option xx = null;
		for (int z = 0; z < optionsArray.length; z++)
		{
			if(optionsArray[z].getName().equals(name))
			{
				xx = optionsArray[z];
				z = optionsArray.length - 1;
			}
		}
		return xx;	
	}

	
	protected void deleteAnOption(String OptionSetName)
	{
		for (int z = 0; z < optionsArray.length; z++)
		{
			String compareName = OptionSetName;
			String tempNameVar = optionsArray[z].getName();
			if(tempNameVar.contains(compareName))
			{
				optionsArray[z] = null;
				optionsArray[z] = optionsArray[optionsArray.length - 1];
				optionsArray[optionsArray.length - 1] = null;
			}
			
		}
	}

	protected String displayOptionsArray() 
	{
		int i;
		int len = optionsArray.length;
		StringBuilder result = new StringBuilder();
		result.append(getOptionSetName());
		result.append("\n");
		for(i = 0; i < len; i++)
		{
			result.append(optionsArray[i]);
			result.append("\n");
		}
		
		return result.toString();
	}

	protected String printOptions()
	{
		int i;
		int len = optionsArray.length;
		StringBuilder result = new StringBuilder();
		result.append("\n\n");
		result.append(getOptionSetName());
		for(i = 0; i < len; i++)
		{
			result.append("\n");
			result.append(optionsArray[i].printOption());
		}		
		return result.toString();
	}

	
	/*
	 * Inner Class: "Option"
	 * Option has a Name and a Price
	 */
	protected class Option implements Serializable
	{
		private String optionName;
		private float optionPrice;
		
		protected Option()
		{	}
		
		protected Option(String name, float price) 
		{
			optionName = name;
			optionPrice = price;
		}
		protected Option(String name) 
		{
			optionName = name;
		}
		 
		protected String getName() 
		{
			return optionName;
		}

		protected float getPrice() 
		{
			return optionPrice;
		}
		  
 		protected void setName(String name) 
		{
			optionName = name;
		}
		 
		protected void setPrice(float price) 
		{
			optionPrice = price;
		}
		
		protected String printOption()
		{
			StringBuilder printOption = new StringBuilder();
			printOption.append(getName());
			printOption.append(" ");
			printOption.append(getPrice());
			return printOption.toString();
		}
	
	}
}
