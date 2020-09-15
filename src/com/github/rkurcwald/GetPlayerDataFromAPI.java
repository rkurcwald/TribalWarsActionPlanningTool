package com.github.rkurcwald;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.swing.text.Document;

public class GetPlayerDataFromAPI 
{
	//GameLinkValue glv = new GameLinkValue();
	//"http://pl158.plemiona.pl/map/player.txt"
	
	private final String APILINK="/map/player.txt";
	private final int BUFFERSIZE=10240;
	private ArrayList<String> playerData=new ArrayList<String>();
	private String stringURL;
	

	public GetPlayerDataFromAPI(GameLinkValue glv) throws Exception
	{
		stringURL=glv.getFullLink()+APILINK;
		try
		{	

			URL finalURL= new URL(stringURL);

			//##################	WORK
			BufferedInputStream iStream = new BufferedInputStream(finalURL.openStream());
			
			BufferedReader readVal=null;
			try
			{

				readVal = new BufferedReader(new InputStreamReader(iStream,"UTF-8"),BUFFERSIZE);
			//	BufferedReader readVal = new BufferedReader(new InputStreamReader(finalURL.openStream()));

	/*			for(int data;(data=readVal.read())>-1;)
				{
					playerData.add(((BufferedReader) readVal).readLine().toString());
					
				} */
				String inLine;
				while ((inLine = readVal.readLine())!= null)
				{
					System.out.println(inLine);
					playerData.add(inLine);
				}
			}
			finally
			{
				readVal.close();
				
				for(int i=0;i<playerData.size();i++)
				{
					System.out.println(finalURL.getFile().length());
				}
			} 
			//##################		
			
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public ArrayList getPlayerData()
	{
		return playerData;
	}
}
