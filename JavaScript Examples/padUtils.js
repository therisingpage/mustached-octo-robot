function zeroPad(x,y)
{
	var len;
	var pad;
	len = x.length;
	var pad = "";


	while( len < y )
	{
		pad += "0";
		len++;
	}

return pad + x;
}