import java.util.ArrayList;
import java.util.Collections;

public class Main
{
    public static void main(String[] args)
    {
        Iteration fibIterator = new Iteration();
        ArrayList<Integer> fibList = fibIterator.fibonacci(10);

        for (int i = 0; i < fibList.size(); i++)
        {
            // output
            String fibFormat = i + " => " + fibList.get(i);

            // gets the length of the output
            int length = fibFormat.length();

            // prints output
            System.out.println(fibFormat);

            // prints output with "-" under it
            System.out.println(String.join("", Collections.nCopies(length, "-")));
        }
    }
}
