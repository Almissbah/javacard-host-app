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
public class ResponseApdu {
    private byte sw1;
    private byte sw2;
    private byte[] data;

    public ResponseApdu(byte sw1, byte sw2, byte[] data) {
        this.sw1 = sw1;
        this.sw2 = sw2;
        this.data = data;
    }

    public byte getSw1() {
        return sw1;
    }

    public void setSw1(byte sw1) {
        this.sw1 = sw1;
    }

    public byte getSw2() {
        return sw2;
    }

    public void setSw2(byte sw2) {
        this.sw2 = sw2;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
    
    
}
