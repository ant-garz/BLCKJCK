/**
 * this is the CardDeck.java file for my BLCKJCK implementation. Used to create a deck of cards using an array of Cards objects from Cards.java
 */

import java.lang.Math;

public class CardDeck {
    private Cards[] cardDeck;
    private int dealtCards;

    public CardDeck() {
        //create a deck of cards via array of card objects 
        cardDeck = new Cards[52];

        int counter = 0;

        //populate the cardDeck with all cards
        //assigns suit to cards being created
        for (int cardSuit = 0; cardSuit <= 3; cardSuit++) {
            //assigns value of card being created
            for (int cardValue = 1; cardValue <= 13; cardValue++) {
                cardDeck[counter] = new Cards(cardValue, cardSuit);
                counter++;
            }
        }
        //aka starting off with a full deck of cards
        dealtCards = 0;
        //shuffle deck so every 1st draw wont be an ace of clubs
        shuffleDeck();
   }

   //method to shuffle up the deck. tried to use java.util.Random but kept messing up arrayIndex.
   public void shuffleDeck() {
        for (int card = 51; card > 0; card--) {
            //creates a random number out of 52 for us
            int randNum = (int)(Math.random()*(card+1));
            Cards placeHolder = cardDeck[card];
            cardDeck[card] = cardDeck[randNum];
            cardDeck[randNum] = placeHolder;
        }
        dealtCards = 0;
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

    //method to check how many cards are left. used in GUI at bottom to keep track visually.
    public int remainingCards() {
        return 52 - dealtCards;
    }
}