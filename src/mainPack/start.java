package mainPack;
import java.util.ArrayList;

import myFunc.*;
import myTables.OPTAB;
import myTables.SYMTAB;
public class start {
	public static void main(String[] args) {
		ArrayList<String> res = MyCustomFunc.ReadFile("sample-Input.txt");
		ArrayList<String> vaid = MyCustomFunc.CleanInput(res);
		OPTAB x = new OPTAB();
		x.readData();
		SYMTAB p = new SYMTAB(x);
		for(String part : vaid) {
			p.addStatment(part);
		}
		p.pushDataHEXFILE();
	}
}