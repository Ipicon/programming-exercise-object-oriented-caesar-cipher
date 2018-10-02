
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public CaesarCipher(int key) {
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        mainKey = key;
    }
    public String encrypt(String input) {
        StringBuilder sb = new StringBuilder(input);
        for(int i = 0; i<input.length(); i++) {
            char ch = input.charAt(i);
            char chBig = Character.toLowerCase(ch);
            if(Character.isAlphabetic(ch)) {
                int index = alphabet.indexOf(ch);
                if(index == -1) {
                    index = alphabet.indexOf(chBig);
                    char chShiftedBig = Character.toUpperCase(shiftedAlphabet.charAt(index));
                    sb.setCharAt(i,chShiftedBig);
                }
                else{
                    char chShifted = shiftedAlphabet.charAt(index);
                    sb.setCharAt(i,chShifted);
                }
            }
        }
        return sb.toString();   
    }
    public String decrypt(String input) {
        CaesarCipher cc = new CaesarCipher(26-mainKey);
        return cc.encrypt(input);
    }
}
