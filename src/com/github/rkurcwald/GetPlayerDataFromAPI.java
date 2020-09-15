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

			URL url= new URL(stringURL);
			URLConnection conn = url.openConnection();
			String redirect = conn.getHeaderField("Location");
			if (redirect != null)
			{
			    conn = new URL(redirect).openConnection();
			}
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) 
			{
			    playerData.add(inputLine);
			}
			
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
