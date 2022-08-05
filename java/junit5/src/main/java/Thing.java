import java.util.ArrayList;
import java.util.List;

public class Thing {

    public int add(String numbers){

        int result = 0;
        String delimiter = "[,\n]";
        String[] zahlen;
        List<String> negatives = new ArrayList<>();

        if(numbers.equals("")){
            return result;
        }
        if(numbers.startsWith("//")){
            String[] konfiguartionen = numbers.split("[//\n]");
            delimiter = konfiguartionen[2];
            numbers = konfiguartionen[3];   
        }

        zahlen = numbers.split(delimiter);

        for(String zahl: zahlen){
            int number = Integer.parseInt(zahl);
            
            if(number < 0){
                negatives.add(zahl);
            } else{
                result += number;
            }

        }

       // if(notEmpty(negatives))

        return result;
    }
}
