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
public class GrupoEspecial implements Grupo {
    private String nome;
    private List<Postagem> postagem;
    private List<Usuario> usuario;
    private Usuario dono;
    
    public GrupoEspecial(String nome, Usuario dono){
        this.nome = nome;
        this.dono = dono;
        this.postagem = new ArrayList<Postagem>();
        this.usuario  = new ArrayList<Usuario>();
    }
    public String getNome(){
        return this.nome;
    }
    public Usuario getDono(){
        return this.dono;
    }
    

    @Override
    public void addPostagen(Usuario usuario, Postagem post) {
        if(this.isSeguidor(usuario)){
            this.postagem.add(post);
            System.out.print("Você postou no Grupo "+this.getNome());
        }
        else{
            System.out.print("Você não é Segidor do Grupo"+this.getNome());
        }
    }

    @Override
    public boolean isSeguidor(Usuario seguidor) {
        for(Usuario user : this.usuario){
            if(user == seguidor){
                return true;
            }
        }
        return false;
    }

    @Override
    public List getPost(Usuario seguidor) {
        if(this.isSeguidor(seguidor)){
            System.out.print("Você é Segidor do Grupo"+this.getNome()+":Pode visualizar as postagens");
            return this.postagem;
        }else{
            System.out.println("Você não é Segidor do Grupo"+this.getNome()+":Pode visualizar as postagens");
        }
        return null;
    }

    @Override
    public void addSeguidor(Usuario seguidor, Usuario dono) {
        if(this.dono == dono){
            this.usuario.add(seguidor);
            System.out.println(seguidor.getNome()+" é o mais novo seguidor do grupo "+this.getNome());
        }
    }
   
    
}
