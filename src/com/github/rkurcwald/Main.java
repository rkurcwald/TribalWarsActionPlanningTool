package com.github.rkurcwald;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class Main extends JPanel {

	public static void main(String[] args) {
		String currentWorld="pl158"; 	//Get From GUI
		String gameLink="plemiona.pl";	//Get From GUI
		
        GameLinkValue glv= new GameLinkValue(currentWorld,gameLink);
 //       glv.setWorld(currentWorld);
 //       glv.setGameLink(gameLink);
		
        GetPlayerDataFromAPI playerData;
		try {
			playerData = new GetPlayerDataFromAPI(glv);
			ArrayList<String> test= playerData.getPlayerData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
      //  System.out.println(test.get(2));
        
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Map");
                Map map = new Map();
                frame.add(map);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        }); //IT WORKS
    }


}
