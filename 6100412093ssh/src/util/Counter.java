package util;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
public class Counter {
	public static void writeFile(int count){
        
        try{
            PrintWriter  out=new PrintWriter("count.txt");
            out.println(count);
            out.close();
        }catch(IOException e){
             e.printStackTrace();
        }
    }
    
    public static int readFile() {
        File f = new File("count.txt");
        int count = 0;
        if(!f.exists()){
             writeFile(0);
        }
        try{
            BufferedReader in = new BufferedReader(new FileReader(f));
            try{
                count = Integer.parseInt(in.readLine());    
            }catch(NumberFormatException e){
                e.printStackTrace();    
        }catch(IOException  e){
            e.printStackTrace();
             }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
            }
        return count;
    }
}
