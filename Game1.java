package Player;

public class Game1 {

	
		 
		final int NO_PLAY=0;
		final int LADDER=1;
		final int SNAKE=2;
		final int WIN_POS = 100;
		public static int[] player2 = {0, 0}; // 0 index is count and 1st index is position
		public static int[] player1 = {0, 0};
		static int play = 1;

	        public void gameSim() {
			while(player1[1] != WIN_POS && player2[1] != WIN_POS) {
				if(play == 1){
					System.out.println("\nPlayer 1 will have a turn.");
					player1 = playTurn(player1, play);
					System.out.println("Position of Player 1 at the end of the turn is " + player1[1]);
				}else {
					System.out.println("\nPlayer 2 will have a turn.");
					player2 = playTurn(player2, play);
	                                System.out.println("Position of Player 2 at the end of the turn is " + player2[1]);
				}
			}

			if(player1[1] > player2[1]){
				System.out.println("Player 1 wins in " + player1[0] + " moves.");
			}else
				System.out.println("Player 2 wins in " + player2[0] + " moves.");
		}

		public int[] playTurn(int[] player, int play) {

			player[0]++;

			int dice = diceRoll();
			System.out.println("The Dice Rolled for " + dice);
			int opt = optionSelect();
			switch(opt) {
				case NO_PLAY:
					System.out.println("Option was for No Play");
					switchPlayer();
					System.out.println("Current position of player " + play + " is " + player[1]);
					return player;

				case LADDER:
					System.out.println("Option was for Ladder, player " + play + " will play again");
					player[1] += dice;
					if(player[1] > WIN_POS) {
						System.out.println("Move exceed game boundaries hence no movement");
						player[1] -= dice;
	                                }
					System.out.println("Current position of player " + play + " is " + player[1]);
					player = playTurn(player, play);
					break;

				case SNAKE:
					System.out.println("Option was for Snake");
					player[1] -= dice;
					if(player[1] < 0) {
						System.out.println("Move falls below game boundaries hence will move to start position.");
						player[1] = 0;
					}
					switchPlayer();
	                                System.out.println("Current position of player " + play + " is " + player[1]);
					return player;
			}
			return player;
		}

		public void switchPlayer() {
			if(play == 1) {
				play = 2;
			} else
				play = 1;
		}

		public int diceRoll() {
			return (int)(((Math.random() * 10) % 6) + 1);
		}

		public int optionSelect() {
	        	return (int) ((Math.random() * 10) % 3);
		}
		public static void main(String[] args) {
	Game1 obj = new Game1();
	obj.gameSim();
}
}
