package hh;

import java.util.Random;

public class Main{
    public static void main(String[] args) {

        Actions[] action = {
                new Human("Борис", 8, 2),
                new Cat("Барсик", 5, 1),
                new Robot("Кико", 10, 3)
        };

        Barrier[] barriers = {
                new Road(Roady.HIGH),
                new Road(Roady.MIDDLE),
                new Wall(Walls.HIGH),
                new Wall(Walls.MIDDLE)
        };

        for (Actions actions: action) {
            for (Barrier barr: barriers) {
                if(barr.cross(actions)) break;
            }
        }
    }
}
