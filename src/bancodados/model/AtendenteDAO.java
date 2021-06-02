package bancodados.model;

import bancodados.connection.ConectionFactory;
import usuarios.Atendente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtendenteDAO {
    public void create(Atendente atendente){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement("INSERT INTO atendentes (nome, idade, areasaude, endereco, datavacinacao) " +
                    "VALUES (?, ?, ?, ?, ?)");

            stmt.setString(1, atendente.getNome());
            stmt.setInt(2, atendente.getIdade());
            stmt.setBoolean(3, atendente.isAreasaude());
            stmt.setString(4, atendente.getEndereco());
            stmt.setString(5, atendente.getDatavacinacao());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        }catch (SQLException ex){
            System.out.println(ex);
        }finally {
            ConectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Atendente> read(){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Atendente> atendenteList = new ArrayList();

        try{
            stmt = con.prepareStatement("SELECT * FROM atendentes");
            rs = stmt.executeQuery();

            while (rs.next()){
                Atendente novo = new Atendente();
                novo.set_id(rs.getInt("_id"));
                novo.setNome(rs.getString("nome"));
                novo.setIdade(rs.getInt("idade"));
                novo.setEndereco(rs.getString("endereco"));
                novo.setAreasaude(rs.getBoolean("areasaude"));
                novo.setDatavacinacao(rs.getString("datavacinacao"));

                atendenteList.add(novo);
            }
        }catch (SQLException ex){
            System.out.println(ex);
        }finally {
            ConectionFactory.closeConnection(con, stmt, rs);
        }
        return atendenteList;
    }

    public void delete(Atendente atendente){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement("DELETE FROM atendentes WHERE _id = ?");
            stmt.setInt(1, atendente.get_id());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        }finally {
            ConectionFactory.closeConnection(con, stmt);
        }
    }
}
