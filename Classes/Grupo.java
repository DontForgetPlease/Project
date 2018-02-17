/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package literaturananquim;

import java.util.List;

/**
 *
 * @author eduardopovoas
 */
public interface Grupo {
    public abstract void addPostagen(Usuario usuario, Postagem post);
    public abstract boolean isSeguidor(Usuario seguidor);
    public abstract List getPost(Usuario seguidor);
    public abstract void addSeguidor(Usuario seguidor, Usuario dono);
}
