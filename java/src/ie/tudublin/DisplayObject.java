package ie.tudublin;

import processing.core.PVector;

public abstract class DisplayObject
{
    protected AbsUI ui;
    protected float size;
    protected PVector pos = new PVector();

    public DisplayObject(AbsUI ui, float size, float x, float y)
    {
        this.ui = ui;
        this.size = size;
        pos.x = x;
        pos.y = y;
    }

    public abstract void render();

    public abstract void update();

    /**
     * @return the ui
     */
    public AbsUI getUi() {
        return ui;
    }

    /**
     * @param ui the ui to set
     */
    public void setUi(AbsUI ui) {
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