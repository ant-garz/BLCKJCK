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
    private JButton hit;
    private JButton stand;
    private Person dealer;
    private Person player;
    private int dealerDisplayScore;
    private int playerDisplayScore;
    private CardDeck myCardDeck;
    private Cards dealerCard;
    private Cards playerCard;
    private JLabel dealerScore;
    private JLabel playerScore;
    private JLabel dealerStatus;
    private JLabel playerStatus;
    private JLabel cardsLeft;

    GameFrame() {
        setTitle("BLCKJCK");
        setBounds(200,200,450,375);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create container to hold all content of the game GUI
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //initialize dealer + player and give them scores of 0 to start since it needs a parameter in.
        dealer = new Person(0);
        player = new Person(0);

        //Start the Game up
        myCardDeck = new CardDeck();
        dealerCard = myCardDeck.dealCard();
        playerCard = myCardDeck.dealCard();

        dealer.setScore(cardValueChecker(dealerCard.getCardValue()));
        player.setScore(cardValueChecker(playerCard.getCardValue()));
        dealerDisplayScore = dealer.getScore();
        playerDisplayScore = player.getScore();

        //formatting for the GUI
        JPanel dealerPanel = new JPanel();
        dealerPanel.setLayout(new BorderLayout());
        JLabel dealerHeader = new JLabel("Dealer Score:");
        dealerScore = new JLabel(String.valueOf(dealerDisplayScore));
        dealerPanel.add(dealerHeader, BorderLayout.NORTH);
        dealerPanel.add(dealerScore, BorderLayout.CENTER);
        contentPane.add(dealerPanel, BorderLayout.WEST);

        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new BorderLayout());
        JLabel playerHeader = new JLabel("Player Score:");
        playerScore = new JLabel(String.valueOf(playerDisplayScore));
        playerPanel.add(playerHeader, BorderLayout.NORTH);
        playerPanel.add(playerScore, BorderLayout.CENTER);
        contentPane.add(playerPanel, BorderLayout.EAST);

        JPanel gameStatusPanel = new JPanel();
        gameStatusPanel.setLayout(new BorderLayout());
        dealerStatus = new JLabel("Dealer drew " + dealerCard.toString());
        playerStatus  = new JLabel("Player drew " + playerCard.toString());
        gameStatusPanel.add(dealerStatus, BorderLayout.CENTER);
        gameStatusPanel.add(playerStatus, BorderLayout.SOUTH);

        contentPane.add(gameStatusPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        hit = new JButton("Hit Me");
        stand = new JButton("Stand");
        //add actionListener to hit me and stand button
        hit.addActionListener(this);
        stand.addActionListener(this);
        cardsLeft = new JLabel("Cards Remaining: " + myCardDeck.remainingCards());
        bottomPanel.add(hit, BorderLayout.WEST);
        bottomPanel.add(stand, BorderLayout.CENTER);
        bottomPanel.add(cardsLeft, BorderLayout.EAST);
        contentPane.add(bottomPanel, BorderLayout.SOUTH);
    }

    //method to check if the user got a face card then set the numeric value for the face value to 10 so Jack wont be 11 pts etc.
    public int cardValueChecker(int cardValueIn) {
        int checkedCardValue = cardValueIn;
        int returnValue = 0;
        if(cardValueIn > 10) {
            checkedCardValue = 10;
            return returnValue + checkedCardValue;
        }
        else
            return returnValue + checkedCardValue;
    }

    public void actionPerformed(ActionEvent event) { 
        if (event.getSource() == hit) {
            System.out.println("Card Dealt to player");
            playerCard = myCardDeck.dealCard();
            player.setScore(player.getScore() + cardValueChecker(playerCard.getCardValue()));
            playerDisplayScore = player.getScore();
            playerScore.setText("" + playerDisplayScore);
            playerStatus.setText("Player drew " + playerCard.toString());
            cardsLeft.setText("Cards Remaining: " + myCardDeck.remainingCards());
            checkFor21();
        }
        if (event.getSource() == stand) {
            System.out.println("Card Dealt to Dealer");
            dealerCard = myCardDeck.dealCard();
            dealer.setScore(dealer.getScore() + cardValueChecker(dealerCard.getCardValue()));
            dealerDisplayScore = dealer.getScore();
            dealerScore.setText("" + dealerDisplayScore);
            dealerStatus.setText("Dealer drew " + dealerCard.toString());
            cardsLeft.setText("Cards Remaining: " + myCardDeck.remainingCards());
            checkFor21();
        }
    }

    public void checkFor21() {
        if (playerDisplayScore >= 21){
            playerStatus.setText("Player Busts.");
        }
        else if (dealerDisplayScore >= 21) {
            dealerStatus.setText("Dealer Busts.");
        }
    }
}