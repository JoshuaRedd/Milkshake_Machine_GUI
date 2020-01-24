package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

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


        //Size Buttons
        Button small = new Button("SMALL");
        Button medium = new Button("MEDIUM");
        Button large = new Button("LARGE");

        //Flavor Buttons
        Button vanilla = new Button("VANILLA");
        Button chocolate = new Button("CHOCOLATE");
        Button strawberry = new Button("STRAWBERRY");

        //Toppings Buttons
        Button whip = new Button("WHIP CREAM");
        Button syrup = new Button("SYRUP");
        Button sprinkles = new Button("SPRINKLES");

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

        //order VBox
        VBox checkout = new VBox(10);
        checkout.getChildren().addAll(order,add,pay);
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


    public static void main(String[] args) {
        launch(args);
    }
}


//utilize single select checkboxes instead of buttons