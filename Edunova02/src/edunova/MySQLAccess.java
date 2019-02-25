/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Profesor
 */
public class MySQLAccess {

    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public List<Smjer> getSmjerovi() throws Exception {
        List<Smjer> lista = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/edunovaj19?"
                            + "user=edunova&password=edunova&serverTimezone=UTC");
            statement = connect.createStatement();
            resultSet = statement
                    .executeQuery("select * from smjer");
            Smjer s;
            while (resultSet.next()) {
                s=new Smjer();
                s.setSifra(resultSet.getInt("sifra"));
                s.setNaziv(resultSet.getString("naziv"));
                s.setCijena(resultSet.getBigDecimal("cijena"));
                s.setUpisnina(resultSet.getBigDecimal("upisnina"));
                s.setTrajanje(resultSet.getInt("trajanje"));
                s.setVerificiran(resultSet.getBoolean("verificiran"));
                lista.add(s);
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
        return lista;
    }
    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
}
