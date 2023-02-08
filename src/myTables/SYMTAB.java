package myTables;

import java.util.ArrayList;

import myFunc.MyCustomFunc;

public class SYMTAB {
	private final String out = "SYMTAB.txt";
	private OPTAB OT;
	private ArrayList<SYMTAB_primitive> data;
	static int LOCCTR;
	public SYMTAB(OPTAB OT) {
		data = new ArrayList<SYMTAB_primitive>();
		LOCCTR = 0;
		this.OT = OT;
	}
	
	
	
	public boolean addStatment(String stmt) {
		if(stmt.split(" ").length > 2){
			SYMTAB_primitive line = new SYMTAB_primitive(stmt.split(" ")[0],LOCCTR);		
			data.add(line);
			locator_add(stmt);
			return true;
		}else {
			locator_add(stmt);
			return false;
		}
	}
	
	private void locator_add(String stmt) {
		String SP,TP ;
		if(stmt.split(" ").length > 2) {
			SP = stmt.split(" ")[1];
			TP = stmt.split(" ")[2];
		}else {
			if(stmt.split(" ").length == 1) {
				SP = stmt.split(" ")[0];
				TP = null;
			}else {
				SP = stmt.split(" ")[0];
				TP = stmt.split(" ")[1];
			}
			
		}
		
		if (SP.equals("RESW")){
			LOCCTR += Integer.valueOf(TP)* 3;
        }else if (SP.equals("RESB")){
			LOCCTR += Integer.valueOf(TP);
        }else if (SP.equals("WORD")){
        	LOCCTR += 3;
        }else if (SP.equals("BYTE")){
        	if(TP.charAt(0) == 'C') {
        		LOCCTR+= TP.length()-3;
        	}else if(TP.charAt(0) == 'X') {
        		LOCCTR+=1;
        	}
        }else if (SP.contains("+")){
        	LOCCTR += 4;
        }else if (OT.getSizeOfINS(SP) != -1){
        	LOCCTR += OT.getSizeOfINS(SP);
        }
	}
	
	public void printData() {
		if(data.size() >  0) {
			for(SYMTAB_primitive part : data) {
				System.out.println(part.toString());
			}
		}else {
			System.out.println("Table is Empty");
		}
	}
	
	public void printDataHEX() {
		if(data.size() >  0) {
			for(SYMTAB_primitive part : data) {
				System.out.println(part.toStringHEX());
			}
		}else {
			System.out.println("Table is Empty");
		}
	}
	
	public void pushDataHEXFILE() {
		if(data.size() >  0) {
			boolean flag = true;
			for(SYMTAB_primitive part : data) {
				if(flag) {
					MyCustomFunc.WriteFile(out, part.toStringHEXfile()+"\n", false);
					flag = false;
				}else
				MyCustomFunc.WriteFile(out, part.toStringHEXfile()+"\n", true);
			}
		}else {
			System.out.println("Table is Empty");
		}
	}
	
}
