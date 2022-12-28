package hh;

public class Wall implements Barrier {
    protected int heigth;

    public Wall(Walls walls) {
        this.heigth = walls.getHeight();
        System.out.println("Стена высота: " + this.heigth + " м" );
    }

    @Override
    public boolean cross(Actions action){
        action.jump(heigth);

        return false;
    }


}
