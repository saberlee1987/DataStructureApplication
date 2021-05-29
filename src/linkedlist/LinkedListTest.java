package linkedlist;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addFirst(5);
        list.print();
        System.out.println("indexOf 20 === "+list.indexOf(20));
        System.out.println("contains 20 === "+list.contains(20));
        System.out.println("indexOf 5 === "+list.indexOf(5));
        System.out.println("indexOf 30 === "+list.indexOf(30));
        System.out.println("contains 30 === "+list.contains(30));
        System.out.println("indexOf 50 === "+list.indexOf(50));
        System.out.println("contains 50 === "+list.contains(50));
    }
}
