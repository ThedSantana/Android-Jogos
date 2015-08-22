package com.example.root.jumper.Objetos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.root.jumper.Graficos.Cores;
import com.example.root.jumper.Graficos.Tela;

/**
 * Created by root on 7/23/15.
 */
public class Cano {

    private static final int TAMANHO_DO_CANO = 150;
    private static final int LARGURA_DO_CANO = 100;
    private static final Paint AZUL = Cores.getColorDoCano();

    private final Paint verde = Cores.getColorDoCano();
    private Bitmap canoSuperior;
    private Bitmap canoInferior;
    private int alturaDoCanoInferior;
    private int alturaDoCanoSuperior;
    public int posicao;
    private Tela tela;


    public Cano(Tela tela, int posicao,Context context){
        this.tela = tela;
        this.posicao = posicao;
        this.alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO - valorAleatorio();
        this.alturaDoCanoSuperior = 0 + TAMANHO_DO_CANO + valorAleatorio();
    }

    public void desenhaNo(Canvas canvas){
        desenhaCanoInferiorNo(canvas);
        desenhaCanoSuperiorNo(canvas);
    }
    private void desenhaCanoSuperiorNo(Canvas canvas){
    canvas.drawRect(posicao, 0,posicao + LARGURA_DO_CANO, alturaDoCanoSuperior, AZUL);    }
    private void desenhaCanoInferiorNo(Canvas canvas){
        canvas.drawRect(posicao, alturaDoCanoInferior,posicao + LARGURA_DO_CANO, tela.getAltura(), AZUL);
    }
    public void move(){

        posicao -= 5;
    }
    private int valorAleatorio(){
        return (int) (Math.random() * 150);
    }
    public boolean saiuDaTela(){
        return posicao + LARGURA_DO_CANO < 0;
    }


    public int getPosicao() {
        return posicao;
    }

    public boolean temColisaoVerticalCom(Passaro passaro){
        return passaro.getAltura() - Passaro.RAIO <
                this.alturaDoCanoSuperior
                || passaro.getAltura() + Passaro.RAIO >
                this.alturaDoCanoInferior;

        /*
        Note que Para detectar uma colisao vertical entre o Passaro eo Cano inferior
        basta sabermos quando a borda do passaro toca o topo do cano Ou seja
        quando a altura do Passaro + seu RAIO for > que alturaDoCanoInferior
        */

    }
    public boolean temColisaoHorizontalCom(Passaro passaro){
        return this.posicao - Passaro.X < Passaro.RAIO;

        /*
        note que se a distancia entre a posição horizontal do cano e a posição X
        do passaro for menor q seu RAIO tem colisão
         */
    }
}
