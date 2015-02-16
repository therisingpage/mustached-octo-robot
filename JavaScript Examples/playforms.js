var userInput;
userInput = prompt("Enter a number");

var dev;
var rem;

while( userInput != null ){
dev = Math.floor(userInput / 16);
rem = userInput % 16;

while ( rem > 16 )
{
	var otherrem;
	otherrem = rem / 16;
	
}

if ((0 <= rem ) && (rem < 10))
{
	rem = rem;
}
if ( rem == 10)
{
	rem = "A";
}
if ( rem == 11)
{
	rem = "B";
}
if ( rem == 12)
{
	rem = "C";
}
if ( rem == 13)
{
	rem = "D";
}
if ( rem == 14)
{
	rem = "E";
}
if ( rem == 15)
{
	rem = "F";
}

if (dev == 0)
{
	document.write( rem + " hex value.<br>");
}
else
{
	document.write(dev +""+ rem + " hex value.<br>");
}


userInput = prompt("Enter another number");
}