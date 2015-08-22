package com.example.root.jumper.Engine;

/**
 * Created by root on 7/27/15.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

import com.example.root.jumper.Objetos.Passaro;
import com.example.root.jumper.Graficos.Pontuacao;
import com.example.root.jumper.Graficos.Tela;
import com.example.root.jumper.R;


public class Game extends SurfaceView implements Runnable, OnTouchListener {

    private boolean isRunning = true;
    private final SurfaceHolder holder = getHolder();
    private Passaro passaro;
    private Bitmap background;
    private Tela tela;
    private Canos canos;
    private Pontuacao pontuacao;
    private Context context;


    public Game(Context context) {
        super(context);
        this.context = context;

        tela = new Tela(context);

        setOnTouchListener(this);

        inicializaElementos();
    }

    private void inicializaElementos() {
        this.pontuacao = new Pontuacao();
        this.passaro = new Passaro(tela, context);
        this.canos = new Canos(tela, pontuacao,context);

        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        this.background = Bitmap.createScaledBitmap(back, back.getWidth(), tela.getAltura(), false);

    }

    @Override
    public void run() {
        while (isRunning) {
            if (!holder.getSurface().isValid())
                continue;
            Canvas canvas = holder.lockCanvas();

            canvas.drawBitmap(background, 0, 0, null);



            canos.desenhaNo(canvas);
            canos.move();

            passaro.desenhaNo(canvas);
            passaro.cai();

            pontuacao.desenhaNo(canvas);


            if(new VerificadorDeColisao(passaro, canos).temColisao()) {
                passaro.morre(passaro, canos);
                new GameOver(tela).desenhaNo(canvas);
                isRunning = false;


            }

            holder.unlockCanvasAndPost(canvas);
        }
    }


    public void inicia() {
        this.isRunning = true;
    }

    public void cancela() {
        isRunning = false;

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        passaro.pula();
        return false;
    }

}
