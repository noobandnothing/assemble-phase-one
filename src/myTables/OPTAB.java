package myTables;
import java.util.ArrayList;

import myFunc.MyCustomFunc;

public class OPTAB {
	private final String dir = "instructions.txt";
	private ArrayList<OPTAB_primitive> data;
	public OPTAB() {
		data = new ArrayList<OPTAB_primitive>();
	}


	public void readData() {
		ArrayList<String> datafromfile = MyCustomFunc.ReadFile(dir);
		datafromfile = MyCustomFunc.CleanInput(datafromfile);
		for(String obj : datafromfile) {
			String[] parts = obj.split(" ");
			data.add(new OPTAB_primitive(parts[0],Integer.parseInt(parts[1]),parts[2]));
		}
	}
	
	public void printData() {
		if(data.size() >  0) {
			for(OPTAB_primitive part : data) {
				System.out.println(part.toString());
			}
		}else {
			System.out.println("Table is Empty");
		}
	}
	
	public int getSizeOfINS(String INS) {
		int format = 0;
		for(OPTAB_primitive part : data) {
			if(part.getINS().equals(INS)) {
				format = part.getFormat();
				break;
			}
		}
		return format;
	}
	
	public String getVal(String INS) {
		String  value  = null;
		for(OPTAB_primitive part : data) {
			if(part.getINS().equals(INS)) {
				value = part.getVAL();
				break;
			}
		}
		return value;
	}


}
