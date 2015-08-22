package com.example.root.jumper.Graficos;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.root.jumper.Graficos.Cores;

/**
 * Created by root on 7/27/15.
 */
public class Pontuacao {
    private static final Paint BRANCO =
            Cores.getColorDaPontuacao();
    private int pontos = 0;

    public void aumenta(){pontos++;
    }
    public void desenhaNo(Canvas canvas){
        canvas.drawText(String.valueOf(pontos),100,100,BRANCO);
    }

  //  public void para() {
    //    if (new VerificadorDeColisao()){

      //  }
    //}
}
