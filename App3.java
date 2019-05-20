
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author olga
 */
public class App3
{

    public static void main(String[] args)
    {
        List<Character> surname = new ArrayList<>();
        surname.add('O');
        surname.add('L');
        surname.add('G');
        surname.add('A');
        Map<Character, Integer> countLetters = new HashMap<>();

        for (Character a : surname)
        {

            char aLowerCase = Character.toLowerCase(a);
            Integer freq = countLetters.get(a);
            countLetters.put(aLowerCase, (freq == null) ? 1 : freq + 1);

        }
        System.out.println(countLetters.size() + " distinct letters");
        System.out.println(countLetters);

    }

}
