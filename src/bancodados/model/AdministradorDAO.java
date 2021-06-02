package bancodados.model;

import bancodados.connection.ConectionFactory;
import usuarios.Administrador;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdministradorDAO {

    public void create(Administrador administrador){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement("INSERT INTO administradores (nome, cpf, usuario, senha)VALUES(?,?,?,?)");

            stmt.setString(1, administrador.getNome());
            stmt.setString(2, administrador.getCpf());
            stmt.setString(3, administrador.getUsuario());
            stmt.setString(4, administrador.getSenha());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        }catch (SQLException ex){
            System.out.println(ex);
        }finally {
            ConectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Administrador> read(){
        Connection con = ConectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Administrador> admLista = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM administradores");
            rs = stmt.executeQuery();

            while (rs.next()){
                Administrador novo = new Administrador();
                novo.set_id(rs.getInt("_id"));
                novo.setNome(rs.getString("nome"));
                novo.setCpf(rs.getString("cpf"));
                novo.setUsuario(rs.getString("usuario"));
                novo.setSenha(rs.getString("senha"));

                admLista.add(novo);
            }

        }catch (SQLException ex){
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConectionFactory.closeConnection(con, stmt, rs);
        }

        return admLista;
    }

    public void delete(Administrador administrador){
        Connection con = ConectionFactory.getConnection();

        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement("DELETE FROM administradores WHERE _id = ?");
            stmt.setInt(1, administrador.get_id());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        }finally {
            ConectionFactory.closeConnection(con, stmt);
        }
    }


}
