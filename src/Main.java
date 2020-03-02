public class Main
{
	/*
	 * the Main class serves as a 'command center' 
	 * for the enigma machine
	 * here the user can pick which tests to run
	 * Instructions are detailed in the 'enigma.txt' file
	 */
	public static void main(String[] args)
	{
		EnigmaFile printer = new EnigmaFile();
		EnigmaMachine machine = new EnigmaMachine();
		Bombe bombeMachine = new Bombe();
		
		machine.start();
		printer.print(machine);
		//bombeMachine.plugTester(machine);
		//bombeMachine.positionTester(machine);
		//bombeMachine.rotorTester(machine);
	}
}
