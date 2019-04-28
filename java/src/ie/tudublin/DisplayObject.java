package ie.tudublin;

import processing.core.PVector;

public class DisplayObject
{
    protected UI ui;
    protected float size;
    protected PVector pos = new PVector();

    public DisplayObject(UI ui, float size, float x, float y)
    {
        this.ui = ui;
        this.size = size;
        pos.x = x;
        pos.y = y;
    }

    public void render()
    {}

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

    /**
     * @return the size
     */
    public float getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(float size) {
        this.size = size;
    }

    /**
     * @return the pos
     */
    public PVector getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(PVector pos) {
        this.pos = pos;
    }
}