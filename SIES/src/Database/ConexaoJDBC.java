/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public final class ConexaoJDBC {

    protected String driver;
    protected String url;
    protected String usuario;
    protected String senha;
    protected String database;
    public Connection con;
    public ResultSet rs;
    public PreparedStatement stm;

    public ConexaoJDBC() {
        Properties propriedade = new Properties();
        try {
            FileInputStream file = new FileInputStream("config.xml");
            propriedade.loadFromXML(file);
            this.setSenha(propriedade.getProperty("jdbc.passwd"));
            this.setUsuario(propriedade.getProperty("jdbc.user"));
            this.setUrl(propriedade.getProperty("jdbc.url"));
            this.setDatabase(propriedade.getProperty("jdbc.banco"));
            this.setDriver(propriedade.getProperty("jdbc.driver"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getSenha() {
        return senha;
    }

    public String getUrl() {
        return url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setStm(PreparedStatement stm) {
        this.stm = stm;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
//
//    public void setPro() {
//        Properties propriedades = new Properties();
//        propriedades.setProperty("jdbc.user", "us_desenvolvimento");
//        propriedades.setProperty("jdbc.passwd", "123456");
//        propriedades.setProperty("jdbc.url", "jdbc:postgresql://localhost:5432");
//        propriedades.setProperty("jdbc.banco", "db_veiculo");
//        propriedades.setProperty("jdbc.statement", "org.postgresql.jdbc");
//        propriedades.setProperty("jdbc.driver", "org.postgresql.Driver");
//        try {
//            FileOutputStream fi = new FileOutputStream("config.xml");
//            propriedades.storeToXML(fi, "FILE JDBC PROPERTIES:", "ISO-8859-1");
//            fi.close();
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "Erro no Banco");
//        }
//
//    }

    public void conecta() {
        try {
            System.setProperty("jdbc.Drivers", driver);
            con = DriverManager.getConnection(this.getUrl() + "/" + this.getDatabase(), this.getUsuario(), this.getSenha());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco" + e.getMessage());
        }
        setCon(con);
    }

    public void desconecta() {
        try {

            getCon().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
