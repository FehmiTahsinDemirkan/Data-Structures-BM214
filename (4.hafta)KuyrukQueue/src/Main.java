import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kelimeyi girin: ");
        String kelime = scanner.nextLine();

        // Queue ve Stack veri yapıları oluşturuluyor
        LinkedList<Character> queue = new LinkedList<Character>();
        Stack<Character> stack = new Stack<Character>();

        // Kelime içindeki harfler Queue ve Stack'e ekleniyor
        for (int i = 0; i < kelime.length(); i++) {
            char harf = kelime.charAt(i);
            stack.push(harf);
            queue.addLast(harf);
        }

        // Stack yapısı ekrana yazdırılıyor
        System.out.println("Kelimenin harfleri stack yapısı olarak:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        // Queue yapısı ekrana yazdırılıyor
        System.out.println("Kelimenin harfleri queue yapısı olarak:");
        while (!queue.isEmpty()) {
            System.out.println(queue.removeFirst());
        }

        // Kelimenin polindrom olup olmadığı kontrol ediliyor
        boolean polindrom = true;
        while (!stack.isEmpty() && !queue.isEmpty()) {
            char harfStack = stack.pop();
            char harfQueue = queue.removeFirst();

            if (harfStack != harfQueue) {
                polindrom = false;
                break;
            }
        }

        // Polindrom kontrol sonucu ekrana yazdırılıyor
        if (polindrom) {
            System.out.println(kelime + " bir polindromdur.");
        } else {
            System.out.println(kelime + " bir polindrom değildir.");
        }
    }
}
