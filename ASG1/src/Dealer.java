
import java.util.*;
public class Dealer extends Player{
    private Deck deck;
    public Dealer() {
        super("Dealer","",0);
        deck=new Deck();

    }
    public void shuffleCards() {
        System.out.println("Dealer shuffle card");
        deck.shuffle();
    }
    public void dealCardToPlayer(Player player) {
        Card card =deck.dealCard();
        player.addCard(card);

    }
    
    
}