package com.company;

public class MyNode<T>{
    private MyNode<T> next;
    private MyNode<T> prev;
    private T data;
    private int index;

    public MyNode(T data,MyNode<T> next, MyNode<T> prev,  int index) {
        this.data = data;
        this.next = next;
        this.prev = prev;
        this.index = index;
    }

    public T getData() {
        return data;
    }

    public MyNode<T> getNext() {
        return next;
    }

    public MyNode<T> getPrev() {
        return prev;
    }

    public void setNext(MyNode<T> next) {
        this.next = next;
    }

    public void setPrev(MyNode<T> prev) {
        this.prev = prev;
    }
    public boolean hasNext(){
        return this.next != null;
    }
    public boolean hasPrev(){
        return this.prev != null;
    }
}

