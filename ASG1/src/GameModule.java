import java.text.BreakIterator;
import java.util.*;
public class GameModule {
	private Dealer dealer;
	private Player player;
	private int pot = 0;
	
	public GameModule() {
		dealer= new Dealer();
		player=new Player("IcePeak","password",100);
		
	}


	public void comparison(int roundnumber, int indicator){
		// int playerCard = this.player.cardsOnHand.get(roundnumber).nameValue;
		// int dealerCard = this.dealer.cardsOnHand.get(roundnumber).nameValue;
		int playerCard = 0;
		int dealerCard = 0;
		if (indicator == 1){
			playerCard = this.player.cardsOnHand.get(roundnumber).nameValue;
			dealerCard = this.dealer.cardsOnHand.get(roundnumber).nameValue;
		}else{
			playerCard = this.player.cardsOnHand.get(roundnumber).suitValue;
			dealerCard = this.dealer.cardsOnHand.get(roundnumber).suitValue;
		}
		Scanner s = new Scanner(System.in);
		if (playerCard > dealerCard){
			if (roundnumber == 1 ){
				System.out.println("Player call. State bet:");
			int betAmount = s.nextInt();
			int playerTotalChips = player.getChips();
			int dealerTotalChips = dealer.getChips();
			player.chips = playerTotalChips - betAmount;
			dealer.chips = dealerTotalChips - betAmount;
			System.out.println(player.getLoginName() + ", You are left with " + player.chips + " chips");
			pot = pot + betAmount * 2;
			System.out.println("bet on table:"+ pot);
			}
			else{
				
				System.out.println("Do you want to bet or quit? [B/Q]");
				String answer = s.next().toUpperCase();
				if(answer.equalsIgnoreCase("B")){
					System.out.println("Player call. State bet:");
					int betAmount = s.nextInt();
					int playerTotalChips = player.getChips();
					int dealerTotalChips = dealer.getChips();
					player.chips = playerTotalChips - betAmount;
					dealer.chips = dealerTotalChips - betAmount;
					System.out.println(player.getLoginName() + ", You are left with " + player.chips + " chips");
					pot = pot + betAmount * 2;
					System.out.println("bet on table:" + pot);
				
				}else if (playerCard == dealerCard){
					comparison(roundnumber, 2);
				}else if (answer.equalsIgnoreCase("Q")){
					gameend();
				}
			}
		}
		else if(dealerCard>playerCard){
			// System.out.println("Dealer calls.");
			// int betAmount = 20;
			// int playerTotalChips = player.getChips();
			// int dealerTotalChips = dealer.getChips();
			// player.chips = playerTotalChips - betAmount;
			// dealer.chips = dealerTotalChips - betAmount;
			// pot = pot + betAmount * 2;
			// System.out.println("dealer bet 20 chips. Dealer has "+ dealer.chips + " chips");
			// System.out.println("bet on table:"+ pot);
			if(roundnumber == 1){
				System.out.println("Dealer calls.");
				int betAmount = 20;
				int playerTotalChips = player.getChips();
				int dealerTotalChips = dealer.getChips();
				player.chips = playerTotalChips - betAmount;
				dealer.chips = dealerTotalChips - betAmount;
				pot = pot + betAmount * 2;
				System.out.println("dealer bet 20 chips. Dealer has " + dealer.chips + " chips");
				System.out.println("bet on table:" + pot);
			}
			else{
				System.out.println("Dealer calls.");
				int betAmount = 20;
				int playerTotalChips = player.getChips();
				int dealerTotalChips = dealer.getChips();
				dealer.chips = dealerTotalChips - betAmount;
				System.out.println("dealer bet 20 chips. Dealer has " + dealer.chips + " chips");
				System.out.println("Do you want to follow? [Y/N]");
				String answer = s.next();
				if (answer.equalsIgnoreCase("Y")) {
					player.chips = playerTotalChips - betAmount;
					pot = pot + betAmount * 2;
					System.out.println(player.getLoginName() + ", You are left with " + player.chips + " chips");
					System.out.println("bet on table:" + pot);

				} 
				else if (answer.equalsIgnoreCase("N")){
					gameend();
				}
			}
		}
		else if (playerCard == dealerCard) {
			comparison(roundnumber, 2);
		}
	}
	
	public void run() {
		System.out.println("high sum game!");
		dealer.shuffleCards();
		dealer.dealCardToPlayer(player);
		dealer.dealCardToPlayer(dealer);
		dealer.dealCardToPlayer(player);
		dealer.dealCardToPlayer(dealer);
		dealer.showCardsOnHand(dealer.cardsOnHand, false);
		player.showCardsOnHand();
		comparison(1,1);
		System.out.println("Dealer dealing cards for round 2");
		dealer.dealCardToPlayer(player);
		dealer.dealCardToPlayer(dealer);
		dealer.showCardsOnHand(dealer.cardsOnHand, false);
		player.showCardsOnHand();
		comparison(2,1);
		System.out.println("dealer dealing cards for round 3");
		dealer.dealCardToPlayer(player);
		dealer.dealCardToPlayer(dealer);
		dealer.showCardsOnHand(dealer.cardsOnHand, false);
		player.showCardsOnHand();
		comparison(3,1);
		System.out.println("dealer dealing cards for round 4");
		dealer.dealCardToPlayer(player);
		dealer.dealCardToPlayer(dealer);
		dealer.showCardsOnHand(dealer.cardsOnHand, false);
		player.showCardsOnHand();
		comparison(4,1);
		gameend();


	}
	public void gameend(){
		dealer.showCardsOnHand(dealer.cardsOnHand, true);
		player.showCardsOnHand();
		int playertotal = player.getTotalCardValue();
		int dealertotal = dealer.getTotalCardValue();
		if(playertotal > dealertotal){
			System.out.println(player.getLoginName()+"wins");
			int playerfinalchips = pot + player.chips;
			System.out.println("you now have " + playerfinalchips + " chips.");
		}
		else if(dealertotal > playertotal){
			System.out.println(dealer.getLoginName() + "wins");
			int dealerfinalchips = pot + dealer.chips;
			System.out.println("dealer now have " + dealerfinalchips + " chips.");
		}
		else if(playertotal == dealertotal){
			System.out.println("it's a draw. The program eats all your chips. You get nothing.");
		}
		newgame();
	}
	public void newgame(){
		Scanner s = new Scanner(System.in);
		System.out.println("new game?(Y/N)");
		String ans = s.next();
		if (ans.equalsIgnoreCase("Y")) {
			GameModule app = new GameModule();
			app.run();
		} else if (ans.equalsIgnoreCase("N")) {
			System.out.println("goodbye");
		} else {
			System.out.println("please provide a valid answer.");
				newgame();
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameModule app= new GameModule();
		app.run();
	}

}