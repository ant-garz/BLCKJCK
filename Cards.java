/**
 * this is the Cards.java file for my BLCKJCK implementation. Used by CardDeck to create a deck of Card Objects for use in GameFrame.
 */

public class Cards {

    // nuemric values for the 4 suits. Will use later to determine what card is drawn.
    public final static int club = 0;
    public final static int diamond = 1;
    public final static int heart = 2;
    public final static int spade = 3;  
 
    //face cards as numbers so that we can differentiate when drawn
    public final static int ace = 1;
    public final static int jack = 11; 
    public final static int queen = 12;    
    public final static int king = 13;
                
    //card properties needed for creating card object
    private final int cardSuit;           
    private int cardValue;
              
    //non-default constructor for a card, must know it's value from 1-10 (aces will count as 1 no matter what) and what suit it is.
    public Cards(int cardValueIn, int cardSuitIn) {
        cardValue = cardValueIn;
        cardSuit = cardSuitIn;
    }

    //getter for cards value 1-13 (11-13 get trimmed to 10 in GameFrame)
    public int getCardValue() {
        // Return the cards numeric value
        return cardValue;
    }
        
    //getter for cards suit
    public int getCardSuit() {
        //Return the int that codes for this card's suit.
        return cardSuit;
    }
    
    //checks what the card suit is numerically and returns it's string equivalent to be printed to GUI.
    public String getCardSuitString() {
        if (cardSuit == 0){
            return "Clubs";
        }
        else if(cardSuit == 1){
            return "Diamonds";
        }
        else if(cardSuit == 2){
            return "Hearts";
        }
        else if(cardSuit == 3){
            return "Spades";
        }
        else {
            return "Error";
        }
    }
    
    //checks what the card value is numerically and returns it's string equivalent to be printed to GUI.
    public String getCardValueString() {
        if (cardValue == 1){
            return "Ace";
        }
        else if(cardValue == 2){
            return "2";
        }
        else if(cardValue == 3){
            return "3";
        }
        else if(cardValue == 4){
            return "4";
        }
        else if(cardValue == 5){
            return "5";
        }
        else if(cardValue == 6){
            return "6";
        }
        else if(cardValue == 7){
            return "7";
        }
        else if(cardValue == 8){
            return "8";
        }
        else if(cardValue == 9){
            return "9";
        }
        else if(cardValue == 10){
            return "10";
        }
        else if(cardValue == 11){
            return "Jack";
        }
        else if(cardValue == 12){
            return "Queen";
        }
        else if(cardValue == 13){
            return "King";
        }
        else {
            return "Error";
        }
    }
    
    public String toString() {
        //print out what was drawn into the GUI.
        return getCardValueString() + " of " + getCardSuitString();
    }
}