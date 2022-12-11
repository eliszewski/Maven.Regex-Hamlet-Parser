import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }
    // " Hamlet "
    public String getHamletData(){
        return hamletData;
    }

    public boolean findHamlet(String text){
        Pattern ham = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        Matcher m = ham.matcher(text);
        return m.find();
    }
    public boolean findHoratio(String text){
        Pattern ham = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        Matcher m = ham.matcher(text);
        return m.find();
    }
    public StringBuffer replaceHoratio(){
        StringBuffer sb = new StringBuffer();
        Pattern ham = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        Matcher matcher = ham.matcher(hamletData);

        while(matcher.find()){
            matcher.appendReplacement(sb,"Tariq");
        }
        return sb;
    }
    public StringBuffer replaceHamlet(){
        StringBuffer sb = new StringBuffer();
        Pattern ham = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        Matcher matcher = ham.matcher(hamletData);

        while(matcher.find()){
            matcher.appendReplacement(sb,"Leon");
        }
        return sb;
    }


}
