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
public class Comentario extends ObjetoAvaliavel {
    private final Usuario dono;
    private String txt;
    
    public Comentario( Usuario dono, String txt){
        this.media = 0;
        this.nVotos = 0;
        this.dono = dono;
        this.txt = txt;
    }
    public void setTxt( String novoComentario){
        this.txt = novoComentario;
    }
    
    @Override
    public String toString(){
        return dono.getNome()+" :comentou: "+this.txt;
    }
}
