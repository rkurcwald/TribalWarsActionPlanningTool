package com.github.rkurcwald;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.swing.text.Document;

public class GetDataFromAPI 
{
	//GameLinkValue glv = new GameLinkValue();
	//"http://pl158.plemiona.pl/map/player.txt"
	
	private final String APILINK="/map/";
	private final int BUFFERSIZE=10240;
	private ArrayList<String> playerData=new ArrayList<String>();
	private ArrayList<String> villageData=new ArrayList<String>();
	private ArrayList<String> allyData=new ArrayList<String>();
	private String stringURL="",tmpURL="";
	

	public GetDataFromAPI(GameLinkValue glv) throws Exception
	{
		tmpURL=stringURL=glv.getFullLink()+APILINK;
		getData("village");
		getData("player");
		getData("ally");
		
	}
	
	private void getData(String dataType) throws NoSuchMethodException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
	{
    	stringURL+=dataType+".txt";
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

			
			String returnArrayName = dataType+"Data";
			Field field = this.getClass().getDeclaredField(returnArrayName);
		    field.setAccessible(true);
		    Object value = field.get(this);
			while ((inputLine = in.readLine()) != null) 
			{
			//	System.out.println(inputLine);
				((ArrayList<String>) value).add(inputLine);
				
			}
			
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		stringURL=tmpURL;
	}
	
	public ArrayList getPlayerData()
	{
		return playerData;
	}
	public ArrayList getVillageData()
	{
		return villageData;
	}
	public ArrayList getAllyData()
	{
		return allyData;
	}
}
