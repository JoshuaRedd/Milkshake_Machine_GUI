package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class Main extends Application {

    //Flavor Buttons
    RadioButton vanilla = new RadioButton("VANILLA");
    RadioButton chocolate = new RadioButton("CHOCOLATE");
    RadioButton strawberry = new RadioButton("STRAWBERRY");
    //Size Buttons
    RadioButton small = new RadioButton("SMALL");
    RadioButton medium = new RadioButton("MEDIUM");
    RadioButton large = new RadioButton("LARGE");
    protected Text totalOrder = new Text("Order:");
    protected Text finalFlavor = new Text("");
    protected Text finalSize = new Text("");
    protected String finalToppings = "";
    //Toppings Buttons
    ToggleButton whip = new ToggleButton("WHIP CREAM");
    ToggleButton syrup = new ToggleButton("SYRUP");
    ToggleButton sprinkles = new ToggleButton("SPRINKLES");

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Section Headers
        Text size = new Text(100, 80, "SIZE");
        size.setFill(Color.BLACK);
        size.setFont(Font.font("Verdana", 25));
        Text flavor = new Text(250,80,"FLAVOR");
        flavor.setFill(Color.BLACK);
        flavor.setFont(Font.font("Verdana", 25));
        Text toppings = new Text(425,80,"TOPPINGS");
        toppings.setFill(Color.BLACK);
        toppings.setFont(Font.font("Verdana", 25));
        Text order = new Text(425,80,"ORDER");
        order.setFill(Color.BLACK);
        order.setFont(Font.font("Verdana", 25));

        //Size Group
        final ToggleGroup sizes = new ToggleGroup();
        small.setToggleGroup(sizes);
        medium.setToggleGroup(sizes);
        medium.setSelected(true);
        large.setToggleGroup(sizes);

        //Flavor Group
        final ToggleGroup flavors = new ToggleGroup();
        vanilla.setToggleGroup(flavors);
        chocolate.setToggleGroup(flavors);
        chocolate.setSelected(true);
        strawberry.setToggleGroup(flavors);

        //Order
        totalOrder = new Text("Order:");

        //GridPane
        GridPane options = new GridPane();
        options.setAlignment(Pos.TOP_CENTER);
        options.setHgap(100);
        options.setVgap(10);
        options.setPrefWidth(550);

        //Adding Children
        options.add(size, 0, 0, 1, 1);
        options.add(flavor, 1, 0, 1, 1);
        options.add(toppings, 2, 0, 1, 1);
        options.add(small, 0, 1, 1, 1);
        options.add(medium, 0, 2, 1, 1);
        options.add(large, 0, 3, 1, 1);
        options.add(vanilla, 1, 1, 1, 1);
        options.add(chocolate, 1, 2, 1, 1);
        options.add(strawberry, 1, 3, 1, 1);
        options.add(whip,2,1,1,1);
        options.add(syrup,2,2,1,1);
        options.add(sprinkles,2,3,1,1);

        //submit button
        Button add = new Button("ADD TO ORDER");

        //pay button
        Button pay = new Button("PAY");

        //add event listeners
        add.setOnAction(e -> {UpdateSize();UpdateFlavor();UpdateToppings();DisplayOrder();});

        //order VBox
        VBox checkout = new VBox(10);
        checkout.getChildren().addAll(order,totalOrder,add,pay);
        checkout.setAlignment(Pos.TOP_CENTER);
        checkout.setPrefWidth(250);

        //options HBox
        HBox main = new HBox(10);
        main.setPadding(new Insets(50));
        main.getChildren().addAll(options,checkout);

        //root
        Group root = new Group();
        root.getChildren().addAll(main);

        //Stage
        primaryStage.setTitle("MSVM");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
    }


    //events
    private void UpdateFlavor(){
        if (vanilla.isSelected()){
            finalFlavor = new Text("Vanilla");
        }
        if (chocolate.isSelected()){
            finalFlavor = new Text("Chocolate");
        }
        if (strawberry.isSelected()){
            finalFlavor = new Text("Strawberry");
        }
    }

    private void UpdateSize(){
        if (small.isSelected()){
            finalSize = new Text("Small");
        }
        if (medium.isSelected()){
            finalSize = new Text("Medium");
        }
        if (large.isSelected()){
            finalSize = new Text("Large");
        }
    }

    private void UpdateToppings(){
        finalToppings = "";
        if (sprinkles.isSelected()){
            finalToppings += "Sprinkles ";
        }
        if (syrup.isSelected()){
            finalToppings += "Syrup ";
        }
        if (whip.isSelected()){
            finalToppings += "Whip ";
        }
    }

    private void DisplayOrder(){
        if(finalToppings==""){
            System.out.println("One " + finalSize.getText() + " " + finalFlavor.getText() + " Milkshake");
        }
        if(finalToppings!="") {
            System.out.println("One " + finalSize.getText() + " " + finalFlavor.getText() + " Milkshake with toppings: " +
                    finalToppings);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
