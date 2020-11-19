package sample;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Initializable {

    @FXML
    private ImageView donkirrinLogo;

    final String JDBCdriver="net.sourceforge.jtds.jdbc.Driver";
    final String DBurl="jdbc:jtds:sqlserver://172.26.54.46:1433/donkirrin;domain=cougarnet.uh.edu;instance=MSSQLSERVER";

    final String user="jmarin4";
    final String pass="Jav!er777";


private Connection conn =null;
private Statement stmt =null;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            setImageView();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
    private void setImageView() throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream("resources/images/donkirrinlogo.JPG");
        Image image=new Image(inputStream);
        donkirrinLogo.setImage(image);


    }





    private void initializeDB(){

//        final String JDBCdriver="net.sourceforge.jtds.jdbc.Driver";
//        final String DBurl="jdbc:jtds:sqlserver://172.26.54.46:1433/donkirrin;domain=cougarnet.uh.edu;instance=MSSQLSERVER";
//
//        final String user="jmarin4";
//        final String pass="Jav!er777";

        System.out.println("trying to connect");

        try{
            Class.forName(JDBCdriver);
            conn= DriverManager.getConnection(DBurl,user,pass);

            stmt=conn.createStatement();
            System.out.println("connected.");


        }catch(Exception e){
            e.printStackTrace();
            Alert a=new Alert(Alert.AlertType.ERROR);

        }



    }




    public void newCustomerButtonHandle(ActionEvent event) {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("newcustomers.fxml"));
        try {
            Loader.load();
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        Parent p = Loader.getRoot();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(p));
        stage.show();


    }


    public void returningCustomerButtonHandle(ActionEvent event) {
    }
}