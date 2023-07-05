package com.ShengQin.OneShot.Utils;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.synonym.Synonym;
import com.hankcs.hanlp.dictionary.CoreSynonymDictionary;
import com.hankcs.hanlp.dictionary.common.CommonSynonymDictionary;
import com.hankcs.hanlp.seg.common.Term;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SimilarityUtil {
    private static int N = 3;
    public double getJaccardSimilarityBetweenText(String text1,String text2){
        //使用HanLP分词
        List<Term> terms1 = HanLP.segment(text1);
        List<Term> terms2 = HanLP.segment(text2);
        List<String> words1 = termsToWords(terms1);
        List<String> words2 = termsToWords(terms2);
        List<String> wordWithSyn1 = wordsAddSynonym(words1);
        List<String> wordWithSyn2 = wordsAddSynonym(words2);
        return calculateJaccardSimilarity(wordWithSyn1,wordWithSyn2);
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
        double similarity = ((double) intersectionSize / unionSize)*1.5;//乘1.5放大差距

        return similarity;
    }
    private List<String> termsToWords(List<Term> terms){
        List<String> words = new ArrayList<>();
        for (Term term:terms) {
            words.add(term.word);
        }
        return words;
    }
    public List<String> wordsAddSynonym(List<String> words){//获取同义词，至多3个
        List<String> addedSynonyms = new ArrayList<>();
        for (String word:words) {
            addedSynonyms.add(word);
            CommonSynonymDictionary.SynonymItem synonymItem = CoreSynonymDictionary.get(word);
            if (synonymItem!=null){
                List<Synonym> synonyms = synonymItem.synonymList;
                int maxNumOfSynonym = synonyms.size()>N?N: synonyms.size();
                for (int i=0;i<maxNumOfSynonym;i++){
                    addedSynonyms.add(synonyms.get(i).realWord);
                }
            }
        }
        return addedSynonyms;
    }
}
