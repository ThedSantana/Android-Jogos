package com.example.root.jumper.Engine;

import android.content.Context;
import android.graphics.Canvas;

import com.example.root.jumper.Graficos.Pontuacao;
import com.example.root.jumper.Graficos.Tela;
import com.example.root.jumper.Objetos.Cano;
import com.example.root.jumper.Objetos.Passaro;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by root on 7/23/15.
 */
public class Canos {
    private List<Cano> canos = new ArrayList<Cano>();

    private static final int QUANTIDADE_DE_CANOS = 4;
    private static final int DISTANCIA_ENTRE_CANOS = 350;

    private  Pontuacao pontuacao;
    private Tela tela;
    private Context context;


    public Canos(Tela tela, Pontuacao pontuacao, Context context) {
        this.pontuacao = pontuacao;
        this.tela = tela;
        this.context = context;
        int posicaoInicial = 200;

        for (int i = 0; i < QUANTIDADE_DE_CANOS; i++) {
            posicaoInicial += 250;
            canos.add(new Cano(tela, posicaoInicial,context));
        }
    }
    
    public void desenhaNo(Canvas canvas){
        for (Cano cano : canos)
            cano.desenhaNo(canvas);
    }
    public void move(){
        ListIterator<Cano> iterator = canos.listIterator();
        while(iterator.hasNext()) {
            Cano cano = iterator.next();
            cano.move();

            if (cano.saiuDaTela()) {
                pontuacao.aumenta();
                iterator.remove();

                Cano outroCano =
                        new Cano(tela, getMaximo() + DISTANCIA_ENTRE_CANOS, context);
                iterator.add(outroCano);
            }
        }
        
    }
    private int getMaximo(){
        int maximo = 0;
        for (Cano cano : canos){
            maximo = Math.max(cano.getPosicao(),maximo);
        }
        return maximo;
    }


    public boolean temColisaoCom(Passaro passaro){
        for (Cano cano: canos){
            if (cano.temColisaoHorizontalCom(passaro)
                    && cano.temColisaoVerticalCom(passaro)){

                return true;

            }
        }
        return false;
    }
}

