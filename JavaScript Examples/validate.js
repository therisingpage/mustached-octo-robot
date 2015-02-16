function isValidEmail(x)
{
	var regEx;
	regEx = /^[a-zA-Z0-9][a-zA-Z0-9_.-]*@[a-zA-Z0-9-]+\.[a-zA-Z0-9]+$/;
	
	if(regEx.test(x))
	{
		return true;
	}
	else
	{
		return false;
	}
}