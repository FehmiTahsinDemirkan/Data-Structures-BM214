//Ana s�n�f
// Çift bağlı dairesel liste için bir düğüm sınıfı oluşturulur.
class Node {
    int data; // Düğümün içerisindeki veri.
    Node prev; // Önceki düğümü gösteren referans.
    Node next; // Sonraki düğümü gösteren referans.

    // Düğüm nesnesi oluşturmak için kullanılan constructor.
    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
public class Main {
    public static void main(String[] args) {
        DoublyCircularLinkedList list = new DoublyCircularLinkedList();

        // 1'den 100'e kadar olan say�lar s�rayla listenin sonuna eklenir.
        for (int i = 1; i <= 100; i++) {
            list.add(i);
            System.out.println(i);
        }
    }
}
// Çift bağlı dairesel liste sınıfı oluşturulur.
class DoublyCircularLinkedList {
    Node head; // Listenin başlangıç düğümü.
    Node tail; // Listenin son düğümü.

    // Listenin sonuna eleman ekleyen metod.
    public void add(int data) {
        Node newNode = new Node(data);

        // Liste boş ise yeni düğüm başlangıç ve son düğüm olarak atanır.
        if (head == null) {
            head = tail = newNode;
            newNode.prev = tail;
            newNode.next = head;
        }
        // Liste dolu ise yeni düğüm sona eklenir.
        else {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
            tail = newNode;
        }
    }
}