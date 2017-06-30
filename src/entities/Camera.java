package entities;

import org.joml.Vector3f;
import renderEngine.DisplayManager;

import static org.lwjgl.glfw.GLFW.*;

public class Camera {

    private Vector3f position = new Vector3f(0,0,0);
    private float pitch;
    private float yaw;
    private float roll;

    public Camera() {

    }

    public void move() {

        int multiplier = 1;

        if (DisplayManager.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
            multiplier = 10;
        }
        if (DisplayManager.isKeyPressed(GLFW_KEY_A)) {
            position.x -= 0.25f * multiplier;
        }
        if (DisplayManager.isKeyPressed(GLFW_KEY_D)) {
            position.x += 0.25f * multiplier;
        }
        if (DisplayManager.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
            position.y -= 0.25f * multiplier;
        }
        if (DisplayManager.isKeyPressed(GLFW_KEY_SPACE)) {
            position.y += 0.25f * multiplier;
        }
        if (DisplayManager.isKeyPressed(GLFW_KEY_W)) {
            position.z -= 0.25f * multiplier;
        }
        if (DisplayManager.isKeyPressed(GLFW_KEY_S)) {
            position.z += 0.25f * multiplier;
        }
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public void setRoll(float roll) {
        this.roll = roll;
    }

    public Vector3f getPosition() {
        return position;
    }

    public float getPitch() {
        return pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public float getRoll() {
        return roll;
    }
}
