/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package literaturananquim;

/**
 *
 * @author eduardopovoas
 */
public class Obra extends ObjetoAvaliavel {
    private int id;
    private String nome;
    private String genero;
    private String autor;
    
    public Obra(){
    }
    
    public Obra( int id, String nome,String genero, String autor){
        this.id = id;
        this.media = 0;
        this.nVotos = 0;
        this.nome = nome;
        this.genero = genero;
        this.autor = autor;
    }
    public int getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
    public String getAutor(){
        return this.autor;
    }
    public String getGenero(){
        return this.genero;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
}
