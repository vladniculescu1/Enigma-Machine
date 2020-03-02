public class TurnoverRotor extends BasicRotor 
{
	/*
	 * this class represents the turnover rotor
	 * the turnover rotor is a basic rotor that can rotate the rotor to it's right(next in array)
	 */
	private int turnoverPosition;
	private TurnoverRotor nextRotor;
	
	//as well initialising the mapping of the rotor, we also need to initialise its turnover position
	public TurnoverRotor(String nameToSet)
	{
		super(nameToSet);
		initialize(nameToSet);
	}
	
	public void initialize(String name)
	{
		if(name.equals("I"))
		{
			 turnoverPosition = 24;
		}
		else if(name.equals("II"))
		{
			turnoverPosition = 12;
		}
		else if(name.equals("III"))
		{
			turnoverPosition = 3;
		}
		else if(name.equals("IV"))
		{
			turnoverPosition = 17;
		}
		else
		{
			turnoverPosition = 7;
		}
	}
	
	public void setNextRotor(TurnoverRotor nextRotorToSet)
	{
		nextRotor = nextRotorToSet;
	}
	
	/*
	 * this method rotates the current rotor
	 * if the rotor is at its turnover  position, the rotor to its right is also rotated
	 */
	public void rotate()
	{
		super.rotate();
		if(nextRotor != null)
		{
			if(position == turnoverPosition)
			{
				nextRotor.rotate();
			}
		}
	}
}
