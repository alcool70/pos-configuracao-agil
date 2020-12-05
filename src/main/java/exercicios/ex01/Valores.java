package exercicios.ex01;

public class Valores implements ValoresITF {

    private final int[] values = new int[10];

    @Override
    public boolean ins(int v) {
        int i = pos();
        if (v > 0 && i < 10) {
            values[i] = v;
            return true;
        }
        return false;
    }

    private int pos() {
        int i = 0;
        while (values[i] != 0) i++;
        return i;
    }

    @Override
    public int del(int i) {
        int v;
        if (size() > 0 &&
                i >= 0 && i < 10 &&
                values[i] > 0) {
            v = values[i];
            values[i] = 0;
            return v;
        }
        return -1;
    }

    @Override
    public int size() {
        int size = 0;
        for (int value : values) if (value > 0) size++;
        return size;
    }
}
