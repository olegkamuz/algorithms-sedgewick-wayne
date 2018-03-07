import java.util.Iterator;

public class MixedDeck extends RandomBag<Card> {
    private RandomBag<Card> mixedDeck = RandomBag.RandomBag();
    public static MixedDeck MixedDeck(){
        return new MixedDeck();
    }
    public MixedDeck() {
        makeDeck();
    }
    private void makeDeck(){
        String str = " 2 of spades, 3 of spades, 4 of spades, 5 of spades, 6 of spades, 7 of spades, 8 of spades, 9 of spades, 10 of spades, Jack of spades, Queen of spades, King of spades, Ace of spades, 2 of hearts, 3 of hearts, 4 of hearts, 5 of hearts, 6 of hearts, 7 of hearts, 8 of hearts, 9 of hearts, 10 of hearts, Jack of hearts, Queen of hearts, King of hearts, Ace of hearts, 2 of diamonds, 3 of diamonds, 4 of diamonds, 5 of diamonds, 6 of diamonds, 7 of diamonds, 8 of diamonds, 9 of diamonds, 10 of diamonds, Jack of diamonds, Queen of diamonds, King of diamonds, Ace of diamonds, 2 of clubs, 3 of clubs, 4 of clubs, 5 of clubs, 6 of clubs, 7 of clubs, 8 of clubs, 9 of clubs, 10 of clubs, Jack of clubs, Queen of clubs, King of clubs, Ace of clubs";
        String[] deck = str.split(",");
        for (int i = 0; i < deck.length; i++) {
            mixedDeck.add(new Card(deck[i]));
        }
    }
    public Card getCard() {
        Iterator<Card> iterator = mixedDeck.iterator();
        if(iterator.hasNext()) return iterator.next();
        else return null;
    }
}
