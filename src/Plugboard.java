import java.util.HashSet;
public class Plugboard 
{
	//this class represents the plugboard: the total collection of plugs
	//the plugs are all stored in a hashset
	HashSet<Plug> plugboard = new HashSet<Plug>(13);

	/*
	 * this method adds a plug to the plugboad
	 * in order for a plug to be added, we need to check if any of the characters are not
	 * already in use by using the 'clashesWith' method
	 */
	public void addPlug(char end1, char end2)
	{
		Plug p = new Plug(end1,end2);
		boolean ok = true;
		
		for(Plug n : plugboard)
		{
			if(n.clashesWith(p) == true)
			{
				ok = false;
			}
		}
		if(ok == true)
		{	
			plugboard.add(p);
		}
	}

	private int getNumPlugs()
	{
		return plugboard.size();
	}

	public void clear()
	{
		plugboard.clear();
	}

	/*
	 * this method checks all the plugs to see if the character it is gives is present in one of them
	 * if the answer is yes, the method substitutes the character through the corresponding plug
	 */
	public char substitute(char LetterPressed)
	{
		for(Plug n : plugboard)
		{
			LetterPressed = n.encode(LetterPressed);
		}
		return LetterPressed;
	}
}