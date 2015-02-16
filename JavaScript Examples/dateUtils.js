function isWeekend(a)
{

	var actualDay;
	actualDay = a.getDay();

	if (actualDay == 6 || actualDay == 0)
	{
		return true;
	}
	else
	{
		return false;
	}

return
}

function isWeekday(a)
{

	var actualDay;
	actualDay = a.getDay();

	if (0 < actualDay && actualDay < 6)
	{
		return true;
	}
	else
	{
		return false;
	}

return
}

function isToday( x, y )
{
	var a;
	var b;
	
	a = x.toDateString();
	b = y.toDateString();
	
	if ( a == b )
	{
		return "It's Today!";
	}
	if (x < y)
	{
		return "Your date is not today - It is in the future."
	}
	if (y < x)
	{
		return "Your date is not today - It is in the past"
	}
	
return
}
