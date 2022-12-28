package hh;

public enum Walls {
    HIGH("Высокая", 5), MIDDLE("Средняя", 3);

    private String name;
    private int height;

    Walls(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }
}
