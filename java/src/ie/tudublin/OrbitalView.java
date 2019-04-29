package ie.tudublin;

public class OrbitalView extends AbsUI
{
    Planet planet;
    DeepScan scan;

    public OrbitalView(Planet planet)
    {
        this.planet = planet;
    }

    public void settings()
    {
        size(500, 500);
    }

    public void setup()
    {
        stroke(0, 150, 0);
        fill(0, 150, 0);
        noFill();
        scan = new DeepScan(this, 150, 0, 400, 450, 350, 100, 50);
        textAlign(CENTER);
    }

    public void draw()
    {
        background(0);
        image(planet.getImg(), 150, 0, 350, 350);
        drawGrid(150, 0, 350, 12);

        scan.render();
        scan.update();
        //rect(400, 450, 100, 50);
        
    }

    public void drawGrid(float x, float y, float len, float num)
    {
        strokeWeight(3);
        rect(x, y, len, len);
        strokeWeight(1);

        for(int i = 0; i < 12; i++)
        {
            float X = map(i, 0, num, x, x+len);
            float Y = map(i, 0, num, y, y+len);

            line(X, y, X, y+len);
            line(x, Y, x+len, Y);
        }
    }

    public void mousePressed()
    {
        if(mouseX > 400 && mouseY > 450) scan.startScan();
    }
}