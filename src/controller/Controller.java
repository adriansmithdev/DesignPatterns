package controller;

import model.Model;
import model.Shape;
import view.DoodleView;

import java.util.List;


/**
 * Controls interaction between model and view
 * @author Adrian Smith/Kyle Johnson
 * @version 1
 */
public class Controller {

    private Model model;
    private DoodleView view;

    /**
     * Creates controller with active javafx view
     * @param view that is holding drawings
     */
    public Controller(DoodleView view) {
        setModel(new Model());
        this.setView(view);
        getModel().addObserver(view);
    }

    /**
     * Retrieves shapes history
     * @return shape history
     */
    public List<Shape> getShapes() {
        return getModel().getShapes();
    }

    /**
     * Adds a shape to the model
     * @param shape to add
     */
    public void addShape(Shape shape) {
        getModel().addShape(shape);
    }

    /**
     * Removes most recent shape
     */
    public void removeShape() {
        getModel().removeShape();
    }


    /**
     * Clears all shapes drawn
     */
    public void clearHistory() {
        getModel().clearHistory();
    }

    /**
     * Redoes the most recent removed shape
     */
    public void redo() {
        getModel().redo();
    }

    @Override
    public String toString() {
        return "Controller{" +
                "model=" + getModel() +
                ", view=" + getView() +
                '}';
    }

    /**
     * Retrieves model storing shapes
     * @return model instance
     */
    public Model getModel() {
        return model;
    }

    /**
     * Sets the model that stores shapes
     * @param model that stores shapes
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * Gets the active drawing view
     * @return view for drawing
     */
    public DoodleView getView() {
        return view;
    }

    /**
     * Sets the active application view
     * @param view that user is drawing in
     */
    public void setView(DoodleView view) {
        this.view = view;
    }
}
