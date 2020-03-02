public class Plug 
{
	//this class represents a plug. A plug connects to characters with eachother and interchanges them if needed
	private char end1, end2;
	
	public Plug(char end1ToSet, char end2ToSet)
	{
		end1 = end1ToSet;
		end2 = end2ToSet;
	}
	
	public char getEnd1()
	{
		return end1;
	}
	
	public char getEnd2()
	{
		return end2;
	}
	
	private void setEnd1(char newValue)
	{
		end1 = newValue;
	}
	
	private void setEnd2(char newValue)
	{
		end2 = newValue;
	}
	
	//this method changes a character to the one at the other end of the plug, if there is a plug connecting the 2 characters
	public char encode(char letterIn)
	{
		if(letterIn != end1 && letterIn != end2)
		{
			return letterIn;
		}
		if(letterIn == end1)
		{
			return end2;
		}
		return end1;
	}
	 
	//this method is used for checking if a character is not already being used by another plug
	public boolean clashesWith(Plug plugin)
	{
		if(plugin.end1 == this.end1 || plugin.end2 == this.end2 || plugin.end2 == this.end1 || plugin.end1 == this.end2)
		{ 
			return true;
		}
		return false;
	 }
}
