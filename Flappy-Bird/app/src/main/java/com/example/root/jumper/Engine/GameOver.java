package com.example.root.jumper.Engine;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.root.jumper.Graficos.Cores;
import com.example.root.jumper.Graficos.Tela;

/**
 * Created by root on 7/27/15.
 */
public class GameOver {
    private final Tela tela;

    private static final Paint VERMELHO = Cores.getCorDoGameOver();

    private int centralizaTexto(String texto) {
        Rect limiteDoTexto = new Rect();
        VERMELHO.getTextBounds(texto, 0, texto.length(), limiteDoTexto);

        int centroHorizontal = tela.getLargura()/2 -
                (limiteDoTexto.left);
        return centroHorizontal;
    }
    public GameOver (Tela tela){
        this.tela = tela;
    }


    public void desenhaNo(Canvas canvas){
        String gameOver = "Game Over";
        int centroHorizontal = centralizaTexto(gameOver);
        canvas.drawText(gameOver, centroHorizontal, tela.getAltura() / 2, VERMELHO);
    }




}
