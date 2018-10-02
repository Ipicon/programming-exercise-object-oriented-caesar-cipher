import edu.duke.*;
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCaesarCipherTwo {
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
    public String halfOfString(String message,int start) {
        StringBuilder sb = new StringBuilder(message);
        for(int i=0; i<message.length(); i++) {
            char ch = sb.charAt(i);
            if(i<start)
                sb.setCharAt(i,'\0');
            else {
            if((start-i) % 2 == 0) 
                sb.setCharAt(i,ch);
            
            else
                sb.setCharAt(i,'\0');
            }
        }
        return sb.toString();
    }
    public int getKey(String s) {
        int[] array = countLetters(s);
        int currIndex = maxIndex(array);
        int esIndex = 4;
        int key = 0;
        key = currIndex-esIndex;
        if(key < 0) 
            return 26 + key;
        return key;
    }
    public String breakCaesarCipher(String input) {
        String halfFirst = halfOfString(input,0);
        String halfSecond = halfOfString(input,1);
        int keyFirst = getKey(halfFirst);
        int keySecond = getKey(halfSecond);
        CaesarCipherTwo cc = new CaesarCipherTwo(keyFirst,keySecond);
        System.out.println("The keys used are:" + keyFirst + " and :" +keySecond);
        String message = cc.decrypt(input);
        if(keyFirst == 0 && keySecond == 0) 
            System.out.println("The message is not encrypted");
        return message;
    }
    public void simpleTests() {
        FileResource fr = new FileResource();
        //String test = fr.asString();
        String test = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        CaesarCipherTwo cc = new CaesarCipherTwo(21,8);
        String encrypted = cc.encrypt(test);
        String decrypted = cc.decrypt(encrypted);
        System.out.println("The message is:\n" + test + "\nThe encrypted message is:\n" + encrypted + 
                           "\nThe decrypted message is:\n" + breakCaesarCipher(encrypted));
    }
}
