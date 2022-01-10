package tfip.ssf.Workshop13.helper;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.catalina.connector.Response;


public class helper{


    public static String generateID(int number){

        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
    
        String generatedString = random.ints(leftLimit, rightLimit + 1)
          .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
          .limit(targetStringLength)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();
    
        return generatedString;
}

    public static Boolean createFile(String s,List<String> details){
        String filepath = s + ".txt";
        try {
            FileWriter writer = new FileWriter(filepath, StandardCharsets.UTF_8);
            for(String str :details){
                writer.write(str + System.lineSeparator());
            }
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static List<String> readFiles(String string){
        String FilePath = System.getProperty("user.dir")+"\\"+string+".txt";
        System.out.println(FilePath);
        Path filepath = Paths.get(FilePath);
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(filepath,StandardCharsets.UTF_8);
        }catch (IOException e){
        
        }
        return lines;
    }



}
    


