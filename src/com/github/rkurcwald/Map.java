package com.github.rkurcwald;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.List;
import java.util.*;

public class Map extends JPanel {

    public static final Color FOREST = new Color(0,150,0);
    public static final Color ENEMY = new Color(255,0,0);
    public static final Color ALLY = new Color(0,135,130);
    public static final Color OWNTRIBE = new Color(0,0,130);
    public static final Color OWN = new Color(255,255,255);
    public static final Color LINES=new Color(0,90,0);
    
    public static List<String> CORDS=new ArrayList<String>();

    public static final int NUM_ROWS = 501;
    public static final int NUM_COLS = 501;

    public static final int PREFERRED_GRID_SIZE_PIXELS = 5;
    private final Color[][] terrainGrid;

    public void addCords()
    {
    	CORDS.add("464,467");
    	CORDS.add("490,504");
    	CORDS.add("509,493");
    	CORDS.add("497,515");
    	CORDS.add("487,526");
    	CORDS.add("504,527");
    	CORDS.add("491,492");
    	CORDS.add("502,461");
    	CORDS.add("503,467");
    	CORDS.add("572,473");
    	CORDS.add("520,567");
    	CORDS.add("515,422");
    	CORDS.add("447,485");
    }
    
    public Map(){
    	addCords();
        this.terrainGrid = new Color[NUM_ROWS][NUM_COLS];
       // Random r = new Random();

        for (int i = 0; i < NUM_ROWS; i++) {
        	
            for (int j = 0; j < NUM_COLS; j++) {
            	if(i==250 || j==250)
            	{
            		this.terrainGrid[i][j] = Color.BLACK;
            	}
            	else
            	{
            		if(i%5==0)
            		{
            			this.terrainGrid[i][j]=LINES;
            		}
            		else if(j%5==0)
            		{
            			this.terrainGrid[i][j]=LINES;
            		}
            		else
            		{
            			this.terrainGrid[i][j]=FOREST;
            		}
            		//int randomTerrainIndex = r.nextInt(TERRAIN.length);
                	//Color randomColor = TERRAIN[randomTerrainIndex];
                	//this.terrainGrid[i][j] = randomColor;
            	}
            	
            	
            }
        }
        this.terrainGrid[221][277]=OWN;
        
        int cordX=0,cordY=0, cordXX=0,cordYY=0;
        String[] cordsTable = null;

     //   for(int i=251;i<NUM_ROWS;i++)
     //   {
      //  	for (int j = 0; j < NUM_COLS; j++)
       // 	{
        //		if(i!=250 && j!=250)
        //		{
        	        for(int k=0;k<CORDS.size();k++)
        	        {
        	        	cordsTable=CORDS.get(k).split(",");
        	        	cordX=Integer.parseInt(cordsTable[0]);
        	   //     	System.out.println(cordX);
        	        	cordY=Integer.parseInt(cordsTable[1]);
        	  //      	System.out.println(cordY);
        	        	if(cordX<500)
            			{
        	        		cordXX=500-cordX;
            				cordX=250-cordXX;
            //				System.out.println("1X   "+cordX);
            			}
        	        	else
        	        	{
        	        		cordXX=cordX-499;
            				cordX=250+cordXX;
            //				System.out.println("2X   "+cordX);
        	        	}
        	        	if(cordY<500)
            			{
        	        		cordYY=500-cordY;
            				cordY=250-cordYY;
            //				System.out.println("1Y   "+cordX);
            			}
        	        	else
        	        	{
        	        		cordYY=cordY-499;
            				cordY=250+cordYY;
            //				System.out.println("2Y   "+cordX);
        	        	}
        	        	this.terrainGrid[cordX][cordY] = ENEMY;
        	        }
        	        
        int preferredWidth = NUM_COLS * PREFERRED_GRID_SIZE_PIXELS;
        int preferredHeight = NUM_ROWS * PREFERRED_GRID_SIZE_PIXELS;
        setPreferredSize(new Dimension(preferredWidth, preferredHeight));
    }

    @Override
    public void paintComponent(Graphics g) {
        // Important to call super class method
        super.paintComponent(g);
        // Clear the board
        g.clearRect(0, 0, getWidth(), getHeight());
        // Draw the grid
        int rectWidth = getWidth() / NUM_COLS;
        int rectHeight = getHeight() / NUM_ROWS;

        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                // Upper left corner of this terrain rect
                int x = i * rectWidth;
                int y = j * rectHeight;
                Color terrainColor = terrainGrid[i][j];
                g.setColor(terrainColor);
                g.fillRect(x, y, rectWidth, rectHeight);
            }
        }
    }

    }