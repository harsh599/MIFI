package com.beans;

public class GymInfo
{
	private int ID;
	private String Image;
	private String GymName;
	private String Locality;
	private String GAddress;
	private String GInfo;
	private String Price;
	
	public GymInfo()
	{
		
	}
	/*public GymInfo(int ID,String Image,String GymName,String Locality,String GAddress,String GInfo,String Price)
	{
		this.ID = ID;
		this.Image = Image;
		this.GymName = GymName;
		this.Locality = Locality;
		this.GAddress = GAddress;
		this.GInfo = GInfo;
		this.Price = Price;
	}*/

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getGymName() {
		return GymName;
	}

	public void setGymName(String gymName) {
		GymName = gymName;
	}

	public String getLocality() {
		return Locality;
	}

	public void setLocality(String locality) {
		Locality = locality;
	}

	public String getGAddress() {
		return GAddress;
	}

	public void setGAddress(String gAddress) {
		GAddress = gAddress;
	}

	public String getGInfo() {
		return GInfo;
	}

	public void setGInfo(String gInfo) {
		GInfo = gInfo;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	@Override
	public String toString() {
		return "GymInfo [ID=" + ID + ", Image=" + Image + ", GymName=" + GymName + ", Locality=" + Locality
				+ ", GAddress=" + GAddress + ", GInfo=" + GInfo + ", Price=" + Price + "]";
	}
	

}
