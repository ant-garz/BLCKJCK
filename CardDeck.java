import java.util.Random;

public class CardDeck {
    private Cards[] cardDeck;
    private int dealtCards;

    public CardDeck() {
        //create a deck of cards via array of card objects 
        cardDeck = new Cards[52];

        int counter = 0;

        //populate the cardDeck with all cards
        //assigns suit to cards being created
        for (int cardSuit = 0; cardSuit < 4; cardSuit++) {
            //assigns value of card being created
            for (int cardValue = 0; cardValue < 14; cardValue++) {
                cardDeck[counter] = new Cards(cardValue, cardSuit);
                counter++;
            }
        }
        //aka starting off with a full deck of cards
        dealtCards = 0;
   }

   //method to shuffle up the deck. number integer must always be 52, but that is placed in elsewhere.
   public void shuffleDeck() {
       Random randomizer = new Random();
        for (int i = 0; i < cardDeck.length; i++) {
            int randNum = randomizer.nextInt(52 + 1);
            Cards placeHolder = cardDeck[i];
            cardDeck[i] = cardDeck[randNum];
            cardDeck[randNum] = placeHolder;
        }
   }

   //method to deal cards from the deck
   public Cards dealCard() {

        //checks to see if the deck is completely used up. 
        if (dealtCards == 52) {
            shuffleDeck();
        }
        //add to dealtCards to make sure that keeping track of remaining cards
        dealtCards++;
        //return the dealt card
        return cardDeck[dealtCards - 1];
   }

    //method to check how many cards are left
    public int remainingCards() {
        return 52 - dealtCards;
    }
}