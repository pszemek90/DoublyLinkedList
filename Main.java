package sda._200523.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        StringList list = new StringList();
        list.add("Ala");
        list.add("ma");
        list.add("kota");
        list.print();
        list.remove("kota");
        list.print();
        list.add("kota");
        list.print();
        list.addAt("rudego", 2);
        list.print();
    }
}
