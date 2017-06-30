package engineTester;

import entities.Camera;
import entities.Entity;
import models.TexturedModel;
import org.joml.Vector3f;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import models.RawModel;
import renderEngine.OBJLoader;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

public class EngineTester {

    public static void main (String[] args) {
        DisplayManager.createDisplay(1200, 720, "Display");

        Loader loader = new Loader();
        StaticShader shader = new StaticShader();
        Renderer renderer = new Renderer(shader);

        RawModel model = OBJLoader.loadObjModel("dragon", loader);
        ModelTexture texture = new ModelTexture(loader.loadTexture("blue"));
        TexturedModel texturedModel = new TexturedModel(model, texture);

        Entity entity = new Entity(texturedModel, new Vector3f(0,-2,-15),0,0,0,1);

        Camera camera = new Camera();

        while(!glfwWindowShouldClose(DisplayManager.getWindow())) {
            entity.increaseRotation(0, 1, 0);
            camera.move();
            renderer.prepare();
            shader.start();
            shader.loadViewMatrix(camera);
            renderer.render(entity, shader);
            shader.stop();
            DisplayManager.updateDisplay();
        }

        shader.cleanup();
        loader.cleanup();
        DisplayManager.closeDisplay();
    }

}
