
public class Card {
	    private String suit;
	    private String name;
	    private int value;

	    public Card(String suit, String name, int value) {
	        this.suit = suit;
	        this.name = name;
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }

	    @Override
	    public String toString() {
	        return "<" + suit + " " + name + ">";
	    }

	    public static void main(String[] args) {
	        Card card = new Card("Heart", "Ace", 1);
	        System.out.println(card);
	    }
	}

