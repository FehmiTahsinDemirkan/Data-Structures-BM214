import java.util.Scanner;
import java.util.Stack;

public class StackOdev {
    public static void main(String[] args) {
        // Kullanıcıdan yığın boyutu istenir
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen Yığının boyutunu giriniz: ");
        int size = input.nextInt();

        // Yığına eleman eklenir
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < size; i++) {
            System.out.print("Lütfen Yığının "+(i+1)+ ". elemanını giriniz: ");
            int element = input.nextInt();
            stack.push(element);
        }

        // Yığından eleman çıkarma işlemi yapılır
        System.out.print("Lütfen Yığından çıkarmak istediğiniz elemanı giriniz: ");
        int popElement = input.nextInt();

        // Yığında aranan elemanın konumu bulunur
        int index = stack.search(popElement);
        if (index == -1) {
            System.out.println("Yığında aradığınız eleman yok.");
        } else {
            // Yığından eleman çıkarılır ve çıkarma işlemi sonrası yığın yazdırılır
            int pop = stack.remove(index-1);
            System.out.println("Yığından çıkarılan eleman: " + pop);
            System.out.println("Yığın: " + stack);
        }

        // Yığının ilk ve son elemanlarının yerleri değiştirilir
        swapFirstAndLast(stack);

        // Yığın yazdırılır
        System.out.println("Yığının ilk ve son elemanları yer değiştirildiğinde sonuç : " + stack);

        // Scanner kaynağı kapatılır
        input.close();
    }

    // Yığının ilk ve son elemanlarının yerlerini değiştiren metod
    public static void swapFirstAndLast(Stack<Integer> stack) {
        if (stack.size() >= 2) {
            int ilk = stack.firstElement();
            int son = stack.lastElement();
            stack.setElementAt(son, 0);
            stack.setElementAt(ilk, stack.size()-1);
        }
    }
}
