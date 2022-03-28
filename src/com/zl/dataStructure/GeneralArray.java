package com.zl.dataStructure;

public class GeneralArray<T> {

    private T[] data;

    private int size;


    public GeneralArray(int capacity){
        this.data = (T[])new Object[capacity];
        this.size = capacity;
    }

    //无参构造方法。添加默认大小
    public GeneralArray(){
        this(10);
    }

    public int getSize(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void set(int index,T e){
        checkIndex(index);
        data[index] = e;
    }

    public T get(int index){
        checkIndex(index);
        return data[index];
    }

    public int find (T e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return i;
            }
        }
        return  -1;
    }

    public boolean contain(T e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    public void add(int index , T e){
        checkIndex(index);
        if(size == data.length){
            resize(2* data.length);
        }
        for(int i = size - 1; i >= index;i --){
            data[i+1] = data[i];
        }
        data[index]=e;
        ++size;
    }

    public void addFirst(T e){
        add(0,e);
    }

    public void addLast(T e){
        add(size,e);
    }

    public T remove(int index){
        checkIndexForRemove(index);
        T removeData = data[index];
        for(int i = index+1 ;i < size; i++){
            data[i-1]=data[i];
        }
        size--;
        data[size] = null;

        if(data.length/4 == size && data.length /2 != 0){
            resize(data.length/2);
        }

        return removeData;
    }

    public T removeFirst(){
        return remove(0);
    }

    public T removeLast(){
        return remove(size -1);
    }


    private void resize(int capacity){


        T[] newData =(T[]) new Object[capacity];
        for(int i = 0; i< size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    private void checkIndex(int index){
        if(index < 0 || index > size){
            throw new RuntimeException("Illegal index!");
        }
    }

    private void checkIndexForRemove(int index){
        if(index < 0 || index >= size){
            throw new RuntimeException("Illegal index!");
        }
    }
}
