package ru.smirnov.ukpo;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class FormTest {
    private FrameFixture window;
    String message = new String("Данные некорректны".getBytes(), StandardCharsets.UTF_8);

    @Before
    public void setUp() {
        var frame = GuiActionRunner.execute(Form::new);
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
    }

    @Test
    public void formTest1() {

        window.textBox("input").setText("1 23 5\n7 8 9");
        window.button("Calculation").click();
        assertEquals("1.092 0.17 ", window.textBox("res").text());
    }

    @Test
    public void formTest2() {
        window.textBox("input").setText("1 23 5\n7");
        window.button("Calculation").click();
        assertEquals(message, window.textBox("res").text());
    }

    @Test
    public void formTest3() {
        window.textBox("input").setText("test test 23 5\n1 23 5");
        window.button("Calculation").click();

        assertEquals(message, window.textBox("res").text());
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }
}
