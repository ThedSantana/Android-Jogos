package com.example.root.jumper.Graficos;

import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * Created by root on 7/19/15.
 */
public class Cores {
    public static Paint getColorDoPassaro() {
        Paint vermelho = new Paint();
        vermelho.setColor(0xFFFF0000);
        return vermelho;

    }
    public static Paint getColorDoCano() {
        Paint azul = new Paint();
        azul.setColor(0xFF00FFFF);
        return azul;
    }
    public static Paint getColorDaPontuacao() {
        Paint branco = new Paint();
        branco.setColor(0xFFFFFFFF);
        branco.setTextSize(80);
        branco.setTypeface(Typeface.DEFAULT_BOLD);
        branco.setShadowLayer(3, 5, 5, 0xFF000000);

        return branco;
    }
    public static Paint getCorDoGameOver() {
        Paint vermelho = new Paint();
        vermelho.setColor(0xFFFF0000);
        vermelho.setTextSize(40);
        vermelho.setTypeface(Typeface.DEFAULT_BOLD);
        vermelho.setShadowLayer(2, 3, 3, 0xFF000000);

        return vermelho;
    }

}
