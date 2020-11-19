package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import org.w3c.dom.Text;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.UUID;

public class NewCustomerController implements Initializable {
    @FXML
    private TextField firstNameText;

    @FXML
    private TextField lastNameText;

    @FXML
    private TextField phoneText;

    @FXML
    private TextField emailText;

    @FXML
    private TextField ageText;

    @FXML
    private TextField zipCodeText;






    final String JDBCdriver="net.sourceforge.jtds.jdbc.Driver";
    final String DBurl="jdbc:jtds:sqlserver://172.26.54.46:1433/donkirrin;domain=cougarnet.uh.edu;instance=MSSQLSERVER";

    final String user="jmarin4";
    final String pass="Jav!er777";


    private Connection conn =null;
    private Statement stmt =null;
    NewCustomers newCustomers;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }




    public void submitButtonHandle(ActionEvent event) {



        String firstName=firstNameText.getText();
        String lastName= lastNameText.getText();
        String phone= phoneText.getText();
        String email= emailText.getText();
        int age= Integer.parseInt(ageText.getText());
        String zipCode=zipCodeText.getText();


        NewCustomers nwcust1= new NewCustomers();

        nwcust1.setFirstName(firstName);
        nwcust1.setLastName(lastName);
        nwcust1.setPhoneNumber(phone);
        nwcust1.setEmail(email);
        nwcust1.setAge(age);
        nwcust1.setZipCode(zipCode);

        int newCustomerId=1;
         firstName= nwcust1.getFirstName();
         lastName= nwcust1.getLastName();
         phone= nwcust1.getPhoneNumber();
         email= nwcust1.getEmail();
         age=nwcust1.getAge();
         zipCode=nwcust1.getZipCode();

        System.out.println("trying to connect");

        try{
            Class.forName(JDBCdriver);
            conn= DriverManager.getConnection(DBurl,user,pass);

            stmt=conn.createStatement();
            System.out.println("connected.");




            System.out.println("attempting insert");
            String sql= "INSERT INTO NewCustomers VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,0);
            pstmt.setString(2,firstName);
            pstmt.setString(3,lastName);
            pstmt.setString(4,email);
            pstmt.setString(5,phone);
            pstmt.setInt(6,age);
            pstmt.setString(7,zipCode);




            pstmt.executeUpdate();
            System.out.println("insert success!");



        }catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());



        }





    }
}
