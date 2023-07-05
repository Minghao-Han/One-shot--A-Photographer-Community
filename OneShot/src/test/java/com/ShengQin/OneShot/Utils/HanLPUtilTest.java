package com.ShengQin.OneShot.Utils;

import com.hankcs.hanlp.mining.word2vec.Word2VecTrainer;
import com.hankcs.hanlp.mining.word2vec.WordVectorModel;
import org.springframework.beans.factory.annotation.Autowired;

class HanLPUtilTest {
    @Autowired
    SimilarityUtil similarityUtil;

//    @Test
//    void segment() {
//        similarityUtil.segment("太阳下的海滩");
//    }

    public static void main(String[] args) {

//        // 设置堆空间大小为2GB
//        String heapSize = "2g";
//        // 拼接参数
//        String[] jvmArgs = {"-Xmx" + heapSize};

        // 启动Java程序并设置堆空间大小
        Word2VecTrainer trainerBuilder = new Word2VecTrainer();
        WordVectorModel wordVectorModel = trainerBuilder.train("/Users/hanminghao/Downloads/hanlp-wiki-vec-zh/hanlp-wiki-vec-zh.txt", "/Users/hanminghao/Downloads/hanlp-wiki-vec-zh/msr-vector.txt");
        wordVectorModel.nearest("中国");
    }
}