package ru.smirnov.ukpo;

public class Main {

    public static void main(String[] args) {
        Gauss gauss = new Gauss();
        System.out.println(gauss.countTheMatrix(
                new Double[][]{{1., 2., 4.}, {2., 1., 2.82}}));
    }
}
