import java.util.ArrayList;

public class Iteration
{
    public ArrayList<Integer> fibonacci(int n)
    {
        // to store all the fibonacci sequence #
        ArrayList<Integer> fibs = new ArrayList<Integer>();

        int fib = 0;
        int prevFib = 1;

        for (int i = 0; i <= n; i++)
        {
            fibs.add(fib);
            int temp = fib;
            fib += prevFib;
            prevFib = temp;
        }

        return fibs;
    }
}