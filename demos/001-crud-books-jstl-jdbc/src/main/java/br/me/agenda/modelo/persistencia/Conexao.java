package br.me.agenda.modelo.persistencia;

/**
 *
 * @author root
 */
import com.mchange.v2.c3p0.*;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

    private static ComboPooledDataSource cpds;
    private static String jdbcUrl = "jdbc:postgresql://localhost:5432/agenda";
    private static String driver = "org.postgresql.Driver";
    private static String login = "postgres";
    private static String senha = "postgres";
    private Connection conn;
    
    /**
     * obter Unica Instancia
     */
    private static Conexao singleton = null;

    public static Conexao getInstance() {
        if (singleton == null) {
            return singleton = new Conexao();
        } else {
            return singleton;
        }
    }
    private Conexao() {
        try {
            //criação do pool de conexões
            cpds = new ComboPooledDataSource();
            cpds.setDriverClass(driver);
            cpds.setJdbcUrl(jdbcUrl);
            cpds.setUser(login);
            cpds.setPassword(senha);
            cpds.setMinPoolSize(5);
            cpds.setAcquireIncrement(5);
            cpds.setMaxPoolSize(20);
        } catch (PropertyVetoException ex) {
        }
    }

    public Connection getConnection() throws SQLException {
        conn = cpds.getConnection();
        System.out.println("Connected!");
        return conn;
    }

    public void fechar(PreparedStatement pstmt) {
        fechar(pstmt, null);
    }

    @SuppressWarnings("UnusedAssignment")
    public void fechar(PreparedStatement pstmt, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }

            if (rs != null) {
                rs.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }
        } catch (Exception e) {
            rs = null;
            pstmt = null;
        } finally {
            rs = null;
            pstmt = null;
        }
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            conn = null;
        } finally {
            super.finalize();
        }
    }
}
