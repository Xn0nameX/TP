package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        Integer arr1[] = {1, 2, 3, 4, 5, 6, 7};
        String arr2[] = {"A", "B", "C"} ;
        swap(arr1,1,4);
        swap(arr2,0,2);

        String[] arrayOfStrings = {"A", "B", "C", "D"};
        asList(arrayOfStrings);

        Box<Orange> or = new Box<>(new Orange(), new Orange());
        Box<Orange> or1 = new Box<>(new Orange());
        Box<Apple> ap = new Box<>(new Apple(), new Apple(), new Apple());
        Box<Apple> ap1 = new Box<>(new Apple());
        System.out.println("Задание 3");
        System.out.println("Добавить фрукты в коробки:");
        or.addFruit(2);
        or1.addFruit(3);
        or.addFruit(new Orange(), new Orange());
        or.addFruit(3, new Orange());
        ap.addFruit(4);
        ap1.addFruit(4);
        System.out.println("Коробка 1: "+or.getWeight());
        System.out.println("Коробка 2: "+or1.getWeight());
        System.out.println("Коробка 3: "+ap.getWeight());
        System.out.println("Коробка 4: "+ap1.getWeight());
        System.out.println("Сравнение коробок: ");
        System.out.println("Сравнить коробку 1 с коробкой 3: "+or.compare(ap));
        System.out.println("Сравнить коробку 2 с коробкой 4: "+or1.compare(ap1));
        System.out.println("Пересыпать из коробки 1 в коробку 2");
        or.pourTo(or1);
        System.out.println("Пересыпать из коробки 3 в коробку 4");
        ap.pourTo(ap1);
        System.out.println("Вес коробок: ");
        System.out.println("Коробка 1: "+or.getWeight());
        System.out.println("Коробка 2: "+or1.getWeight());
        System.out.println("Коробка 3: "+ap.getWeight());
        System.out.println("Коробка 4: "+ap1.getWeight());

        System.out.println("Содержимое коробки 2: ");
        ap1.Box_Context(ap1);
        System.out.println("Содержимое коробки 4: ");
        or1.Box_Context(or1);

    }
    public static void swap(Object[] arr, int n1, int n2){
        System.out.println("Задание 1: "+Arrays.toString(arr));
        Object sw = arr[n1];
        arr[n1]=arr[n2];
        arr[n2]=sw;
        System.out.println("Результат замены: "+Arrays.toString(arr)+"\n================================");
    }
    public static <T> void asList(T[]arr){
        ArrayList<T> alt = new ArrayList<>(Arrays.asList(arr));
        System.out.println("Задание 2 и результат замены: "+alt+"\n================================");
    }
}
