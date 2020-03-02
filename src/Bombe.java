public class Bombe
{
	/* 
	 * this class represents the test harness for the machine
	 * the class has 3 methods that test different settings of the enigma machine
	 */
	EnigmaFile printer = new EnigmaFile();
	
	/*
	 * this method is used for testing different plugs
	 * after a plug setting is tested and the output displayed, the plugboard is cleared and ready for another setting
	 */
	public void plugTester(EnigmaMachine myMachine)
	{
		//the enigma machine is set up using the start method
		myMachine.start();
		for(int i = 0; i <= 25; i ++)
		{
			myMachine.addPlug('D', (char)(i + 'A'));
			for(int j = 0; j <= 25; j++)
			{
				myMachine.addPlug('S', (char)(j + 'A'));
				//this method prints the encoded sentence
				printer.print(myMachine);
				
				//the plugboard has to be cleared after each try and the rotor positions reset
				myMachine.enigmaPlugboard.clear();
				myMachine.addPlug('D', (char)(i + 'A'));
				
				myMachine.rotors[0].setPosition(8);
				myMachine.rotors[1].setPosition(4);
				myMachine.rotors[2].setPosition(21);
			}
			myMachine.enigmaPlugboard.clear();
		}
	}
	
	/*
	 * this method is used for testing different rotor positions
	 */
	public void positionTester(EnigmaMachine myMachine) 
	{
		//the enigma machine is set up using the start method
		myMachine.start();
		for(int i = 0; i <= 25; i++)
		{
			myMachine.rotors[0].setPosition(i);
			for(int j = 0; j <= 25; j++)
			{
				myMachine.rotors[1].setPosition(j);
				for(int k = 0; k <= 25; k++)
				{
					myMachine.rotors[2].setPosition(k);
					//this method prints the encoded sentence
					printer.print(myMachine);
				}
			}
		}
	}
	
	/*
	 * this method is used for testing different rotor types
	 * each rotor has to be initialised again in order for it to change the type
	 * this means that many arrays are created, but they get deleted by the garbage collector
	 */
	public void rotorTester(EnigmaMachine myMachine)
	{
		//the enigma machine is set up using the start method
		myMachine.start();
		String[] romanNumerals = new String[] {"I", "II", "III", "IV", "V"};
		for(int i = 0; i <=4; i++)
		{
			myMachine.rotors[0].initialise(romanNumerals[i]);
			for(int j = 0; j <=4; j++)
			{
				myMachine.rotors[1].initialise(romanNumerals[j]);
				for(int k =0; k <= 4; k++)
				{
					myMachine.rotors[2].initialise(romanNumerals[k]);
					//this method prints the encoded sentence
					printer.print(myMachine);
					
					//the rotors' positions have to be reseted after each use 
					myMachine.rotors[0].setPosition(22);
					myMachine.rotors[1].setPosition(24);
					myMachine.rotors[2].setPosition(23);
				}
			}
		}
	}
}
