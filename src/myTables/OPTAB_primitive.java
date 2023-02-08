package myTables;

public class OPTAB_primitive {
	private String INS;
	private int Format;
	private String VAL;
	public OPTAB_primitive() {
		
	}
	
	public OPTAB_primitive(String INS,int Format,String VAL) {
		this.INS = INS;
		this.Format = Format;
		this.VAL = VAL;
	}
	
	public String getINS() {
		return INS;
	}

	public void setINS(String iNS) {
		INS = iNS;
	}

	public int getFormat() {
		return Format;
	}

	public void setFormat(int format) {
		Format = format;
	}

	public String getVAL() {
		return VAL;
	}

	public void setVAL(String vAL) {
		VAL = vAL;
	}

	@Override
	public String toString() {
		return "OPTAB_primitive [INS=" + INS + ", Format=" + Format + ", VAL=" + VAL + "]";
	}
	
	
	
}
