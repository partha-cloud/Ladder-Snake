package Player;

public class Game1 {

	
		 
		final int NO_PLAY=0;
		final int LADDER=1;
		final int SNAKE=2;
		final int WIN_POS = 100;
		 public void gameSim() {
		
		int diceRoll = 1 + (int)( (Math.random() * 10) % 6);
		System.out.println("The Dice Rolled to: " + diceRoll);
		
		 int currPos=0;
         while(currPos <= WIN_POS) {
                 int diceRoll1=diceRoll();
                 //Option Check
                 currPos = optionSelect(currPos, diceRoll1);

                 if(currPos<0) //If current position goes below 0, reset
                         currPos = 0;

                 System.out.println("The current Position of the player is: " + currPos);
         }

 }


public int diceRoll() {

     //Dice Roll
	int dice=1 + (int)( (Math.random() * 10) % 6);
	System.out.println("The Dice Rolled: " + dice);
	return dice;

}

public int optionSelect(int currPos, int diceRoll) {
	//Option Selection No Play/Snake/Ladder
	int option=(int)( (Math.random() * 10) % 3 );
	switch(option) {
	
		case NO_PLAY:
			System.out.println("The option was to no play, hence the player will not advance");
                         break;
                 case LADDER:
                         System.out.println("The option came to Ladder, the player move forward: " + diceRoll + " steps");
                         currPos += diceRoll;
                         return currPos;
			//break;
		case SNAKE:
                         System.out.println("The option came to Snake, the player will backward: " + diceRoll + " steps");
                         currPos -= diceRoll;
                         return currPos;
		        //break;
                 default:
                         System.out.println("Some error occured, default case");
                         break;

                 }
	return currPos;
}

public static void main(String[] args) {

	Game1 obj = new Game1();
	obj.gameSim();
}
}
