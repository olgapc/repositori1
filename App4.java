
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author olga
 */
public class App4
{

    public static void main(String[] args)
    {
        List<Character> surname = new ArrayList<>();
        surname.add('O');
        surname.add('L');
        surname.add('G');
        surname.add('A');

        List<Character> name = new ArrayList<>();
        name.add('P');
        name.add('E');
        name.add('R');
        name.add('E');
        name.add('Z');

        List<Character> fullName = new ArrayList<>();
        fullName.addAll(surname);
        fullName.add(' ');
        fullName.addAll(name);
        System.out.println(fullName);

    }

}
