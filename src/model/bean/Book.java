package model.bean;

public class Book {
	private int id ;
	private String tensach;
	private int soluong;
	private int namsx;
	private String nhasx;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getNamsx() {
		return namsx;
	}
	public void setNamsx(int namsx) {
		this.namsx = namsx;
	}
	public String getNhasx() {
		return nhasx;
	}
	public void setNhasx(String nhasx) {
		this.nhasx = nhasx;
	}
	public Book(int id, String tensach, int soluong, int namsx, String nhasx) {
		super();
		this.id = id;
		this.tensach = tensach;
		this.soluong = soluong;
		this.namsx = namsx;
		this.nhasx = nhasx;
	}
	public Book() {
		super();
	}
	
}
