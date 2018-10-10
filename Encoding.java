/**
 * If you have that scenary a=1 e=25 i=81 o=225 u=441 then code a program: 
 * - Which complete equivalent for each letter in the alphabet. 
 * - Decode that message 361 225 144 225 144 25 1 324 196 
 * - Let user to encode any message.
 */
package encoding;

import java.util.Arrays;
import java.util.Scanner;

public class Encoding {
    
    private final int CONST = 'a' - 1;
    private final int[] encode;
    private String decode;

    public static void main(String[] args) {
        int[] encrypt = {361, 225, 144, 225, 144, 25, 1, 324, 196};
        Encoding dec = new Encoding(encrypt);
        dec.decoding();
        System.out.println(dec.decode);
        Encoding enc = new Encoding(input());
        enc.encoding();
        System.out.println(Arrays.toString(enc.encode));
    }

    public Encoding(int[] args) {
        this.encode = args;
        this.decode = "";
    }
    
    public Encoding(String decode) {
        this.decode = decode.toLowerCase();
        this.encode = new int[decode.length()];
    }
    
    public void decoding() {
        for (int code : encode) {
            decode += String.valueOf((char) ((int) Math.sqrt(code) + CONST));
        }
    }
    
    public void encoding() {
        for (int i = 0; i < decode.length(); i++) {
            char c = decode.charAt(i);
            encode[i] = (int) (Character.isAlphabetic(c) ? Math.pow(c - CONST, 2) : 0);
        }
    }
    
    private static String input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the text you want to encode: ");
        String result = sc.nextLine();
        return result;
    }
}