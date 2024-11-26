/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package question19;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.*;

/**
 *
 * @author areba
 */
public class Question19 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Image myPic1 = new Image ("C:\\Users\\areba\\america\\jpg");
        Image myPic2 = new Image ("C:\\Users\\areba\\canada\\jpg");
        Image myPic3 = new Image ("C:\\Users\\areba\\china\\jpg");
        Image myPic4 = new Image ("C:\\Users\\areba\\uk\\jpg");
        
        
        
        GridPane gp1= new GridPane();
        
        gp1.getChildren().addAll(mypic1,mypic2,mypic3);
        
        Scene scene = new Scene(gp1, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextField nameField = new TextField();
        TextField emailField = new TextField();
        Button submitButton = new Button("Submit");

        submitButton.setOnAction(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            try (Connection connection = DatabaseConnection.getConnection()) {
                String query = "INSERT INTO users (name, email) VALUES (?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        VBox vbox = new VBox(nameField, emailField, submitButton);
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/yourdatabase";
        String user = "yourusername";
        String password = "yourpassword";
        return DriverManager.getConnection(url, user, password);
    }
}

