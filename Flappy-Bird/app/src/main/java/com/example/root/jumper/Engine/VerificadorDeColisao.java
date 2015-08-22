package com.example.root.jumper.Engine;

import com.example.root.jumper.Objetos.Passaro;

/**
 * Created by root on 7/27/15.
 */
public class VerificadorDeColisao {
    private final Passaro passaro;
    private final Canos canos;

    public VerificadorDeColisao(Passaro passaro, Canos canos) {
        this.passaro = passaro;
        this.canos = canos;

    }



    public boolean temColisao() {
        return canos.temColisaoCom(passaro);

    }
}