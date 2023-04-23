
public class Card {
	    private String suit;
		public int suitValue;
		private String name;
		public int nameValue;
	    public int value;

	    public Card(String suit, int suitValue, String name, int nameValue, int value) {
	        this.suit = suit;
			this.suitValue = suitValue;
			this.name = name;
			this.nameValue = nameValue;
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }

	    @Override
	    public String toString() {
	        return "<" + suit + " " + name + ">";
	    }

	    // public static void main(String[] args) {
	    //     // Card card = new Card("Heart", "Ace", 1);
	    //     // System.out.println(card);
	    // }
	}

