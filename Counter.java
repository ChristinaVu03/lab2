import java.io.PrintWriter;

public class Counter {
    public int count;

    // Zero-argument constructor initializes the counter to 0
    public Counter() {
        count = 0;
    }
    public Counter(int initial) {
        count = initial;
    }
    
    // Method to increment the counter by 1
    public void increment() {
        count++;
    }

    // Method to get the current value of the counter
    public int get() {
        return count;
    }
    //d. Create a toString method
    public String toString() {
          return Integer.toString(count);}

    // Method to reset the counter to the starting value
    public void reset(int initial) {
        count = initial;
    }

    public static void main(String[] args) {
        // Create two separate Counter objects
        PrintWriter pen = new PrintWriter(System.out, true);
        Counter c1 = new Counter(5);
        Counter c2 = new Counter();
        c1.increment();
        c2.increment();
        pen.println("c1: " + c1);
        pen.println("c2: " + c2);
         // Reset c2 to an initial value of 10
        c2.reset(10);
        System.out.println("c2 (after reset): " + c2.get()); // Output: c2 (after reset): 10
    }
}
//b. I expected that the program would print something like Counterhashcode.
//c. As I comment out the toString method, I get c1: Counter@7344699f, c2: Counter@6b95977
