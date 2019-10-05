/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacard.gui.apdu;

import com.sun.javacard.apduio.Apdu;
import com.sun.javacard.apduio.CadClientInterface;
import com.sun.javacard.apduio.CadDevice;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author mohamed
 */
public class JavaCardSimulator implements ApduInterface {

    private Socket sock;
    private OutputStream os;
    private InputStream is;
    private final Apdu mApdu;
    private CadClientInterface cad;
    private static JavaCardSimulator INSTANCE;
    
    
    public static JavaCardSimulator getInstance(){
    if(INSTANCE==null) INSTANCE= new JavaCardSimulator();
    return INSTANCE;
    }
    private JavaCardSimulator() {
        mApdu = new Apdu();
    }

    @Override
    public void connect() throws Exception {
        sock = new Socket("localhost", 9025);
        os = sock.getOutputStream();
        is = sock.getInputStream();
        //Initialize the instance card acceptance device
        cad = CadDevice.getCadClientInstance(CadDevice.PROTOCOL_T1, is, os);
        if (cad != null) {
            //to power up the card
            cad.powerUp();
        }
    }

    @Override
    public void disconnect() throws Exception {
        sock.close();
        if (cad != null) {
            cad.powerDown();
        }
    }

    @Override
    public ResponseApdu exchange(CommandApdu commandApdu) throws Exception {
      prepareApdu(commandApdu);
      cad.exchangeApdu(mApdu);
      return prepareResponceApdu();
    }
    
    void prepareApdu(CommandApdu commandApdu){
        byte[] cmnds = {commandApdu.getCla(),commandApdu.getIns(),commandApdu.getP1(),commandApdu.getP2()};
        mApdu.command=cmnds;
        mApdu.Lc = (byte) commandApdu.getData().length;
        mApdu.Le = commandApdu.getLe();
        mApdu.dataIn=commandApdu.getData();
      
}

    private ResponseApdu prepareResponceApdu() {
       byte[] sw1sw2= mApdu.getSw1Sw2();
       byte[] data= mApdu.getDataOut();
     return new ResponseApdu(sw1sw2[0], sw1sw2[1], data); }
}
