/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package literaturananquim;
//import literaturananquim.ObjetoAvaliavel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduardopovoas
 */
public class Postagem extends ObjetoAvaliavel {
    private final Obra obra;
    private final float notaUsuario;
    private final String critica;
    private final Usuario dono;
    private  List<Comentario> comentario;
   
    public Postagem( Obra literaturaAvaliada, float notaUsuario, String critica, Usuario donoDaPostagem){
        this.media = 0;
        this.nVotos = 0;
        this.obra = literaturaAvaliada;
        this.notaUsuario = notaUsuario;
        this.critica = critica;
        this.dono = donoDaPostagem;
        this.comentario = new ArrayList();
    }
    public void addComentario( Comentario comentario ){
        this.comentario.add(comentario);
    }
    @Override
    public String toString(){
        return this.dono.getNome()+" avaliou a obra "+this.obra.getNome()+" em "+this.notaUsuario+";;; CRÍTICA ::"+this.critica+";;; Média post ::"+this.media;
    }
}
