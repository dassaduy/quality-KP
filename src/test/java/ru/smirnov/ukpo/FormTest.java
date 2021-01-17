package ru.smirnov.ukpo;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormTest {

    @Test
    public void formTest1() {
        FrameFixture window;
        Form frame;
        frame = GuiActionRunner.execute(Form::new);
        window = new FrameFixture(frame);
        window.show();
        window.textBox("input").setText("1 23 5\n7 8 9");
        window.button("Calculation").click();
        assertEquals("1.092 0.17 ", window.textBox("res").text());
        window.cleanUp();
    }

    @Test
    public void formTest2() {
        Form frame = GuiActionRunner.execute(Form::new);
        FrameFixture window = new FrameFixture(frame);
        window.show();
        window.textBox("input").setText("1 23 5\n7");
        window.button("Calculation").click();
        assertEquals("Данные некорректны", window.textBox("res").text());
        window.cleanUp();
    }

    @Test
    public void formTest3() {
        Form frame = GuiActionRunner.execute(Form::new);
        FrameFixture window = new FrameFixture(frame);
        window.show();
        window.textBox("input").setText("test test 23 5\n1 23 5");
        window.button("Calculation").click();
        assertEquals("Данные некорректны", window.textBox("res").text());
        window.cleanUp();
    }
}
