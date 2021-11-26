/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import usuario.UsuarioDAO;
import usuario.UsuarioDAOHibernate;

/**
 *
 * @author AdenH
 */
public class DAOFactory {
    public static UsuarioDAO criarUsuarioDAO(){
        UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
        usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return usuarioDAO;
    }
}
