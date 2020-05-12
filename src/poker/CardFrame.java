package poker;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

public class CardFrame extends JFrame implements ActionListener {
    static Hand Hand=new Hand();
    static String result = " ";



    public CardFrame()
    {
    	Hand=new Hand();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new GridLayout(1,5));
        ImageIcon banner = new ImageIcon(new ImageIcon("resources/poker.png").getImage().getScaledInstance(this.getWidth(), 280, Image.SCALE_DEFAULT));
        JLabel winningHand = new JLabel(banner, JLabel.CENTER);
        winningHand.setPreferredSize(new Dimension(this.getWidth(), 100));
        winningHand.setFont(new Font(winningHand.getFont().getName(), winningHand.getFont().getStyle(), 20));
        winningHand.setBorder(new LineBorder(Color.BLACK));
        String[] card=new String[5];
        card[0]=Hand.cards[0].rank+" "+Hand.cards[0].suite;
        card[1]=Hand.cards[1].rank+" "+Hand.cards[1].suite;
        card[2]=Hand.cards[2].rank+" "+Hand.cards[2].suite;
        card[3]=Hand.cards[3].rank+" "+Hand.cards[3].suite;
        card[4]=Hand.cards[4].rank+" "+Hand.cards[4].suite;

        if(!Hand.RoyalFlush()) {
			if(!Hand.StraightFlush()) {
				if(!Hand.Straight()) {
					if(!Hand.Flush()) {
						if(!Hand.FourKind()) {
							if(!Hand.FullHouse()) {
								if(!Hand.ThreeKind()) {
									result = "You Lose";
									
								}
								else {
									result ="Three of a Kind";
									Hand.PrintHand();
								}
							}
							else {
								result ="Full House";
								Hand.PrintHand();
							}
						}
						else {
							result ="FourKind";
							Hand.PrintHand();
						}
					}
					else {
						result ="Flush";
						Hand.PrintHand();
					}
				}
				else {
					result ="Straight";
					Hand.PrintHand();
				}
			}
			else {
				result ="Straight Flush";
				Hand.PrintHand();
			}
		}
		else {
			result ="Royal Flush";
			Hand.PrintHand();
		}



        ImageIcon img1 = new ImageIcon(new ImageIcon("resources/" +card[0]+ ".png").getImage().getScaledInstance(180, 280, Image.SCALE_DEFAULT));
        ImageIcon img2 = new ImageIcon(new ImageIcon("resources/"+card[1]+ ".png").getImage().getScaledInstance(180, 280, Image.SCALE_DEFAULT));
        ImageIcon img3 = new ImageIcon(new ImageIcon("resources/" +card[2]+ ".png").getImage().getScaledInstance(180, 280, Image.SCALE_DEFAULT));
        ImageIcon img4 = new ImageIcon(new ImageIcon("resources/" +card[3]+ ".png").getImage().getScaledInstance(180, 280, Image.SCALE_DEFAULT));
        ImageIcon img5 = new ImageIcon(new ImageIcon("resources/" +card[4]+ ".png").getImage().getScaledInstance(180, 280, Image.SCALE_DEFAULT));
        JLabel C1 = new JLabel(img1);
        JLabel C2 = new JLabel(img2);
        JLabel C3 = new JLabel(img3);
        JLabel C4 = new JLabel(img4);
        JLabel C5 = new JLabel(img5);


        C1.setBorder(new LineBorder(Color.BLACK));
        C2.setBorder(new LineBorder(Color.BLACK));
        C3.setBorder(new LineBorder(Color.BLACK));
        C4.setBorder(new LineBorder(Color.BLACK));
        C5.setBorder(new LineBorder(Color.BLACK));


        C1.setPreferredSize(new Dimension(180, 280));
        C2.setPreferredSize(new Dimension(180, 280));
        C3.setPreferredSize(new Dimension(180, 280));
        C4.setPreferredSize(new Dimension(180, 280));
        C5.setPreferredSize(new Dimension(180, 280));

        cardPanel.add(C1);
        cardPanel.add(C2);
        cardPanel.add(C3);
        cardPanel.add(C4);
        cardPanel.add(C5);
        
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(2,1));
        
        JLabel arrange = new JLabel(result, JLabel.CENTER);
        arrange.setFont(new Font(winningHand.getFont().getName(), winningHand.getFont().getStyle(), 20));
        arrange.setBorder(new LineBorder(Color.BLACK));
        arrange.setPreferredSize(new Dimension(40, 40));
        
        JButton reset =new JButton("Play Again");  
        reset.setPreferredSize(new Dimension(40, 40));
        reset.addActionListener((new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        		
        		
                distribute();  
                dispose();
		    }  
		}));  

        buttons.add(arrange, BorderLayout.CENTER);
        buttons.add(reset, BorderLayout.CENTER);


        panel.add(winningHand, BorderLayout.NORTH);
        panel.add(cardPanel, BorderLayout.CENTER);
        panel.add(buttons,  BorderLayout.SOUTH);

   
        add(panel);
      
        setVisible(true);  
   
 
        
    }
   
    
    public static void distribute() {
    	new CardFrame(); 	
    	
    	
	
    }
  


    public static void main(String[] args) {
        
    	distribute();

    }



}
