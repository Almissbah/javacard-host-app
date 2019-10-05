/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacard.gui.apdu;

/**
 *
 * @author mohamed
 */
public class CommandApdu {
    private byte cla;
    private byte ins;
    private byte p1;
    private byte p2;
    private byte lc;
    private byte[] data;
    private byte le;

    public CommandApdu(byte cla) {
        this.cla = cla;
    }

    public byte getCla() {
        return cla;
    }

    public void setCla(byte cla) {
        this.cla = cla;
    }

    public byte getIns() {
        return ins;
    }

    public void setIns(byte ins) {
        this.ins = ins;
    }

    public byte getP1() {
        return p1;
    }

    public void setP1(byte p1) {
        this.p1 = p1;
    }

    public byte getP2() {
        return p2;
    }

    public void setP2(byte p2) {
        this.p2 = p2;
    }

    public byte getLc() {
        return lc;
    }

    public void setLc(byte lc) {
        this.lc = lc;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public byte getLe() {
        return le;
    }

    public void setLe(byte le) {
        this.le = le;
    }
    
    
    
}
