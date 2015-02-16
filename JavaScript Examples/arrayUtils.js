function sortArray(x)
{
	/* 
	var sorted;
	sorted = x.sort();
	*/
	
	var switched;
	var len;
	var i;
	
	switched = true;
	len = x.length;

	while (switched)
	{
		switched = false;
		
		for ( i = 0; i < len - 1; i++ ) //use length to keep the outer loop running
		{
			var temp = x[i];
			var compare = x[i + 1];
			
			if ( temp > compare )
			{
				x[i] = x[i + 1];
				x[i + 1] = temp;
				switched = true;
			}
		}
	}


}

function printArray(x)
{
	var y;
	var pCounter;
	var number = 1;
	var len = x.length;
	var result = "";

	for ( pCounter = 0; pCounter < len; pCounter++ )
	{
		y = x[pCounter];
		result += number + ". " + y + "<br>"; 
		number++;
	}
	
return result;
}

function searchArray(s, a)
{

	var sCounter;
	var len = a.length;
	var found = "";
	
	for ( sCounter = 0; sCounter < len; sCounter++ )
	{
		if ( s == a[sCounter] ) 
			found = a[sCounter] + " has been found in slot: " + sCounter + ".";
	}
	
	if ( found == "" )
	{
		found = "Name not found.";
	}
	
return found;
}
