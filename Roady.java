package hh;

public enum Roady {
    HIGH("Высокая", 8), MIDDLE("Средняя", 4);

    private String name;
    private int length;

    Roady(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }
}
