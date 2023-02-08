package myFunc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyCustomFunc {

	public MyCustomFunc() {
	}
	
	public static ArrayList<String> CleanInput(ArrayList<String> res){
		ArrayList<String> fix = new ArrayList <String>();
		String [] x;
		for(String obj : res) {
			x = obj.split(" ");
			String line ="";
			int mycount = 0;
			for(int counter = 0 ; counter < x.length ;counter++) {
				if(!x[counter].equals("")) {
					mycount++;
					if(mycount >= 3) {
						line+=x[counter];
					}else {
						line+=x[counter]+" ";
					}
				}
			}
			line = line.replace(" ,", ",");
			line = line.trim();
			fix.add(line);
		}
	    return fix;
	}
	
	
    public static ArrayList<String> ReadFile(String FileName) {
    	ArrayList<String> data = new ArrayList<String>();
	    try {
		      File file = new File(FileName);
		      Scanner myReader = new Scanner(file);
		      while (myReader.hasNextLine()) {
		        data.add(myReader.nextLine());
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		    	System.out.println("\n"+FileName+" is not found");
		    }
	    return data;
    }
    
    public static int hextoint (String hexstring){
    	    int number = Integer.parseInt(hexstring,16);;
    	    return number;
    }
    
    public static void WriteFile(String FileName ,String Content,Boolean append) {
    	if (append == false) {
    		  try {
    	          FileWriter myWriter = new FileWriter(FileName);
    	          myWriter.write(Content);
    	          myWriter.close();
    	        } catch (IOException e) {
    	        	System.out.println("\n File not file");
    	        }
    	}else if (append == true){
    		  try {
    			  File file = new File(FileName);
  	            if(!file.exists()) {
  	            	file.createNewFile();
  	            }
  	            FileWriter myWriter = new FileWriter(file.getName(),true);
  	            BufferedWriter bufferwriter = new BufferedWriter(myWriter);
  	            bufferwriter.write(Content);
  	            bufferwriter.close();
    		  } catch (IOException e) {
  	        	System.out.println("\n can not write");
    	      }
    	}
      
     }
    
}
