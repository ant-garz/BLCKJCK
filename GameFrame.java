import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.BorderLayout;

public class GameFrame extends JFrame {
    private JButton hit = new JButton("Hit Me");

    GameFrame() {
        setTitle("BLCKJCK");
        setBounds(200,200,300,175);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create container to hold all content of the game GUI
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //create button panel add it to bottom of content pane (south)
        JPanel btnPanel = new JPanel();
        btnPanel.add(hit);
        contentPane.add(btnPanel, BorderLayout.SOUTH);

        JPanel dealerPanel = new JPanel();
        dealerPanel.setLayout(new BorderLayout());
        JLabel dealerHeader = new JLabel("Dealer Score:");
        JLabel dealerScore = new JLabel("0");
        dealerPanel.add(dealerHeader, BorderLayout.NORTH);
        dealerPanel.add(dealerScore, BorderLayout.CENTER);
        contentPane.add(dealerPanel, BorderLayout.WEST);

        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new BorderLayout());
        JLabel playerHeader = new JLabel("Player Score:");
        JLabel playerScore = new JLabel("0");
        playerPanel.add(playerHeader, BorderLayout.NORTH);
        playerPanel.add(playerScore, BorderLayout.CENTER);
        contentPane.add(playerPanel, BorderLayout.EAST);
    }
}