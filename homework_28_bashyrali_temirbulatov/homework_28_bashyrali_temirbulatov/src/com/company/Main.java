package com.company;

public class Main {

    public static void main(String[] args) {
                MyList<String> ll = new MyList<>();
                var a = ll.addItem("AAA");
                System.out.println(a.getPrev());
                System.out.println(a.getPrev());
                System.out.println(a.getPrev());

//                System.out.println(ll.getFirst().getData());
//                System.out.println(ll.getLast().getData());
//                System.out.println("____");
//                while (a.hasNext()){
//                    System.out.println(a.getData());
//                    a = a.getNext();
//                    if(a == ll.getLast())
//                        System.out.println(a.getData());
//
//                }

        }
}
