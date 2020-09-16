package com.github.rkurcwald;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class Main extends JPanel {

	public static void main(String[] args) 
	{
		String currentWorld="pl158"; 	//Get From GUI
		String gameLink="plemiona.pl";	//Get From GUI
		
        GameLinkValue glv= new GameLinkValue(currentWorld,gameLink);
		
        GetDataFromAPI apiData;
		try 
		{
			apiData = new GetDataFromAPI(glv);
			
	//		ArrayList<String> test= apiData.getPlayerData();
			ArrayList<String> test= apiData.getVillageData();
	//		ArrayList<String> test= apiData.getAllyData();
			for(int i=0;i<test.size();i++)      //IT WORKS!
			{
				System.out.println(test.get(i));
			}
			
			SwingUtilities.invokeLater(new Runnable() {
	            public void run() 
	            {
	                JFrame frame = new JFrame("Map TribalWars");
	                Map map = new Map(apiData);
	                frame.add(map);
	                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                frame.pack();
	                frame.setVisible(true);
	            }
	        }); //IT WORKS
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
        
        
		
    }


}
