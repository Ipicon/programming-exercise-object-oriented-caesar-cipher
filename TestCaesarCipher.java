import edu.duke.*;
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCaesarCipher {
    public int[] countLetters(String input) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] array = new int[26];
        for(int i=0; i < input.length(); i++) {
            char ch = Character.toLowerCase(input.charAt(i));
            int index = alphabet.indexOf(ch);
            if(index != -1) {
                array[index]++;
            }
        }
        return array;
    }
    public int maxIndex(int[] array) {
        int index=0;
        int indexCounter = 0;
        for(int i = 0; i <array.length; i++) {
            if(i==0) {
                index = i;
                indexCounter = array[i];
            }
            if(array[i] > indexCounter) {
                index = i;
                indexCounter = array[i];
            }
        }
        return index;
    }
    public String breakCaesarCipher (String input) {
        int[] array = countLetters(input);
        int currIndex = maxIndex(array);
        int esIndex = 4;
        int key = 0;
        if(currIndex < esIndex)
            key = 26+currIndex;
        key = currIndex-esIndex;
        CaesarCipher cc = new CaesarCipher(key);
        return cc.decrypt(input);
    }
    public void simpleTests() {
        FileResource fr = new FileResource();
        //String test = fr.asString();
        String test = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        CaesarCipher cc = new CaesarCipher(15);
        String encrypted = cc.encrypt(test);
        String decrypted = cc.decrypt(encrypted);
        System.out.println("The message is:\n" + test + "\nThe encrypted message is:\n" + encrypted + 
                           "\nThe decrypted message is:\n" + breakCaesarCipher(encrypted));
    }
}
