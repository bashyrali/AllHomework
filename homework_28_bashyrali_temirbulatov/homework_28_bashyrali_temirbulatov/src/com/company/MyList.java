package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class MyList<T> {
    private MyNode<T> first;
    private MyNode<T> last;
    private int count;

    public MyNode<T> getFirst() {
        return first;
    }

    public MyNode<T> getLast() {
        return last;
    }

    public MyList() {
        super();
        this.first = null;
        this.last = null;
        this.count = 0;
    }
    void getNext(){

    }
    public MyNode<T> addItem(T item) {
        if (item == null){
            throw new NullPointerException("NULL");
        }
        if (!isEmpty()){
            MyNode<T> prev = last;
            last = new MyNode<T>(item,null,null,count);
            prev.setNext(last);
            last.setPrev(prev);

        }
        else {
            last = new MyNode<T>(item,null,null,count);
            first = last;
        }
        count++;
        return last;
    }
    private boolean isEmpty(){
        return this.count==0;
    }
}
