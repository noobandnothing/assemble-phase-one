package myTables;

public class SYMTAB_primitive {
	private String label;
	private int address;
	
	public SYMTAB_primitive() {
		
	}
	
	public SYMTAB_primitive(String label,int address) {
		this.label = label;
		this.address = address;
	}
	

	public String getLablel() {
		return label;
	}

	public void setLablel(String label) {
		this.label = label;
	}

	public int getAddress() {
		return address;
	}
	
	public String getAddressHEX() {
		return Integer.toHexString(address);
	}

	public void setAddress(int address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "SYMTAB_primitive [label=" + label + ", address=" + address + "]";
	}
	
	public String toStringHEX() {
		return "SYMTAB_primitive [label=" + label + ", address=" + this.getAddressHEX().toUpperCase() + "]";
	}
	
	public String toStringHEXfile() {
		return   label + "\t" + this.getAddressHEX().toUpperCase();
	}

	
	
}
