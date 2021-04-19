package cz.educanet;

import javax.xml.transform.Result;
import java.sql.*;

public class Main {
    public static void main(String args[]) throws SQLException {
        Connection connection = DriverManager.getConnection(
          "jdbc:mysql://localhost/c3zoo", "root", ""
        );

        Statement statement = connection.createStatement();
        System.out.println("Vítejte v Zoo");
        System.out.println("Výpis všech zvířat v zoo");
        ResultSet result = statement.executeQuery("SELECT D.nazev, Z.jmeno FROM Zvirata as Z JOIN Druhy as D ON (Z.druh = D.id)");
        while(result.next()){


            String jmenoZvirete = result.getString("jmeno");
            String nazevDruhu = result.getString("nazev");


            System.out.print("Název druhu: ");
            System.out.println(nazevDruhu);
            System.out.print("Jmeno zviřete: ");
            System.out.println(jmenoZvirete);
            System.out.println("--------------");

        }

        connection.close();

    }
}
