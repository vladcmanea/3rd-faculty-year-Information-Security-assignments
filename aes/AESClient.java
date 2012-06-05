/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aes;

/**
 *
 * @author vladm
 */
public class AESClient extends AES {

    /**
     * AESClient
     * @param type
     * @param key
     * @throws Exception
     */
    public AESClient(int type, char[] key) throws Exception {
        super(type, key);
    }

    /**
     * Encrypt
     * @param text
     * @return
     */
    public char[][] Encrypt(String text) throws Exception {
        while (text.length() % 8 > 0) {
            text = text + "`";
        }
        int length = text.length();
        int blocks = length / 8;
        char answer[][] = new char[blocks][16];
        for (int b = 0; b < blocks; ++b) {
            for (int c = 0; c < 8; ++c) {
                answer[b][c << 1] = (char) ((text.charAt(b * 8 + c) >> 8) & 255);
                answer[b][c << 1 | 1] = (char) (text.charAt(b * 8 + c) & 255);
            }
        }
        for (int b = 0; b < blocks; ++b) {
            answer[b] = super.Encrypt(answer[b]);
        }
        return answer;
    }

    /**
     * Decrypt
     * @param text
     * @return
     */
    public String Decrypt(char[][] text) throws Exception {
        char[] block;
        String auxiliary = "", result = "";
        int blocks = text.length;
        for (int b = 0; b < blocks; ++b) {
            block = super.Decrypt(text[b]);
            auxiliary = "";
            for (int i = 0; i < 8; ++i) {
                auxiliary += (char) (block[i << 1] << 8 | block[i << 1 | 1]);
            }
            StringBuilder builder = new StringBuilder(auxiliary);
            while (builder.charAt(builder.length() - 1) == '`') {
                builder = new StringBuilder(
                        builder.substring(0, builder.length() - 1));
            }
            result = result + builder;
        }
        return result;
    }
}
