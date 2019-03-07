/**
 * @author Anthony Garza
 * this is the BLCKJCK file for my BLCKJCK final project implementation. This is where main is and what should be run.
 * To utilize my BLCKJCK game you must first compile all java files with javac *.java then use java BLCKJCK to call this file and begin the game.
 */

public class BLCKJCK {

    public static void main(String[] args) {
        System.out.println("BLCKJCK starting...");

        GameFrame myGameFrame = new GameFrame();
        myGameFrame.setVisible(true);
    }
}