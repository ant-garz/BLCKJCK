/**
 * This is the Person.java file for my BLCKJCK implementation. This Person class is used to create Person Objects of Dealer and Player in GameFrame.
 */

public class Person {
    private int score;

    Person(){
        super();
    }

    //non-default constructor for the Person class. Takes in int for the Persons score
    Person(int scoreIn){
        score = scoreIn;
    }

    //setter for score. used a lot in GameFrame
    public final void setScore(int scoreIn) {
        score = scoreIn;
    }

    //getter for score. used a lot in GameFrame
    public int getScore() {
        return score;
    }
}