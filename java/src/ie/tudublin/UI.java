package ie.tudublin;

import processing.core.PApplet;

public class UI extends PApplet
{
    Button b;
    MovingCircle mc;
    Radar r;
    Scanner s;
    boolean mouseDown;

    boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = true;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    

    public void settings()
    {
        size(800, 800);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(); 
    }

    public void setup()
    {
        b = new Button(this, 50, 50, 100, 50, "I am a button");
        mc = new MovingCircle(this, width / 2, height / 2, 50);
        r = new Radar(this, width/2, height/2, 350, 50, 0.1f, 0);
        s = new Scanner(this, 100);
        colorMode(HSB);
    }

    public void draw()
    {
        background(0);
        b.render();

        mc.update();
        mc.render();

        r.update();
        r.render();
        
        if(mouseDown)
        {
            s.update(mouseX, mouseY, "a", 4);
        }
        s.render();

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }

    public void mousePressed()
    {
        mouseDown = true;
    }

    public void mouseClicked()
    {
        mouseDown = false;
        s.end();
    }
}

