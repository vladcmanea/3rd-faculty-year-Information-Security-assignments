/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aes;

import java.util.Scanner;

/**
 *
 * @author vladm
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        char[] keys = {(char) (0x00), (char) (0x01), (char) (0x02), (char) (0x03), (char) (0x04), (char) (0x05), (char) (0x06), (char) (0x07), (char) (0x08), (char) (0x09), (char) (0x0a), (char) (0x0b), (char) (0x0c), (char) (0x0d), (char) (0x0e), (char) (0x0f), (char) (0x10), (char) (0x11), (char) (0x12), (char) (0x13), (char) (0x14), (char) (0x15), (char) (0x16), (char) (0x17), (char) (0x18), (char) (0x19), (char) (0x1a), (char) (0x1b), (char) (0x1c), (char) (0x1d), (char) (0x1e), (char) (0x1f)};
        AESClient aes = new AESClient(256, keys);
        Scanner s = new Scanner(System.in);
        String plain = s.nextLine();
        char[][] encr = aes.Encrypt(plain);
        System.out.println(AES.Aux(encr));
        String decr = aes.Decrypt(encr);
        System.out.println(decr);
    }
}
