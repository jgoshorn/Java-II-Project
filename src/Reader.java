import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;




public class Reader{
    String countryCodes = null;

    void readFile() throws IOException{
       try{
           ArrayList<String> ArrayList = new ArrayList<String>();

           File csvFile = new File("owid.csv");
           BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));

           String line ="";
           int num = 0;


           while((line = bufferedReader.readLine())!=null){
               String[] array = line.split(",");
               num++;
               countryCodes = array[1];
               System.out.println(countryCodes);

           }
           bufferedReader.close();
       } catch(IOException exception){
           exception.printStackTrace();
       }


       }

    } 
