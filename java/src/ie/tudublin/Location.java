package ie.tudublin;

public class Location
{
    UI ui;
    int height;
    int width;

    public Location(UI ui, int height, int width)
    {
        this.ui = ui;
        this.height = height;
        this.width = width;
    }

    public void drawMainScreen()
    {
        ui.line(0, 0, 100, 100);
        /*for(int i=0; i<height/1.5f; i+=3)
        {
            float B = UI.map(i, 0, height/1.5f, 255, 0);
            ui.stroke(205, 200, B);
            ui.line(0, i, ui.width, i);
        }*/
    }

    /**
     * @return the ui
     */
    public UI getUi() {
        return ui;
    }

    /**
     * @param ui the ui to set
     */
    public void setUi(UI ui) {
        this.ui = ui;
    }
}