package lesson1.balls;

import lesson1.common.GameCanvas;
import lesson1.common.GameObject;
import lesson1.common.Sprite;

import java.awt.*;

public class Background implements GameObject {
    private float time;
    private Color color;
    private final float AMPLITUDE = 255f / 2f;

    @Override
    public void update(GameCanvas canvas, float deltaTime) {
        time += deltaTime;
        int red = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 3));
        int blue = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 2));
        int green = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time));
        color = new Color(red, green, blue);
    }

    @Override
    public void render(GameCanvas canvas, Graphics g) {
        canvas.setBackground(color);
    }
}
