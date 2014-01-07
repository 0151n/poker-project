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

			//define image array
			ImageIcon images[];
			
			//define jlabels for images
			JLabel player1;
			JLabel player2;
			JLabel player3;
			JLabel player4;
			JLabel player5;
			JLabel ai;
			JLabel ai1;
			JLabel ai2;
			JLabel ai3;
			JLabel ai4;
			//image for back of card
			ImageIcon blank = new ImageIcon("images/54.png");
			
	public Gui() {
		
		super("Poker Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(900, 450);
		
		final String sbet = String.format("%d",PokerGame.playerbet);
		final String aisbet = String.format("%d",PokerGame.aibet);
	
		final String sbank = String.format("%d",PokerGame.playerbank);
		final String aisbank = String.format("%d",PokerGame.aibank);
		
		//array of images for cards
		final ImageIcon images[] = new ImageIcon[52];
		//load images into array
		load_images(images);
		
		//setVisible(true);
		 LineBorder border = new LineBorder ( Color.black, 3, true );
		//Initialization of gui items
		 
		 //images used for Player and computer, initialisation		
		final JLabel player1 = new JLabel("", images[PokerGame.hand[0]], JLabel.CENTER);
		final JLabel player2 = new JLabel("", images[PokerGame.hand[1]], JLabel.CENTER);
		final JLabel player3 = new JLabel("", images[PokerGame.hand[2]], JLabel.CENTER);
		final JLabel player4 = new JLabel("", images[PokerGame.hand[3]], JLabel.CENTER);
		final JLabel player5 = new JLabel("", images[PokerGame.hand[4]], JLabel.CENTER);
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
		
		JButton reset = new JButton("Reset");
		reset.setToolTipText("Start a new game");
		
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
		rank_panel.add(reset);

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
	            	ai.setIcon(images[PokerGame.aihand[0]]);
	            	ai1.setIcon(images[PokerGame.aihand[1]]);
	            	ai2.setIcon(images[PokerGame.aihand[2]]);
	            	ai3.setIcon(images[PokerGame.aihand[3]]);
	            	ai4.setIcon(images[PokerGame.aihand[4]]);
	            	PokerGame.outcome = PokerGame.compare_hands(PokerGame.playerRank,PokerGame.aiRank);
	            	System.out.println(PokerGame.outcome);
	            }
	        });  
		 //action listener for fold button.
		 fold.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e)
	            {
	             	ai.setIcon(images[PokerGame.aihand[0]]);
	            	ai1.setIcon(images[PokerGame.aihand[1]]);
	            	ai2.setIcon(images[PokerGame.aihand[2]]);
	            	ai3.setIcon(images[PokerGame.aihand[3]]);
	            	ai4.setIcon(images[PokerGame.aihand[4]]);
	            	JOptionPane.showMessageDialog(null, "Computer Wins By Default!");
	            }
	        });  
		 //action listener for reset button
		reset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
            	PokerGame.game();
            	//reset_images();
            	ai.setIcon(blank);
            	ai1.setIcon(blank);
            	ai2.setIcon(blank);
            	ai3.setIcon(blank);
            	ai4.setIcon(blank);
            	player1.setIcon(images[PokerGame.hand[0]]);
            	player2.setIcon(images[PokerGame.hand[1]]);
            	player3.setIcon(images[PokerGame.hand[2]]);
            	player4.setIcon(images[PokerGame.hand[3]]);
            	player5.setIcon(images[PokerGame.hand[4]]);
            }
        });  
		
	
	}
	public int load_images(ImageIcon images[]) {
		String card = "images/*.png";
		for(int i = 0;i < 52;i++){
			card = String.format("images/%d.png",i);
			images[i] = new ImageIcon(card);
		}
		return 0;
	}
	public void reset_images() {
		//reset the ai cards to blank
		ai1.setIcon(blank);
    	ai.setIcon(blank);
    	ai2.setIcon(blank);
    	ai3.setIcon(blank);
    	ai4.setIcon(blank);
    	player1.setIcon(images[PokerGame.hand[0]]);
    	player2.setIcon(images[PokerGame.hand[1]]);
    	player3.setIcon(images[PokerGame.hand[2]]);
    	player4.setIcon(images[PokerGame.hand[3]]);
    	player5.setIcon(images[PokerGame.hand[4]]);
	}
	
	
}