package me.saechimdaeki.batch.batchprocess.classifier;

import me.saechimdaeki.batch.batchprocess.domain.ApiRequestVo;
import me.saechimdaeki.batch.batchprocess.domain.ProductVo;
import org.springframework.batch.item.ItemWriter;
import org.springframework.classify.Classifier;

import java.util.HashMap;
import java.util.Map;

public class WriterClassifier<C,T> implements Classifier<C,T> {

    private Map<String, ItemWriter<ApiRequestVo>> writerMap = new HashMap<>();

    public void setWriterMap(Map<String, ItemWriter<ApiRequestVo>> writerMap) {
        this.writerMap = writerMap;
    }

    @Override
    public T classify(C classifiable) {
        return (T) writerMap.get(((ApiRequestVo)classifiable).getProductVo().getType());
    }
}
