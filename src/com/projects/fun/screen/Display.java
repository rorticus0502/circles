package com.projects.fun.screen;

import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.GREEN;
import static java.awt.Color.MAGENTA;
import static java.awt.Color.RED;
import static java.awt.Color.YELLOW;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;

public class Display extends JFrame {

  private static Map<Integer, Color> colorMap = new HashMap<>();

  private boolean isFirst = true;

  public static void main(String[] args) {

    colorMap.put(1, RED);
    colorMap.put(2, GREEN);
    colorMap.put(3, YELLOW);
    colorMap.put(4, BLUE);
    colorMap.put(5, MAGENTA);


    Display display = new Display();
    display.setDefaultCloseOperation(EXIT_ON_CLOSE);
    display.setSize(1000, 700);

    display.setVisible(true);

    for (int i = 0; i < 800; i++) {
      shortPause();
      display.repaint();
    }

  }

  private static void shortPause() {
    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void paint(Graphics graphics) {

    if(isFirst) {
      graphics.setColor(BLACK);
      graphics.fillRect(0, 0, 1000, 700);
      isFirst = false;
    }

    drawRandomCircle(graphics);
  }

  private void drawRandomRectangle(Graphics g) {

    g.setColor(generateRandomColor());

    int x = generateRandomInteger(50, 950);
    int y = generateRandomInteger(50, 650);
    int width = generateRandomInteger(20, 110);
    int height = generateRandomInteger(20, 110);

    g.fillRect(x, y, width, height);
  }

  private void drawRandomCircle(Graphics g) {

    g.setColor(generateRandomColor());

    int x = generateRandomInteger(50, 950);
    int y = generateRandomInteger(50, 650);
    int width = generateRandomInteger(20, 110);
    int height = generateRandomInteger(20, 110);

    g.fillOval(x, y, width, height);
  }

  private Color generateRandomColor() {

    return colorMap.get(generateRandomInteger(1, 5));
  }

  private int generateRandomInteger(int min, int max) {

    int range = max - min;
    double floatingValue = Math.random() * range;
    return Long.valueOf(Math.round(floatingValue)).intValue() + min;
  }

}
