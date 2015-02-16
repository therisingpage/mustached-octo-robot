function trimSpace(x)
{	
	x.value = x.value.trim();

}

function allCaps(x)
{
	x.value = x.value.toUpperCase();
}

function inputToDate(x)
{
	var convertedToDate;
	convertedToDate = new Date(x);
	
return convertedToDate;
}

function getTheYear(x){
	var theYear;
	theYear = x.getFullYear();

return theYear;
}

function ageCalculations(x)
{
	var today = new Date();
	var ageStep1 = x.value;
	var ageStep2 = inputToDate(ageStep1);
	var ageStep3 = getTheYear(ageStep2);
	var ageStep4 = getTheYear(today);
	var theAge = ageStep4 - ageStep3;
	
	if ( theAge < 0 )
	{
		return "n/a"
	}

return theAge;
}






