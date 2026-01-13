package engine.io;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;

public class Window
{
    private int width, height;
    private String title;
    private long window;
    public int frames;
	public static long times;

    public Window(int width, int height, String title)
    {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public void create()
    {
        if(!GLFW.glfwInit())
        {
            System.err.println("ERROR: GLFW wasn't inistializied");
            return;
        }

        window = GLFW.glfwCreateWindow(width, height, title, 0, 0);

        if(window == 0)
        {
            System.err.println("ERROR: Window wasn't initializied");
            return;
        }

        GLFWVidMode videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        GLFW.glfwSetWindowPos(window, (videoMode.width() - width) / 2, (videoMode.height() - height) / 2);
        GLFW.glfwMakeContextCurrent(window);

        GLFW.glfwShowWindow(window);

        GLFW.glfwSwapInterval(1);

        times = System.currentTimeMillis();
    }

    public void update()
    {
        GLFW.glfwPollEvents();
        
        frames++;
		if(System.currentTimeMillis() > times + 1000)
		{
			System.out.println(frames);
			times = System.currentTimeMillis();
			frames = 0;
		}
    }

    public void swapBuffers()
    {
        GLFW.glfwSwapBuffers(window);
    }

    public boolean shouldClose()
    {
        return GLFW.glfwWindowShouldClose(window);
    }

}