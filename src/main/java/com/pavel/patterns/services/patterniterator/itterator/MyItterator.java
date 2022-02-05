package com.pavel.patterns.services.patterniterator.itterator;

public class MyItterator<T> implements ItteratorInterface {
    private T[] objects;
    private int i;

    public MyItterator(T[] tArr){
        objects = tArr;
    }

    public boolean hasNext(){
        if(i < objects.length){
            return true;
        }else {
            return false;
        }
    }

    public T next(){
        if (!hasNext()) {
            return null;
        }
        return objects[i++];
    }

    public void reset(){
        i = 0;
    }
}
