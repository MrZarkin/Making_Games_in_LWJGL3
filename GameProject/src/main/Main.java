package main;

import engine.io.Window;

public class Main implements Runnable
{
    public Thread game;
    public static Window window;
    public static final int WIDTH = 1280, HEIGHT = 760;

    public void start()
    {
        game = new Thread(this, "game");
        game.start();
    }

    public void init()
    {
        System.out.println("The game is starting");
        window = new Window(HEIGHT, WIDTH, "Game Name");
        window.create();
    }

    public void run()
    {
        init();
        while(!window.shouldClose())
        {
            update();
            render();
        }
    }

    public void update()
    {
        window.update();
    }

    public void render()
    {
        window.swapBuffers();
    }


    public static void main(String[] args)
    {
        new Main().start();
    }
}
