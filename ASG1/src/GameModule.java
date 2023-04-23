
public class GameModule {
	private Dealer dealer;
	private Player player;
	
	public GameModule() {
		dealer= new Dealer();
		player=new Player("IcePeak","password",100);
		
	}
	
	public void run() {
		System.out.println("high sum game!");
		dealer.shuffleCards();
		dealer.dealCardToPlayer(player);
		dealer.dealCardToPlayer(dealer);
		dealer.showCardsOnHand();
		player.showCardsOnHand();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameModule app= new GameModule();
		app.run();
	}

}