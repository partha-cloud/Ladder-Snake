package Player;

public class Game1 {

	
		 
		final int NO_PLAY=0;
		final int LADDER=1;
		final int SNAKE=2;
		final int WIN_POS = 100;
		 public void gameSim() {
		
			 int currPos = 0, count = 0;

             while(currPos != WIN_POS) {
                     int diceRoll = diceRoll();
                     //Option Check
                     currPos = optionSelect(currPos, diceRoll);

                     System.out.println("The current Position of the player is: " + currPos);
			count++;
             }
		System.out.println("Total times dice played - " + count);

     }


	public int diceRoll() {

	        //Dice Roll
		int dice = 1 + (int)( (Math.random() * 10) % 6);
		System.out.println("The Dice Rolled: " + dice);
		return dice;

	}

	public int optionSelect(int currPos, int diceRoll) {
		//Option Selection No Play/Snake/Ladder
		int option = (int)( (Math.random() * 10) % 3 );
		switch(option) {
			case NO_PLAY:
				System.out.println("The option was to no play, hence the player will not advance.");
                             break;

                     case LADDER:
                             currPos += diceRoll;
				if(currPos > WIN_POS) {
					System.out.println("Since the current dice roll for Ladder will take the player out of " + WIN_POS + " bound, hence the player will not move forward.");
					currPos -=diceRoll;
				}else
					System.out.println("The option came to Ladder, the player will move forward: " + diceRoll + " steps.");
                             return currPos;

			case SNAKE:
                             currPos -= diceRoll;
                     	if(currPos<0) { //If current position goes below 0, reset
					System.out.println("Since the current dice roll for snake will take player below 0, the player will move to start position.");
                             	currPos = 0;
				}else
					System.out.println("The option came to Snake, the player will move backward: " + diceRoll + " steps.");
                             return currPos;

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
