/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class UsuarioDAOHibernate implements UsuarioDAO{
    private Session session;
    
    public void setSession(Session session){
        this.session = session;
    }
    
    public void salvar(Usuario usuario){
        this.session.saveOrUpdate(usuario);
    }
    
    public void atualizar(Usuario usuario){
        this.session.merge(usuario);
    }
    
    public void excluir(Usuario usuario){
        this.session.delete(usuario);
    }
    
    public Usuario carregar(Integer codigo){
        return (Usuario) this.session.get(Usuario.class, codigo);
    }
    
    public Usuario buscarPorLogin(String login){
        String hql = "select u from Usuario u where u.login = :login";
        Query consulta = this.session.createQuery(hql);
        consulta.setString("login", login);
        return (Usuario) consulta.uniqueResult();
    }
    
    @SuppressWarnings("unchecked")
    public List<Usuario> listar(){
        return this.session.createCriteria(Usuario.class).list();
    }


}
