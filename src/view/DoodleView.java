package view;

import controller.Controller;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Model;
import model.Shape;
import observer.IObserver;
import observer.Observable;
import view.DrawingFacade.ShapeType;

import java.util.ArrayList;
import java.util.List;

import static model.Model.*;
import static view.DrawingFacade.ShapeType.*;

public class DoodleView extends Application implements IObserver {
    public static final int WIN_WIDTH = 1000;
    public static final int WIN_HEIGHT = 600;
    public static final int SHAPE_ICON_SIZE = 20;
    public static final int MAX_STROKE = 20;
    public static final int MIN_STROKE = 1;

    //drawing on the canvas
    private DrawingFacade canvas;

    Controller controller = new Controller(this);
    List<Shape> unModifiableShapeList = null;

    //selecting shapes
    private ToggleGroup shapeGroup;
    private ShapeType selectedShape;
    //shape settings
    private ColorPicker fillColorPicker = new ColorPicker();
    private ColorPicker strokeColorPicker = new ColorPicker();
    private Slider strokeSlider;
    private CheckBox filledCheckbox;

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Doodle Program");
        stage.setScene(getPrimaryScene());
        stage.show();
    }

    private Scene getPrimaryScene()
    {
        BorderPane mainPanel = new BorderPane();

        VBox top = new VBox();
        top.getChildren().addAll(buildMenu(), getToolbar());

        //set the primary regions
        mainPanel.setTop(top);
        mainPanel.setCenter(getCanvas());

        Scene scene = new Scene(mainPanel, WIN_WIDTH, WIN_HEIGHT);
        scene.getStylesheets().add("styles.css");

        return scene;
    }

    private Parent getToolbar()
    {
        HBox panel = new HBox();
        panel.setId("toolbar-main");
        panel.getChildren().addAll(buildShapeSection(), buildSettings(), buildEdit());

        return panel;
    }

    private HBox buildShapeSection()
    {
        HBox shapesPanel = new HBox();
        shapesPanel.setId("toolbar-shapes");

        ShapeType[] shapes = {LINE, OVAL, RECTANGLE, SQUIGGLE};
        ToggleButton[] buttons = new ToggleButton[shapes.length];
        shapeGroup = new ToggleGroup();

        for (int i = 0; i < shapes.length; i++) {
            buttons[i] = getImageToggleButton(shapes[i].toString());
            int finalI = i;
            buttons[i].setOnAction(event -> {
                selectedShape = shapes[finalI];
            });
        }

        buttons[0].setSelected(true);
        selectedShape = LINE;
        shapeGroup.getToggles().addAll(buttons);
        shapesPanel.getChildren().addAll(buttons);

        return shapesPanel;
    }

    private HBox buildSettings()
    {
        HBox settingsPanel = new HBox();
        settingsPanel.setId("toolbar-settings");

        styleColorPicker(fillColorPicker);
        styleColorPicker(strokeColorPicker);

        VBox strokeBox = new VBox();
        Label strokeLabel = new Label("Stroke: 1");
        strokeSlider = new Slider();
        strokeBox.getChildren().addAll(strokeSlider, strokeLabel);

        strokeSlider.setMin(MIN_STROKE);
        strokeSlider.setMax(MAX_STROKE);
        strokeSlider.valueProperty().addListener((observable, oldV, newV) ->
                strokeLabel.setText("Stroke: " + numToInt(newV)));

        filledCheckbox = new CheckBox("Filled");

        settingsPanel.getChildren().addAll(new Label("Fill:"), fillColorPicker,
                new Label("Stroke:"), strokeColorPicker, strokeBox, filledCheckbox);

        return settingsPanel;
    }

    private void styleColorPicker(ColorPicker picker)
    {
        picker.getStyleClass().add(ColorPicker.STYLE_CLASS_BUTTON);
        picker.setValue(Color.BLACK);
    }

    private int numToInt(Number value)
    {
        return (int) Math.floor(value.doubleValue());
    }

    private HBox buildEdit()
    {
        HBox editPanel = new HBox();
        editPanel.setId("toolbar-edits");

        String[] edits = {"undo", "redo"};
        Button[] buttons = new Button[edits.length];

        for (int i = 0; i < edits.length; i++) {
            buttons[i] = getImageButton(edits[i]);
        }
        editPanel.getChildren().addAll(buttons);

        return editPanel;
    }

    private ImageView getButtonIcon(String text)
    {
        ImageView image = new ImageView(text + ".png");
        image.setFitHeight(SHAPE_ICON_SIZE);
        image.setFitWidth(SHAPE_ICON_SIZE);
        return image;
    }

    private ToggleButton getImageToggleButton(String text)
    {
        ToggleButton result = new ToggleButton();
        result.setGraphic(getButtonIcon(text));
        return result;
    }

    private Button getImageButton(String text)
    {
        Button result = new Button();
        result.setGraphic(getButtonIcon(text));
        return result;
    }

    private Parent getCanvas()
    {
        VBox box = new VBox();

        canvas = new DrawingFacade();

        canvas.init(box);
        strokeColorPicker.setOnAction(event -> {
            canvas.setStroke(strokeColorPicker.getValue());
        });

        fillColorPicker.setOnAction(event -> {
            canvas.setFill(fillColorPicker.getValue());
        });

        canvas.setLineWidth((int) strokeSlider.getValue());

        List<Point2D> points = new ArrayList<>();

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            points.add(new Point2D(event.getX(), event.getY()));
            points.add(new Point2D(event.getX(), event.getY()));
        });

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
            canvas.clear();

            if(selectedShape == SQUIGGLE){
                points.add(new Point2D(event.getX(), event.getY()));
            }else {
                points.set(1, new Point2D(event.getX(), event.getY()));
            }



            canvas.drawShape(selectedShape, points, filledCheckbox.isSelected());
        });

        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
            points.clear();
        });

        box.getChildren().add(canvas);

        return box;
    }




    private MenuBar buildMenu()
    {
        MenuBar menuBar = new MenuBar();
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu draw = new Menu("Draw");
        Menu help = new Menu("Help");

        fileMenu(file);
        editMenu(edit);
        drawMenu(draw);
        help(help);

        menuBar.getMenus().addAll(file, edit, draw, help);
        return menuBar;
    }

    private void fileMenu(Menu file)
    {
        MenuItem[] items = {new MenuItem("Quit")};
        file.getItems().addAll(items);
    }

    private void editMenu(Menu edit)
    {
        MenuItem[] items = {new MenuItem("Undo"), new MenuItem("Redo")};
        edit.getItems().addAll(items);
    }

    private void drawMenu(Menu draw)
    {
        Menu shapesMenu = new Menu("Shape Tools");
        MenuItem[] shapes = {new MenuItem("LineFactory"), new MenuItem("Oval"),
                new MenuItem("Rectangle"), new MenuItem("Squiggle")};
        shapesMenu.getItems().addAll(shapes);
        draw.getItems().add(shapesMenu);

        MenuItem clear = new MenuItem("Clear Shapes");
        draw.getItems().add(clear);
    }

    private void help(Menu about)
    {
        MenuItem[] items = {new MenuItem("About")};
        about.getItems().addAll(items);
    }

    @Override
    public void update(Observable observable, Object... arguments)
    {
        Change change = (Change) arguments[0];

        unModifiableShapeList = controller.getShapes();
        canvas.drawList(unModifiableShapeList);
    }
}
