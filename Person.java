public class Person {
    private int score;

    Person(){
        super();
    }
    Person(int scoreIn){
        score = scoreIn;
    }

    public final void setScore(int scoreIn) {
        score = scoreIn;
    }

    public int getScore() {
        return score;
    }
}