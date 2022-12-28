package hh;

public class Road implements Barrier{
    private int length;

    public Road(Roady roady) {
        this.length= roady.getLength();
        System.out.println("Беговая дорожка длина: " + this.length + " м");
    }
    @Override
    public boolean cross(Actions action){
        action.run(length);

        return false;
    }
}
