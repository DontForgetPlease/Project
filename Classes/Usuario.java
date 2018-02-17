/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package literaturananquim;

import java.util.ArrayList;
import java.util.List;
import literaturananquim.Exceptions.*;

/**
 *
 * @author eduardopovoas
 */
public class Usuario extends ObjetoAvaliavel {
    private String nome;
    private String email;
    private String senha;
    private String tipoDePessoa;
    private final List<String> listaTipos;
    public GrupoUser meuPosts;
    
    public Usuario ( String nome, String email, String senha){
        this.media = 0;
        this.nVotos = 0;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipoDePessoa = "Normal";
        this.meuPosts = new GrupoUser(this);
        listaTipos = new ArrayList();
        listaTipos.add("Crítico");
        listaTipos.add("Normal");
        listaTipos.add("Otimista");
    }
    
    public Usuario(){
        this.tipoDePessoa = "Normal";
        this.meuPosts = new GrupoUser(this);
        listaTipos = new ArrayList();
        listaTipos.add("Crítico");
        listaTipos.add("Normal");
        listaTipos.add("Otimista");}
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        if (nome.length() < 20 ){
        this.nome = nome;}
        else{
            throw new NumeroCaracterInvalido();
        }
    }
    public String getTipoDePessoa(){
        return this.tipoDePessoa;
    }
    public void setTipoDePessoa( String newTipoPessoa){
        this.tipoDePessoa = newTipoPessoa;
    }
    
    public void setTipoDePessoa( int retornoDaFuncaoComparar ){
        this.setMedia(retornoDaFuncaoComparar);
        this.tipoDePessoa = this.listaTipos.get((int) this.media);
    }
    public void votar( ObjetoAvaliavel objeto, float nota) {
        try {
            if(nota <= 5 && nota >= 0 ){
        this.setTipoDePessoa(objeto.compararMediaNota(nota));
        objeto.setMedia(nota);
            }
           else{
            throw new NotaInvalidaException();
        }}
        catch(NotaInvalidaException ex){
            System.out.println("Erro : Nota Inválida");
        }
        }
    public void criarPostagem( Obra obra, float nota, String critica, Grupo localpost){
        this.votar(obra, nota);
        Postagem postagem = new Postagem( obra, nota, critica, this);
        localpost.addPostagen(this, postagem);
    }
    public GrupoEspecial criarGrupo(String nome){
        GrupoEspecial gp = new GrupoEspecial(nome, this);
        gp.addSeguidor(this, this);
        return gp;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        if (email.length() < 20 ){
        this.email = email;}
        else{
            throw new NumeroCaracterInvalido();
        }
    }
    public String getSenha(){
        return this.senha;
    }
    public void setSenha( String senha){
        if (senha.length() < 20 ){
        this.senha = senha;
        }
        else{
            throw new NumeroCaracterInvalido();
        }
    }
    public void setNvotos(int newNvotos){
        this.nVotos = newNvotos;
    }
    public void seguir(Usuario user){
        user.meuPosts.addSeguidor(this, user);
    }
    public List verPerfil(Usuario user){
        return user.meuPosts.getPost(this);
    }
}
