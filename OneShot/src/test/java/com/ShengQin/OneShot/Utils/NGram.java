package com.ShengQin.OneShot.Utils;
import java.util.ArrayList;
import java.util.List;

public class NGram {

    public static List<String> generateNGrams(String sentence, int n) {
        List<String> ngrams = new ArrayList<>();
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length - n + 1; i++) {
            StringBuilder ngramBuilder = new StringBuilder();

            for (int j = 0; j < n; j++) {
                ngramBuilder.append(words[i + j]);
                if (j < n - 1) {
                    ngramBuilder.append(" ");
                }
            }

            ngrams.add(ngramBuilder.toString());
        }

        return ngrams;
    }

    public static void main(String[] args) {
        String sentence = "我喜欢踢足球";
        int n = 1;

        List<String> ngrams = generateNGrams(sentence, n);

        for (String ngram : ngrams) {
            System.out.println(ngram);
        }
    }
}

