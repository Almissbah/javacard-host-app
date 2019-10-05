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
public interface ApduInterface {
    void connect() throws Exception;
    void disconnect() throws Exception;
    ResponseApdu exchange(CommandApdu commandApdu) throws Exception;
}
