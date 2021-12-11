package lambda.lesson1;

public class Main {

    public static void main(String[] args) {
	new Thread(()-> System.out.println("Printing for runnable")).start();
    }
}
