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
			JTextField rank_field;
			//image for back of card
			ImageIcon blank = new ImageIcon("images/54.png");
                        
                        //score elements
                        JLabel player = new JLabel("Player");
                        JLabel computer = new JLabel("Computer");
                        JTextField player_score;
                        JTextField computer_score;
	public Gui() {
		
		super("Poker Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(900, 450);
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
		final JTextField rank_field = new JTextField(PokerGame.playerRank);
		rank_field.setEditable(false);
		rank_field.setToolTipText("Rank");
		rank_field.setColumns(15);
  
                         //score textfields
                         final JTextField player_score = new JTextField("0");
                         player_score.setEditable(false);
                         player_score.setToolTipText("player score");
                         
                         final JTextField computer_score = new JTextField("0");
                         computer_score.setEditable(false);
                         computer_score.setToolTipText("computer score");
		
		
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
		

                           JPanel score_panel = new JPanel(new FlowLayout());
                           score_panel.setBorder(BorderFactory.createTitledBorder(border, "Score", TitledBorder.CENTER, TitledBorder.TOP,  new Font ( "Arial", Font.BOLD, 14 ),Color.blue));
		score_panel.add(computer);
                           score_panel.add(computer_score);
                           score_panel.add(player);
                           score_panel.add(player_score);


                           //add panels to window
		add(rank_panel,BorderLayout.NORTH);
		add(card_panel,BorderLayout.WEST);
		add(ai_panel,BorderLayout.EAST);
                          add(score_panel,BorderLayout.SOUTH);
		
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
                
                                           if(PokerGame.outcome == "Computer Wins!"){
                                                   PokerGame.computer_score++;
                                                   computer_score.setText(Integer.toString(PokerGame.computer_score));
                                           }
                                                                      
                                           if(PokerGame.outcome == "Player Wins!"){
                                                   PokerGame.player_score++;
                                                   player_score.setText(Integer.toString(PokerGame.player_score));
                                           }                      
                                                          	            	
                                          System.out.println(PokerGame.outcome);
                                                  	PokerGame.game();
                                    	
                            	//reset computers hand to blank images
                            	ai.setIcon(blank);
                            	ai1.setIcon(blank);
                            	ai2.setIcon(blank);
                            	ai3.setIcon(blank);
                            	ai4.setIcon(blank);
                            	
                            	//reset the players hand images
                            	player1.setIcon(images[PokerGame.hand[0]]);
                            	player2.setIcon(images[PokerGame.hand[1]]);
                            	player3.setIcon(images[PokerGame.hand[2]]);
                            	player4.setIcon(images[PokerGame.hand[3]]);
                            	player5.setIcon(images[PokerGame.hand[4]]);
                            	
                            	//reset the rank field
                            	rank_field.setColumns(PokerGame.playerRank.length());
                            	rank_field.setText(PokerGame.playerRank);
                                  
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
                              
                                       PokerGame.game();
                            	
                            	//reset computers hand to blank images
                            	ai.setIcon(blank);
                            	ai1.setIcon(blank);
                            	ai2.setIcon(blank);
                            	ai3.setIcon(blank);
                            	ai4.setIcon(blank);
                            	
                            	//reset the players hand images
                            	player1.setIcon(images[PokerGame.hand[0]]);
                            	player2.setIcon(images[PokerGame.hand[1]]);
                            	player3.setIcon(images[PokerGame.hand[2]]);
                            	player4.setIcon(images[PokerGame.hand[3]]);
                            	player5.setIcon(images[PokerGame.hand[4]]);
                            	
                            	//reset the rank field
                            	rank_field.setText(PokerGame.playerRank);
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

	
	
}