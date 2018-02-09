package com.naman.demorest;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Restaurant {
	
	private String Name;
	private int ID;
	private String city;
	private String Menu;
	private String menuitem;
	
	
	public String getMenuitem() {
		return menuitem;
	}
	public void setMenuitem(String menuitem) {
		this.menuitem = menuitem;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMenu() {
		return Menu;
	}
	public void setMenu(String menu) {
		Menu = menu;
	}
	@Override
	public String toString() {
		return "Restaurant [Name=" + Name + ", ID=" + ID + ", city=" + city + ", Menu=" + Menu + ", menuitem="
				+ menuitem + ", getMenuitem()=" + getMenuitem() + ", getName()=" + getName() + ", getID()=" + getID()
				+ ", getCity()=" + getCity() + ", getMenu()=" + getMenu() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

	
	
	

}
