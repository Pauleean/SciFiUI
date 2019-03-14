package ie.tudublin;

public class Radar
{
    private float x;
    private float y;
    private float width;
    private float height;
    private float rotationSpeed;
    private float rotation;
    private UI ui;

    public Radar(UI ui, float x, float y, float width, float height, float rotationSpeed, float rotation)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rotationSpeed = rotationSpeed;
        this.rotation = rotation;
    }


    public void render()
    {
        float wRad = width/2.0f;
        float hRad = height/2.0f;
        ui.stroke(255);
        ui.noFill();
        ui.ellipse(x, y, width, height);
        ui.line(x, y, x + (wRad * (float)Math.sin(rotation)), y - (hRad * (float)Math.cos(rotation)));
    }

    public void update()
    {
        rotation = (rotation + rotationSpeed) % 6.28f;
    }


    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * @return the width
     */
    public float getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(float width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public float getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * @return the rotationSpeed
     */
    public float getRotationSpeed() {
        return rotationSpeed;
    }

    /**
     * @param rotationSpeed the rotationSpeed to set
     */
    public void setRotationSpeed(float rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }

    /**
     * @return the rotation
     */
    public float getRotation() {
        return rotation;
    }

    /**
     * @param rotation the rotation to set
     */
    public void setRotation(float rotation) {
        this.rotation = rotation;
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