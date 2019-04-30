package ie.tudublin;

public class OrbitalView extends AbsUI
{
    Planet planet;
    DeepScan scan;
    Radar radar;

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
        planet.setUi2(this);
        radar = new Radar(this, 450, 400, 80, 80, 0.1f, 0);
    }

    public void draw()
    {
        background(0);
        planet.renderOrbit(150, 0, 350);
        drawGrid(150, 0, 350, 12);

        scan.render();
        scan.update();
        if(scan.isScanned())
        {
            planet.setDeepScaned(true);
        }
        radar.render();
        radar.update();
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

    /**
     * @return the planet
     */
    public Planet getPlanet() {
        return planet;
    }

    /**
     * @param planet the planet to set
     */
    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    /**
     * @return the scan
     */
    public DeepScan getScan() {
        return scan;
    }

    /**
     * @param scan the scan to set
     */
    public void setScan(DeepScan scan) {
        this.scan = scan;
    }
}