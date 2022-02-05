package com.pavel.patterns.services.patterniterator;

import com.pavel.patterns.services.patterniterator.itterator.MyItterator;

import java.util.ArrayList;
import java.util.Iterator;

public class ItteratorApplication {
    public static void main(String[] args) {

        // Иттератор средствами Java core

        ArrayList<String> arrItterator = new ArrayList<>();

        arrItterator.add("test1");
        arrItterator.add("test2");
        arrItterator.add("test3");

        Iterator<String> iterator = arrItterator.iterator();

        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }


        // Мой иттератор
        String[] strArray = {"quest1", "quest2", "quest3"};

        MyItterator<String> myItterator = new MyItterator<>(strArray);

        while (myItterator.hasNext()){
            System.out.println(myItterator.next());
        }


        class Testcl{
            public String newMethod(){
                return "testtt";
            }
        }

        Object q = new Testcl();



        System.out.println(( (Testcl) q ).newMethod());





        Testcl one = new Testcl();
        Testcl two = new Testcl();
        Testcl three = new Testcl();

        Testcl[] testclArray = {one, two, three};

        MyItterator<Testcl> itterNew = new MyItterator<>(testclArray);

        while (itterNew.hasNext()){
            System.out.println(itterNew.next().newMethod());
        }

    }
}
