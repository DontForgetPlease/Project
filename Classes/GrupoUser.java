/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package literaturananquim;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduardopovoas
 */
public class GrupoUser implements Grupo {
    private List<Usuario> seguidores;
    private List<Postagem> posts;
    private Usuario dono;

    public GrupoUser(Usuario dono){
        this.dono = dono;
        this.posts = new ArrayList();
        this.seguidores = new ArrayList();
    }
    @Override
    public void addPostagen(Usuario usuario, Postagem post) {
        if(this.dono == usuario){
            this.posts.add(post);
            System.out.println("Postagem realizada com sucesso");
        }
        else{
            System.out.println("Postagem não foi realizada com sucesso");
        }
    }

    @Override
    public boolean isSeguidor(Usuario seguidor) {
        for(Usuario user : this.seguidores){
            if(user == seguidor){
                return true;
            }
        }
        return false;
    }

    @Override
    public List getPost(Usuario seguidor) {
         if(this.isSeguidor(seguidor)){
            System.out.print("Você é Segidor de"+this.dono.getNome()+":Pode visualizar as postagens");
            return this.posts;
        }else{
            System.out.println("Você não é Segidor de"+this.dono.getNome()+":Pode visualizar as postagens");
        }
        return null;
    }

    @Override
    public void addSeguidor(Usuario seguidor, Usuario dono) {
        if(this.dono == dono){
            this.seguidores.add(seguidor);
            System.out.println(seguidor.getNome()+" começou a seguir"+this.dono.getNome());
        }
    }
    
    
    
}
