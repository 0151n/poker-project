package Poker;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;





public class Gui extends JFrame{
	public Gui() {
		
		super("Poker Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(900, 450);
		
		final String sbet = String.format("%d",PokerGame.playerbet);
		final String aisbet = String.format("%d",PokerGame.aibet);
	
		final String sbank = String.format("%d",PokerGame.playerbank);
		final String aisbank = String.format("%d",PokerGame.aibank);
		
		//setVisible(true);
		 LineBorder border = new LineBorder ( Color.black, 3, true );
		//Initialization of gui items
		 
		 //images used for Player and computer
		ImageIcon image1 = new ImageIcon(PokerGame.shand[0]);
		ImageIcon image2 = new ImageIcon(PokerGame.shand[1]);
		ImageIcon image3 = new ImageIcon(PokerGame.shand[2]);
		ImageIcon image4 = new ImageIcon(PokerGame.shand[3]);
		ImageIcon image5 = new ImageIcon(PokerGame.shand[4]);
		final ImageIcon image6 = new ImageIcon(PokerGame.shand[5]);
		final ImageIcon image7 = new ImageIcon(PokerGame.shand[6]);
		final ImageIcon image8 = new ImageIcon(PokerGame.shand[7]);
		final ImageIcon image9 = new ImageIcon(PokerGame.shand[8]);
		final ImageIcon image10 = new ImageIcon(PokerGame.shand[9]);
			ImageIcon blank = new ImageIcon("images/54.png");
		
		
		JLabel player1 = new JLabel("", image1, JLabel.CENTER);
		JLabel player2 = new JLabel("", image2, JLabel.CENTER);
		JLabel player3 = new JLabel("", image3, JLabel.CENTER);
		JLabel player4 = new JLabel("", image4, JLabel.CENTER);
		JLabel player5 = new JLabel("", image5, JLabel.CENTER);
		final JLabel ai = new JLabel("", blank, JLabel.CENTER);
		final JLabel ai1 = new JLabel("", blank, JLabel.CENTER);
		final JLabel ai2 = new JLabel("", blank, JLabel.CENTER);
		final JLabel ai3 = new JLabel("", blank, JLabel.CENTER);
		final JLabel ai4 = new JLabel("", blank, JLabel.CENTER);
	
		//rank textfield
		JLabel Rank = new JLabel("Rank:", JLabel.CENTER);
		JTextField rank_field = new JTextField(PokerGame.playerRank);
		rank_field.setEditable(false);
		rank_field.setToolTipText("Rank");
		
		//label for computers bet textfield
		JLabel aibetlabel = new JLabel("Computer's current bet:", JLabel.CENTER);
		JLabel playerbetlabel = new JLabel("Player's current bet:", JLabel.CENTER);
		//action pane
		
		//call button
		JButton call = new JButton("Call");
		call.setToolTipText("Call the hand");
		
		//fold button
		JButton fold = new JButton("Fold");
		fold.setToolTipText("Fold");
		
		//bet_panel pane
		
		//raise by 10 button
		JButton raise_10 = new JButton("+ 10");
		raise_10.setToolTipText("Raise bet by 10");
		
		//lower by 10 button
		JButton lower_10 = new JButton("- 10");
		lower_10.setToolTipText("Lower bet by 10");
	
		//raise by 1 button
		JButton raise_1 = new JButton("+ 1");
		raise_1.setToolTipText("Raise bet by 1");
		
		//lower by 1 button
		JButton lower_1 = new JButton("- 1");
		lower_1.setToolTipText("Lower bet by 1");
	
		//raise by 100 button
		JButton raise_100 = new JButton("+ 100");
		raise_100.setToolTipText("Raise bet by 100");
		
		//lower by 100 button
		JButton lower_100 = new JButton("- 100");
		lower_100.setToolTipText("Lower bet by 100");

		//textfield for players bet
		final JTextField bet = new JTextField(sbet);
		bet.setEditable(false);
		bet.setToolTipText("current bet");
		
		//textfield for computers bet
		final JTextField aibet = new JTextField(aisbet);
		aibet.setEditable(false);
		aibet.setToolTipText("computer's current bet");
	
		//textfield for computers bank total
		final JTextField aitotal= new JTextField(sbank);
		aibet.setEditable(false);
		aibet.setToolTipText("computer's current bank total");
		
	    //textfield for players bank total
		final JTextField playertotal = new JTextField(aisbank);
		aibet.setEditable(false);
		aibet.setToolTipText("computer's current bank total");
		
	
		/*panel to show computer's hand
		 * unused
		JPanel bet_panel = new JPanel(new GridLayout(4,1,5,5));
		bet_panel.setBorder(BorderFactory.createTitledBorder(border, "Bet", TitledBorder.CENTER, TitledBorder.TOP,  new Font ( "Arial", Font.BOLD, 14 ),Color.black));
	
		JPanel playerbet_panel = new JPanel(new GridLayout(1,7,5,5));		
		playerbet_panel.add(lower_1);
		playerbet_panel.add(lower_10);
		playerbet_panel.add(lower_100);
		playerbet_panel.add(bet);
		playerbet_panel.add(raise_100);
		playerbet_panel.add(raise_10);
		playerbet_panel.add(raise_1);
		
		
		JPanel aibet_panel = new JPanel(new GridLayout(1,2,5,5));
		aibet_panel.add(aibetlabel);
		aibet_panel.add(aibet);
		
		//panel to show player's hand
		bet_panel.add(aibet_panel);
		bet_panel.add(new JSeparator(SwingConstants.HORIZONTAL));
		bet_panel.add(playerbetlabel);
		bet_panel.add(playerbet_panel);
		*/
		//panel which displays your hand.
		JPanel card_panel = new JPanel(new FlowLayout());
		card_panel.setBorder(BorderFactory.createTitledBorder(border, "Player Hand", TitledBorder.CENTER, TitledBorder.TOP,  new Font ( "Arial", Font.BOLD, 14 ),Color.black));

		card_panel.add(player1);
		card_panel.add(player2);
		card_panel.add(player3);
		card_panel.add(player4);
		card_panel.add(player5);
		
		//panel which displays computers hand
		JPanel ai_panel = new JPanel(new FlowLayout());
		ai_panel.setBorder(BorderFactory.createTitledBorder(border, "Computer Hand", TitledBorder.CENTER, TitledBorder.TOP,  new Font ( "Arial", Font.BOLD, 14 ),Color.red));

		ai_panel.add(ai);
		ai_panel.add(ai1);
		ai_panel.add(ai2);
		ai_panel.add(ai3);
		ai_panel.add(ai4);
		 
		//panel with call/fold buttons and hand rank
		JPanel rank_panel = new JPanel(new FlowLayout());
		rank_panel.setBorder(BorderFactory.createTitledBorder(border, "Rank", TitledBorder.RIGHT, TitledBorder.TOP,  new Font ( "Arial", Font.BOLD, 14 ),Color.red));
		rank_panel.add(call);
		rank_panel.add(Rank);
		rank_panel.add(rank_field);
		rank_panel.add(fold);

		//add panels to window
		add(rank_panel,BorderLayout.NORTH);
		add(card_panel,BorderLayout.WEST);
		add(ai_panel,BorderLayout.EAST);
		//removed betting functionality for now.
		//add(bet_panel, BorderLayout.SOUTH);
		
	
		/* action listeners for betting buttons not needed at the moment.
		 raise_1.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e)
	            {
	            	PokerGame.playerbet += 1;
	            	bet.setText(String.format("%d",PokerGame.playerbet));
	            }
	        });  
		 
		 raise_10.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e)
	            {
	            	PokerGame.playerbet += 10;
	            	bet.setText(String.format("%d",PokerGame.playerbet));
	            }
	        });    
		 
		 raise_100.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e)
	            {
	            	PokerGame.playerbet += 100;
	            	bet.setText(String.format("%d",PokerGame.playerbet));
	            }
	        }); 
		 
		 lower_100.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e)
	            {
	            	if(PokerGame.playerbet > 100){
	            		PokerGame.playerbet -= 100;
	            		bet.setText(String.format("%d",PokerGame.playerbet));
	            	}
	            }
	        });   
		 
		 lower_10.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e)
	            {
	            	if(PokerGame.playerbet > 10){
	            		PokerGame.playerbet -= 10;
	            		bet.setText(String.format("%d",PokerGame.playerbet));
	            	}
	            }
	        });   
		 
		 lower_1.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e)
	            {
	            	if(PokerGame.playerbet > 0){
	            		PokerGame.playerbet -= 1;
	            		bet.setText(String.format("%d",PokerGame.playerbet));
	            	}
	            }
	        }); 
		 */
		 //action listener for call button
		 call.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e)
	            {
	            	ai.setIcon(image6);
	            	ai1.setIcon(image7);
	            	ai2.setIcon(image8);
	            	ai3.setIcon(image9);
	            	ai4.setIcon(image10);
	            	PokerGame.outcome = PokerGame.compare_hands(PokerGame.playerRank,PokerGame.aiRank);
	            	System.out.println(PokerGame.outcome);
	            }
	        });  
		 //action listener for fold button.
		 fold.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e)
	            {
	            	ai.setIcon(image6);
	            	ai1.setIcon(image7);
	            	ai2.setIcon(image8);
	            	ai3.setIcon(image9);
	            	ai4.setIcon(image10);
	            	JOptionPane.showMessageDialog(null, "Computer Wins By Default!");
	            }
	        });
	}
}
