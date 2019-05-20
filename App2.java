
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author olga
 */
public class App2
{

    public static void main(String[] args)
    {
        List<Character> surname = new ArrayList<>();
        surname.add('O');
        surname.add('L');
        surname.add('G');
        surname.add('A');
        surname.add('2');

        for (Character a : surname)
        {
            char aLowerCase = Character.toLowerCase(a);

            if (!Character.isLetter(a))
            {
                System.out.println("Els noms de persones no contenen números: " + aLowerCase);
            } else if (aLowerCase == 'a'
                    || aLowerCase == 'e'
                    || aLowerCase == 'i'
                    || aLowerCase == 'o'
                    || aLowerCase == 'u')

            {
                System.out.println("VOCAL : " + aLowerCase);
            } else
            {
                System.out.println("CONSONANT : " + aLowerCase);
            }
        }

    }

}
