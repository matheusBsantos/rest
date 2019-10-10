
package br.rev.controle;

import br.rev.dao.RestauranteDAO;
import br.rev.modelo.Restaurante;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean (name="bean")
@SessionScoped
public class RestauranteBean {
    
    private Restaurante restaurante;
    private RestauranteDAO dao;
    
    public RestauranteBean(){
        restaurante = new Restaurante();
        dao = new RestauranteDAO();
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

   
    
    //metodos butões
    public void inserir(){
        dao.inserir(restaurante);
        restaurante = new Restaurante();
        
    }
    
    public void pesquisar(){
        restaurante = dao.pesquisar(restaurante.getNome());
        
        
    }
    
    public void alterar(){
        dao.update(restaurante);
        restaurante = new Restaurante();
        
    }
    
    public void excluir(){
        dao.excluir(restaurante);
        restaurante = new Restaurante();
        
    }
    
}
