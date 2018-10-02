
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    public CaesarCipherTwo(int key1,int key2) {
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        mainKey1 = key1;
        mainKey2 = key2;
    }
    public String encrypt(String input) {
        StringBuilder sb = new StringBuilder(input);
        for(int i = 0; i < input.length(); i++) {       
            char ch = input.charAt(i);
            char chBig = Character.toLowerCase(ch);
            if(Character.isAlphabetic(ch)) {
                int index = alphabet.indexOf(ch);
                if((i+1) % 2 != 0) {
                    if(index == -1) {
                        index = alphabet.indexOf(chBig);
                        char chShiftedBig = Character.toUpperCase(shiftedAlphabet1.charAt(index));
                        sb.setCharAt(i,chShiftedBig);
                    }
                    else{
                        char chShifted = shiftedAlphabet1.charAt(index);
                        sb.setCharAt(i,chShifted);
                    }
                }
                else {
                    if(index == -1) {
                        index = alphabet.indexOf(chBig);
                        char chShiftedBig = Character.toUpperCase(shiftedAlphabet2.charAt(index));
                        sb.setCharAt(i,chShiftedBig);
                    }
                    else{
                        char chShifted = shiftedAlphabet2.charAt(index);
                        sb.setCharAt(i,chShifted);
                    }
                }
            }
        }
        return sb.toString();
    }
    public String decrypt(String input) {
        CaesarCipherTwo cc = new CaesarCipherTwo(26-mainKey1,26-mainKey2);
        return cc.encrypt(input);
    }
}
