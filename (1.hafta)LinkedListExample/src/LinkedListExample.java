import java.util.Scanner;

public class LinkedListExample {

    static Node head;
    // Bağlı listenin başlangıç düğümü

    static class Node {
        String data;
        Node next;

        Node(String d) {
            data = d;
            next = null;
        }
    }

    // Bağlı listeye veri ekleme işlemi
    static void addNode(String data) {
        Node newNode = new Node(data);
        newNode.next = null;

        if (head == null) { // Bağlı liste boş ise
            head = newNode; // Yeni düğümü başlangıç düğümü olarak ata
        } else { // Bağlı liste dolu ise
            Node last = head;
            while (last.next != null) { // Listenin sonuna git
                last = last.next;
            }
            last.next = newNode; // Son düğümün next değeri olarak yeni düğümü ekle
        }
    }

    // Bağlı listeden veri silme işlemi
    static void deleteNode(int index) {
        if (head == null) { // Bağlı liste boş ise
            System.out.println("Bağlı liste boş");
            return;
        }

        Node temp = head;

        if (index == 0) { // İlk düğümü silmek istenirse
            head = temp.next; // İkinci düğümü başlangıç düğümü olarak ata
            return;
        }

        for (int i = 0; temp != null && i < index - 1; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) { // Geçersiz indeks kontrolü
            System.out.println("Geçersiz indeks");
            return;
        }

        Node next = temp.next.next;
        temp.next = next; // Silinecek düğümü atla ve sonraki düğüme bağlan
    }

    // Bağlı listenin eleman sayısını döndürme işlemi
    static int countNodes() {
        int count = 0;
        Node temp = head;
        while (temp != null) { // Listenin sonuna kadar döngü
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Bağlı listeyi tersten yazdırma işlemi
    static void printListReverse(Node head) {
        if (head == null) {
            return;
        }
        printListReverse(head.next); // Listenin sonuna kadar recursive çağrı
        System.out.print(head.data + " "); // Veriyi yazdır
    }

    // Bağlı listede bir elemanın bulunduğu indeksi döndürme işlemi
    static int findNode(String data) {
        int index = 0;
        Node temp = head;
        while (temp != null) { // Listenin sonuna kadar döngü
            if (temp.data.equals(data)) { // Aranan veriyi bulursa
                return index; // Verinin bulunduğu indeksi döndür
            }
            index++;
            temp = temp.next;
        }
        return -1; // Veri bulunamazsa -1 döndür
    }




    // Ana yöntem (main method)
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Lütfen bir işlem seçin:");
            System.out.println("a) Bağlı listeye veri ekleme");
            System.out.println("b) Bağlı listeden veri silme");
            System.out.println("c) Bağlı listenin eleman sayısını döndürme");
            System.out.println("d) Bağlı listeyi tersten yazdırma");
            System.out.println("e) Bağlı listede bir elemanın bulunduğu indeksi döndürme");
            System.out.println("q) Çıkış");

            String choice = input.nextLine();

            switch (choice) {
                case "a":
                    System.out.println("Lütfen bir veri girin:");
                    String data = input.nextLine();
                    addNode(data);
                    break;
                case "b":
                    System.out.println("Lütfen silmek istediğiniz verinin indeksini girin:");
                    int index = input.nextInt();
                    deleteNode(index);
                    break;
                case "c":
                    int count = countNodes();
                    System.out.println("Bağlı listenin eleman sayısı: " + count);
                    break;
                case "d":
                    System.out.println("Bağlı listenin elemanları ters sırada:");
                    printListReverse(head);
                    System.out.println();
                    break;
                case "e":
                    System.out.println("Lütfen aranacak veriyi girin:");
                    String searchData = input.nextLine();
                    int searchIndex = findNode(searchData);
                    if (searchIndex == -1) {
                        System.out.println("Aradığınız veri bulunamadı");
                    } else {
                        System.out.println(searchData + " listede " + (searchIndex + 1) + ". sırada");
                    }
                    break;
                case "q":
                    System.out.println("Program sonlandırıldı");
                    return;
                default:
                    System.out.println("Geçersiz seçim");
            }
        }
    }
}
