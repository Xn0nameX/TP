package com.example.demo;

import java.util.ArrayList;

public class Box <T extends Fruit>  {

    private ArrayList<T> box = new ArrayList<>();


    public Box(T...x) {
        for (T y:x ) {
            box.add(y);
        }
    }



    public float getWeight(){
        float weight = 0.0f;
        for (T o: box) {
            weight += o.getWeight();
        }
        return weight;
    }
    public boolean compare(Box<Apple> anotherBox) {
        if(getWeight() == anotherBox.getWeight()) return true;
        return false;
    }
    public void pourTo(Box <T>anotherBox){
        anotherBox.box.addAll(box);
        box.clear();
    }
//
    public void addFruit(int amount) throws InstantiationException, IllegalAccessException {
        Class someClass=box.get(0).getClass();
        while(amount!=0){
            box.add((T) someClass.newInstance());
            amount--;
        }
    }

    public void addFruit(T...x){
        for (T y:x ) {
            box.add(y);
        }
    }
    public void addFruit(int amount, T fruit){
        for(int i=0;i<amount;i++){
            box.add(fruit);
        }
    }
    public void Box_Context(Box<T> box){
        for(int i=0;i<box.box.size();i++){
            System.out.println(box.box.get(i));
        }
    }

}
