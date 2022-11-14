package count_words_in_string;

import java.util.HashMap;

public class WordsInString {
    public static void main(String[] args) {
        String sentence = "This is a test I designed to test a candidate.";
        sentence = sentence.replaceAll("\\.", "");
        String[] words = sentence.split(" ");
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (String word : words) {
            hashMap.put(word, 1);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    hashMap.replace(words[i], 1, 2);
                }
            }
        }
        for (String word: hashMap.keySet()){
            System.out.println(word+":"+hashMap.get(word));
        }
    }
}
