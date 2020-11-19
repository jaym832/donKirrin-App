package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;


public class PremiumCustomerController implements Initializable {
    @FXML
    public TextField firstNameText;

    @FXML
    private TextField lastNameText;

    @FXML
    private TextField phoneText;



    final String JDBCdriver="net.sourceforge.jtds.jdbc.Driver";
    final String DBurl="jdbc:jtds:sqlserver://172.26.54.46:1433/donkirrin;domain=cougarnet.uh.edu;instance=MSSQLSERVER";

    final String user="jmarin4";
    final String pass="Jav!er777";



    private Connection conn =null;
    private Statement stmt =null;

    public PremiumCustomerController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }

    public void submitB(ActionEvent event) {
        Scanner sc = new Scanner(System.in);


        try{
            Class.forName(JDBCdriver);
            conn= DriverManager.getConnection(DBurl,user,pass);

            stmt=conn.createStatement();
            System.out.println("connected.");
            System.out.print("First Name:");
            String FirstName =sc.next();


            String sql= "SELECT * FROM PremiumCustomers WHERE FirstName='" + FirstName + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next())
                System.out.println("Success!");
            else
                System.out.println("Customer Not Found!");


        }catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());

        }

    }
}