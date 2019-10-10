package br.rev.dao;

import br.rev.conexao.ConexaoDB;
import br.rev.modelo.Restaurante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RestauranteDAO {
    
    private String sql;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public boolean inserir(Restaurante restaurante){
        sql = "insert into pratos (nome, ingrediente1, ingrediente2, ingrediente3, ingrediente4) values (?, ?, ?, ?, ?)";
        con = ConexaoDB.abrirConexao();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, restaurante.getNome());
            ps.setString(2, restaurante.getIngrediente1());
            ps.setString(3, restaurante.getIngrediente2());
            ps.setString(4, restaurante.getIngrediente3());
            ps.setString(5, restaurante.getIngrediente4());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
    }
    
    public boolean update(Restaurante restaurante){
        sql = "update pratos set ingrediente1 = ?, ingrediente2= ?, ingrediente3 = ?, ingrediente4=? where nome = ?";
        con = ConexaoDB.abrirConexao();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, restaurante.getIngrediente1());
            ps.setString(2, restaurante.getIngrediente2());
            ps.setString(3, restaurante.getIngrediente3());
            ps.setString(4, restaurante.getIngrediente4());
            ps.setString(5, restaurante.getNome());
            
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
    }
    
    public boolean excluir(Restaurante restaurante){
        sql = "delete from pratos where nome = ?";
        con = ConexaoDB.abrirConexao();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, restaurante.getNome());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
    }
    public Restaurante pesquisar(String mat){
        sql = "select * from pratos where nome = ?";
        con = ConexaoDB.abrirConexao();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mat);
            rs = ps.executeQuery();
            Restaurante restaurante = new Restaurante();
            if(rs.next()){
                restaurante.setNome(rs.getString("nome"));
                restaurante.setIngrediente1(rs.getString("ingrediente1"));
                restaurante.setIngrediente2(rs.getString("ingrediente2"));
                restaurante.setIngrediente3(rs.getString("ingrediente3"));
                restaurante.setIngrediente4(rs.getString("ingrediente4"));
                
            }
            return restaurante;
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }
    
}
