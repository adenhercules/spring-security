/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.springframework.util.DigestUtils;


@Named
@RequestScoped
public class UsuarioBean {
    private Usuario usuario = new Usuario();
    private String confirmarSenha;
    private String senhaMD5;

    public void setSenhaMD5(String senhaMD5) {
        this.senhaMD5 = senhaMD5;
    }

    public String getSenhaMD5() {
        return senhaMD5;
    }
    private List<Usuario> lista;
    private String destinoSalvar;

    public String getDestinoSalvar() {
        return destinoSalvar;
    }
    

    public void setDestinoSalvar(String destinoSalvar) {
        this.destinoSalvar = destinoSalvar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }
    
    public String novo(){
        this.destinoSalvar = "usuarioSucesso";
        this.usuario = new Usuario();
        this.usuario.setAtivo(true);
        return "usuario";
    }
    
    public String salvar(){
        FacesContext context = FacesContext.getCurrentInstance();
        String senha = this.usuario.getSenha();
        if(senha!=null && senha.trim().length()>0 && !senha.equals(this.confirmarSenha)){
            FacesMessage facesMessage = new FacesMessage("A senha nao foi confirmada corretamente");
            context.addMessage(null, facesMessage);
            return null;
        }
        if(senha != null && senha.trim().length() == 0){
            this.usuario.setSenha(this.senhaMD5);
        }else{
            String senhaCripto=DigestUtils.md5DigestAsHex(senha.getBytes());
            this.usuario.setSenha(senhaCripto);
        }
        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.salvar(this.usuario);
        
    
        return this.destinoSalvar;
        
    }
    
    public List<Usuario> getLista(){
        if(this.lista == null){
            UsuarioRN usuarioRN = new UsuarioRN();
            this.lista = usuarioRN.listar();
            
        }       
        return this.lista;
    }
    
    public String editar(){
        this.senhaMD5 = this.usuario.getSenha();
        return "/Publico/usuario";
    }
    
    public String excluir(){
        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.excluir(this.usuario);
        this.lista=null;
        return null;
    }
    
    public String ativar(){
        if (this.usuario.isAtivo()){
            this.usuario.setAtivo(false);
        } else {
            this.usuario.setAtivo(true);
        }
        
        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.salvar(this.usuario);
        return null;
    }
    
    public String atribuiPermissao (Usuario usuario, String permissao) {

    this.usuario = usuario;

    java.util.Set <String> permissoes = this.usuario.getPermissao();

    if (permissoes.contains (permissao)) {
        permissoes.remove (permissao) ;

    } else {
        permissoes.add (permissao);

    }

    UsuarioRN usuarioRN = new UsuarioRN();

    usuarioRN.salvar(this.usuario);

    return null;

 
   }
}