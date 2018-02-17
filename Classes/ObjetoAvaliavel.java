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
public class ObjetoAvaliavel {
    protected float media;
    protected int nVotos;
    
    private void addVoto(){
        this.nVotos += 1;
    }
    public void setNVotos(int nVotos){
        this.nVotos = nVotos;
    }
    public float getMedia(){
        return this.media;
    }
    public int getNVotos(){
        return this.nVotos;
    }
    public void setMediaDAO(float media){
        this.media = media;
    }
    public void setMedia( float notaDoUsuario){
        float somaNotas = (this.getMedia()*this.getNVotos())+notaDoUsuario;
        this.addVoto();
        float novaMedia = somaNotas/this.nVotos;
        this.media = novaMedia;
    }
    public int compararMediaNota( float notaDoUsuario ){
        int margemDeAvaliacao = 1;
        if (this.getMedia() == 0){
            return 1;
        }
        if (notaDoUsuario <= (this.media-margemDeAvaliacao)){
            return 0;
        }
        if(notaDoUsuario >= (this.media-margemDeAvaliacao) && notaDoUsuario <= (this.media+margemDeAvaliacao )){
            return 1;
        }
        if (notaDoUsuario >= (this.media+margemDeAvaliacao)){
            return 2;
        }
        return 1;
    }
}
