# 1. Setting up

### Summary 

- [Hierarchy](#hierarchy)
- [What do I do ?](#what-do-i-do-)
- [What is it used for?](#what-is-it-used-for-)
- [What should be the result ?](#What-should-be-the-result-)

##

### Hierarchy
What your hierarchy should look like at the end of this first tutorial
```
MyProject/
├── lib/ 
└── src/
    └── main/
        └── Main.java
```

##

### What do I do ?

- Create a folder named `main/` in your `src/` folder.
- Create a Main.java file in it.
- Copy/Past the code.

## 

### What is it used for ?

This code represents the minimal structure of a game loop in Java.
It uses a dedicated thread to run the game and separates the main steps:

- `init()` → Initialization
- `update()` → Update game logic
- `render()` → Display/rendering

```java
public class Main implements Runnable
```
The class implements Runnable, which allows it to be executed in a thread.
This allows the game loop to be launched independently, without blocking the application's main thread.

```java
public Thread game;
```
This variable will contain the thread responsible for running the game.

```java
public void start()
{
    game = new Thread(this, "game");
    game.start();
}
```
We create a thread and assign it the task of executing the run() method of this class. So `game.start()` launches the execution of the thread (therefore automatically calls run().)

```java
public static void init()
{
    System.out.println("Initializing Game!");
}
```
This is the initialization method.

Here we just want to send a message in the console (No window created at the time).

```java
private void update()
{
    System.out.println("Updating Game!");
}
```
Method whereby the game logic would be updated. 

Here we just want to send a message in the console.

```java
private void render()
{
    System.out.println("Updating Game!");
}
```
Method responsible for graphic rendering.

Here we just want to send a message in the console.

```java
public void run()
{
    init();
    while (true)
    {
        update();
        render();
    }
}
```
Call init() to prepare the game. Enter an infinite loop representing the game loop:
- `update()`: Call the update fonction (aka "Send a message in the console")
- `render()`: Call the render fonction (aka "Send a message in the console")

```java
public static void main(String[] args)
{
    new Main().start();
}
```
Creates an instance of the Main class
Launches the game thread via start()

##

### What should be the result ?

Normally, you should see the following in the console:
```
“Updating Game!”
“Rendering Game!”
“Updating Game!”
“Rendering Game!”
“Updating Game!”
“Rendering Game!”
...
```

And so on, indefinitely.