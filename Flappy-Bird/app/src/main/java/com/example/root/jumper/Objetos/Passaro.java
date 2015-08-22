package com.example.root.jumper.Objetos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.root.jumper.Engine.Canos;
import com.example.root.jumper.Graficos.Cores;
import com.example.root.jumper.Graficos.Tela;
import com.example.root.jumper.R;
import com.example.root.jumper.Engine.VerificadorDeColisao;

/**
 * Created by root on 7/19/15.
 */
public class Passaro {
    private static final Paint vermelho =
            Cores.getColorDoPassaro();
    public static final int X = 100;
    public static final int RAIO = 50;
    private final Bitmap passaro;
    private Tela tela;
    public int altura;
    public Canos canos;

    public Passaro(Tela tela, Context context) {
        this.tela = tela;
        this.altura = 100;

        Bitmap bp = BitmapFactory.decodeResource(
                context.getResources(), R.drawable.passaro);
        this.passaro = Bitmap.createScaledBitmap(bp, RAIO*2, RAIO*2, false);
}
    public void desenhaNo(Canvas canvas){

        canvas.drawBitmap(passaro,X-RAIO ,altura-RAIO, null);

    }
    public void morre(Passaro passaro, Canos canos){
        if(new VerificadorDeColisao(passaro, canos).temColisao()) {
            altura+=78;
        }
    }


    public void cai(){

        boolean chegouNoChao = altura + RAIO > tela.getAltura();
        if (!chegouNoChao){
            altura +=5;
        }

    }

    public void pula(){

        if (altura > RAIO){
            altura -= 100;
        }

    }

    public int getAltura() {
        return altura;
    }
}

