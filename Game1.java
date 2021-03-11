package Player;

public class Game1 {

	public static void main(String[] args) {
		int diceroll=1+(int)((Math.random() *10) %6);
		System.out.println("dice roll: "+ diceroll);
	}

}
