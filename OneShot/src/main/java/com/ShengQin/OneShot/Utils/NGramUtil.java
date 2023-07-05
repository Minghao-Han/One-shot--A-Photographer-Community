package com.ShengQin.OneShot.Utils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NGramUtil {

    public List<String> generateNGrams(List<String> words, int n) {
        List<String> nGrams = new ArrayList<>();
        for (int i = 0; i < words.size() - n + 1; i++) {
            StringBuilder nGram = new StringBuilder();
            for (int j = 0; j < n; j++) {
                nGram.append(words.get(i + j)).append(" ");
            }
            nGrams.add(nGram.toString().trim());
        }
        return nGrams;
    }
}
