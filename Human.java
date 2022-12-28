package hh;

public class Human implements Actions{
    protected String name;
    protected int runDistance;
    protected int jumpDistance;
    boolean result;
    public Human(String name,int runDistance,int jumpDistance) {
        this.name = name;
        this.runDistance = runDistance;
        this.jumpDistance = jumpDistance;
        this.result=true;
    }

    @Override
    public void run(int lenght) {
        if(result){
            if(runDistance<lenght){
                System.out.println("Человек "+this.name+" не пробежал");
                result=false;
                System.out.println("Человек выбыл из игры");
            }
            else{
                System.out.println("Человек "+this.name+" пробежал "+lenght + " м");
            }
        }
    }

    @Override
    public void jump(int height) {
        if(result){
            if(jumpDistance<height){
                System.out.println("Человек "+this.name+" не перепрыгнул");
                result=false;
                System.out.println("Человек выбыл из игры");
            }
            else{
                System.out.println("Человек "+this.name+" перепрыгнул");
            }

        }
    }

}
