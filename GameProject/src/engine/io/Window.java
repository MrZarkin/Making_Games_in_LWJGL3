package engine.io;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;

public class Window {
    
    private int height, width;
    private String title;
    private long window;
    public int frames;
    public static long time;

    public Window(int height, int width, String title)
    {
        this.height = height;
        this.width = width;
        this.title = title;
    }

    public void create()
    {
        // Init glfw
        if(!GLFW.glfwInit())
        {
            System.out.println("ERR: Failed to load GLFW");
            return;
        }

        // Create window
        window = GLFW.glfwCreateWindow(width, height, title, 0, 0);

        if(window == 0)
        {
            System.out.println("ERR: Failed to create Window");
            return;
        }

        // Get primart monitor informations (width, height, refresh rate...) and center the window
        GLFWVidMode videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
		GLFW.glfwSetWindowPos(window, (videoMode.width() - width) / 2, (videoMode.height() - height) / 2);
		GLFW.glfwMakeContextCurrent(window);

        GLFW.glfwShowWindow(window);

        // VSync
        GLFW.glfwSwapInterval(1);

        time = System.currentTimeMillis();
    }

    public void update()
    {
        GLFW.glfwPollEvents();
        frames++;

		if (System.currentTimeMillis() > time + 1000)
        {
			GLFW.glfwSetWindowTitle(window, title + " | FPS: " + frames);
			time = System.currentTimeMillis();
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
