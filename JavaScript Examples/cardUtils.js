
function getFullName(x)
{
	var fName;
	fName = getRank(x) + " of " + getSuite(x);
	fName = fName.toUpperCase();
	
return fName;
}

function getRank(x)
{	
	var rank;
	var lowerRank;
	rank = x[0];
	lowerRank = rank.toLowerCase();
	
	if ( ( 2 <= lowerRank ) && ( lowerRank <= 9 ) )
	{
		return lowerRank;
	}
	if (x.substring(0 , 2) == 10)
	{
		return x.substring(0 , 2);
	}
	if ( lowerRank == "a" )
	{
		return "Ace";
	}
	if ( lowerRank == "j" )
	{
		return "Jack";
	}
	if ( lowerRank == "q" )
	{
		return "Queen";
	}
	if ( lowerRank == "k" )
	{
		return "Kings";
	}
	else 
	{
		return "invalid Rank";
	}
	
return
	
}

function getSuite(x)
{
	var suite;
	suite = x[1];
	suite = suite.toLowerCase();
	
	switch ( suite, x.substring(2,3) ) 
	{
		case "s":
			return "spades";
		
		case "d":
			return "diamonds";
			
		case "h":
			return "hearts";
			
		case "c":
			return "clubs";
			
		default:
			return "Invalid Suite";
	} 
	
return
	
}