package com.github.rkurcwald;


public class GameLinkValue 
{
	private String world; 
	private String gameLink;
	private String fullLink;
	
	public GameLinkValue(String world, String gameLink)
	{
		this.world=world;
		this.gameLink=gameLink;
	}
	
	public void setWorld(String world)
	{
		this.world=world;
	}
	public String getWorld()
	{
		return world;
	}
	
	public void setGameLink(String gameLink)
	{
		this.gameLink=gameLink;
	}
	public String getGameLink()
	{
		return gameLink;
	}
	
	public String getFullLink() //ADD EXCEPTION
	{
		if(world.equals("") || gameLink.equals(""))
		{
			return "";
		}
		else
		{
			return "http://"+getWorld()+"."+ getGameLink();
			
			
		}
	}
}
