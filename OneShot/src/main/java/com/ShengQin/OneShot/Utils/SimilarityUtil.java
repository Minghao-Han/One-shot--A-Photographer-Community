package com.ShengQin.OneShot.Utils;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SimilarityUtil {
    @Autowired
    private NGramUtil nGramUtil;
    public double getJaccardSimilarityBetweenText(String text1,String text2){
        List<Term> terms1 = HanLP.segment(text1);
        List<Term> terms2 = HanLP.segment(text2);
        List<String> words1 = termsToWords(terms1);
        List<String> words2 = termsToWords(terms2);
        List<String> nGrams1 = nGramUtil.generateNGrams(words1,3);
        List<String> nGrams2 = nGramUtil.generateNGrams(words2,3);
        return calculateJaccardSimilarity(nGrams1,nGrams2);
    }
    private double calculateJaccardSimilarity(List<String> nGrams1,List<String> nGrams2){
        Set<String> set1 = new HashSet<>(nGrams1);
        Set<String> set2 = new HashSet<>(nGrams2);

        // 计算交集的大小
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        int intersectionSize = intersection.size();

        // 计算并集的大小
        int unionSize = set1.size() + set2.size() - intersectionSize;

        // 计算Jaccard相似度
        double similarity = (double) intersectionSize / unionSize;

        return similarity;
    }
    private List<String> termsToWords(List<Term> terms){
        List<String> words = new ArrayList<>();
        for (Term term:terms) {
            words.add(term.word);
        }
        return words;
    }
}
