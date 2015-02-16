function convertDecToBin(x)
{
	var dec = x;
	var bin = "";
	
	while(dec >= 2)
	{
		bin = (dec % 2) + bin;
		dec = parseInt(dec/2);
	}
	
	bin = dec + bin;

return bin;
}

function convertDecToHexDigit(x)
{
	x = parseInt(x);

	if ((0 <= x ) && (x < 10))
	{
		return x;
	}
	if ( x == 10)
	{
		return "A";
	}
	if ( x == 11)
	{
		return "B";
	}
	if ( x == 12)
	{
		return "C";
	}
	if ( x == 13)
	{
		return "D";
	}
	if ( x == 14)
	{
		return "E";
	}
	if ( x == 15)
	{
		return "F";
	}

return 
}

function convert4BinToDec(x)
{
	var paddedNum = zeroPad(x, 4);
	var regex = /^[01]{4}$/;
	var answer = 0;

	if(!regex.test(paddedNum))
	{
		return "Invalid";
	}
	else
	{	
		if(paddedNum[0] == 1)
		{
			answer += 8;
		}
		if(paddedNum[1] == 1)
		{
			answer += 4;
		}
		if(paddedNum[2] == 1)
		{
			answer += 2;
		}
		if(paddedNum[3] == 1)
		{
			answer += 1;
		}
	}

return answer;
}

function convertBinToHex(x)
{
	var binToHex = "";
	var rest = x;
	
	while (rest !="")
	{
		var lastFour = rest.substr(-4);
		var binToDec = convert4BinToDec(lastFour);
		binToHex = convertDecToHexDigit(binToDec) + binToHex; // += will put it in front of the string and give you the reverse
		var rest = rest.substring(0, rest.length-4);
	}

return binToHex;
}