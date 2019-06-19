package com.web;
import java.util.Random;

public class Items 
{
	private String[] adjectives = new String[] 
			{
				"Golden","Silver","Copper",
				"Bronze","Dirty","Soft","Clean",
				"Rough","Crimson","Crystal",
				"Mystical","Loud","Sharp",
				"Evil","Holy","Spiteful","Rage-filled",
				"Glass","Broken","Shattered",
				"Fresh","Wooden","Stone",
				"Bright","Shiny","Diamond",
				"Leather","Wool","Fluid",
				"Marble","Granite","Obsidian",
				"Mossy","Cracked","Perfect"
			}; // There are 33 items in this array
	private String[] nouns = new String[]
			{
				"Shovel","Sword","Sheild",
				"Fork","Spoon","Chair",
				"Pen","Shirt","Pants",
				"Jacket","Bow","Spear",
				"Mace","Flail","Lance",
				"Club","Vase","Clock",
				"Bin","Bag","Pizza",
				"Candy","Shoes","Rock",
				"Bar","Ingot","Axe",
				"Leaf","Cake","Eye"
			}; // There are 30 items in this array
	
	
	
	Random randInt = new Random();
	private Integer xPos;
	private Integer yPos;
	private Integer scoreValue;
	private String name;
	
	public Items(/*Integer xPos, Integer yPos, Integer scoreValue, String name*/)
	{
		/*
		this.xPos = xPos;
		this.yPos = yPos;
		this.scoreValue = scoreValue;
		this.name = name;
		*/
	}
	public Integer[] genPos()
	{
		this.xPos = randInt.nextInt(100);
		this.yPos = randInt.nextInt(100);
		Integer[] itemPosition = new Integer[] {xPos,yPos};
		return itemPosition;
	}
	public String name()
	{
		String adj = adjectives[randInt.nextInt(33)];
		String noun = nouns[randInt.nextInt(30)];
		this.name = adj +" " + noun;
		return adj +" " + noun;
	}
	public Object[][] genItem()
	{
		Integer[] position = this.genPos();
		String Name = this.name();
		Object[][] newItemValues = {{position[0],position[1]},{Name}};
		return newItemValues;
	}
}