package logica;

import java.util.Objects;

public class Punt {
    private int x;
    private int y;

    public Punt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double berekenAfstand(Punt punt) {
        double a = Math.pow(punt.getX() - this.x, 2);
        double b = Math.pow(punt.getY() - this.y, 2);
        return Math.sqrt(a + b);
    }

    @Override
    public String toString() {
        return "Punt{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Punt punt = (Punt) o;
        return x == punt.x && y == punt.y;
    }
}
