package Music_System;

import java.util.LinkedList;
import java.util.ListIterator;

public class LL {
    public static void main(String[] args) {
        LinkedList<Integer> ll=new LinkedList<>();
        ll.add(10);
        ll.add(20);//10 20 30
        ll.add(30);
        ListIterator<Integer> l=ll.listIterator();
        System.out.println(l.hasPrevious());
        l.next();
        System.out.println(l.previous());//0th ele has false,1st ele has NoxuchElemenr

    }
}
