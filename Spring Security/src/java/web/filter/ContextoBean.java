/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.filter;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import usuario.Usuario;
import usuario.UsuarioRN;

/**
 *
 * @author AdenH
 */
@Named
@SessionScoped
public class ContextoBean implements Serializable {

    private Usuario usuarioLogado=null;

    public Usuario getUsuarioLogado() {
    FacesContext context = FacesContext.getCurrentInstance();
    ExternalContext external = context.getExternalContext ();
    String login = external.getRemoteUser();

 

if (this.usuarioLogado == null || !login.equals(this.usuarioLogado.getLogin())){
    if (login != null) {
           UsuarioRN usuarioRN = new UsuarioRN();
           this.usuarioLogado = usuarioRN.buscarPorLogin(login);
    }

        
    }
return usuarioLogado;
    }
}