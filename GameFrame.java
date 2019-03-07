import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.BorderLayout;

public class GameFrame extends JFrame implements ActionListener {
    private JButton hit = new JButton("Hit Me");
    private Person dealer;
    private Person player;
    private int dealerDisplayScore;
    private int playerDisplayScore;

    GameFrame() {
        setTitle("BLCKJCK");
        setBounds(200,200,450,375);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create container to hold all content of the game GUI
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //create button panel add it to bottom of content pane (south)
        JPanel btnPanel = new JPanel();
        btnPanel.add(hit);
        contentPane.add(btnPanel, BorderLayout.SOUTH);

        //add actionListener to hit me button
        hit.addActionListener(this);
        //initialize dealer + player and give them scores of 0 to start
        dealer = new Person(0);
        player = new Person(0);

        //Start the Game up
        CardDeck myCardDeck = new CardDeck();
        Cards newCard1 = myCardDeck.dealCard();
        Cards newCard2 = myCardDeck.dealCard();

        dealer.setScore(newCard1.getCardValue());
        player.setScore(newCard2.getCardValue());
        dealerDisplayScore = scoreChecker(dealer.getScore());
        playerDisplayScore = scoreChecker(player.getScore());

        //formatting for the GUI
        JPanel dealerPanel = new JPanel();
        dealerPanel.setLayout(new BorderLayout());
        JLabel dealerHeader = new JLabel("Dealer Score:");
        JLabel dealerScore = new JLabel(String.valueOf(dealerDisplayScore));
        dealerPanel.add(dealerHeader, BorderLayout.NORTH);
        dealerPanel.add(dealerScore, BorderLayout.CENTER);
        contentPane.add(dealerPanel, BorderLayout.WEST);

        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new BorderLayout());
        JLabel playerHeader = new JLabel("Player Score:");
        JLabel playerScore = new JLabel(String.valueOf(playerDisplayScore));
        playerPanel.add(playerHeader, BorderLayout.NORTH);
        playerPanel.add(playerScore, BorderLayout.CENTER);
        contentPane.add(playerPanel, BorderLayout.EAST);

        JPanel gameStatusPanel = new JPanel();
        gameStatusPanel.setLayout(new BorderLayout());
        JLabel dealerStatus = new JLabel("Dealer drew " + newCard1.toString());
        JLabel playerStatus  = new JLabel("Player drew " + newCard2.toString());
        gameStatusPanel.add(dealerStatus, BorderLayout.CENTER);
        gameStatusPanel.add(playerStatus, BorderLayout.SOUTH);

        contentPane.add(gameStatusPanel, BorderLayout.CENTER);
    }

    //method to check if the user got a face card then set the numeric value for the face value to 10 so Jack wont be 11 pts etc.
    public int scoreChecker(int scoreIn) {
        int checkedScore = scoreIn;
        if(scoreIn > 10) {
            return 10;
        }
        else {
            return checkedScore;
        }
    }

    public void actionPerformed(ActionEvent event) { 
        if (event.getSource() == hit) {
            System.out.println("Card Dealt");
        }
    }
}