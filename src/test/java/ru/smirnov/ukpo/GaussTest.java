package ru.smirnov.ukpo;


import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GaussTest {

    private static Gauss gauss;

    @BeforeClass
    public static void setUpOnce() {
        gauss = new Gauss();
    }


    @Test
    public void testBlackBox1() {
        Double[][] testM1 = {
                {6., 9., 4., 6.},
                {2., 9., 4., 11.},
                {5., 7., 4., 1.}
        };
        String result1 = "-1.25 3.125 -3.656 ";
        assertEquals(result1, gauss.countTheMatrix(testM1));
    }

    @Test
    public void testBlackBox2() {
        Double[][] testM2 = {
                {1., 2.}
        };
        String result2 = "2.0 ";
        assertEquals(result2, gauss.countTheMatrix(testM2));
    }

    @Test
    public void testBlackBox3() {
        Double[][] testM3 = {
                {4.76, -105.6}
        };
        String result3 = "-22.185 ";
        assertEquals(result3, gauss.countTheMatrix(testM3));
    }

    @Test
    public void testBlackBox4() {
        Double[][] testM4 = {
                {0., 1.}
        };
        String result4 = "Infinity ";
        assertEquals(result4, gauss.countTheMatrix(testM4));
    }

    @Test
    public void testBlackBox5() {
        Double[][] testM5 = {
                {0., -1.}
        };
        String result5 = "-Infinity ";
        assertEquals(result5, gauss.countTheMatrix(testM5));
    }

    @Test
    public void testBlackBox6() {
        Double[][] testM6 = {
                {0., 0.}
        };
        String result6 = "NaN ";
        assertEquals(result6, gauss.countTheMatrix(testM6));
    }

    @Test
    public void testBlackBox7() {
        Double[][] testM7 = {
                {-Double.MAX_VALUE, Double.MAX_VALUE}
        };
        String result7 = "-1.0 ";
        assertEquals(result7, gauss.countTheMatrix(testM7));
    }

    @Test
    public void testBlackBox8() {
        Double[][] testM8 = {
                {0.1, Double.MAX_VALUE}
        };
        String result8 = "Infinity "; // по идее это не inf, но нас не интересует корректная работа со сверх большими числами
        assertEquals(result8, gauss.countTheMatrix(testM8)); // + но нам важно знать, что такие данные не приведут к аварийному завершению
    }
}