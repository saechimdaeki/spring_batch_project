package me.saechimdaeki.batch.batchprocess.classifier;

import me.saechimdaeki.batch.batchprocess.domain.ApiRequestVo;
import me.saechimdaeki.batch.batchprocess.domain.ProductVo;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.classify.Classifier;

import java.util.HashMap;
import java.util.Map;

public class ProcessorClassifier<C,T> implements Classifier<C,T> {

    private Map<String, ItemProcessor<ProductVo, ApiRequestVo>> processorMap = new HashMap<>();

    public void setProcessorMap(Map<String, ItemProcessor<ProductVo, ApiRequestVo>> processorMap) {
        this.processorMap = processorMap;
    }

    @Override
    public T classify(C classifiable) {
        return (T)processorMap.get(((ProductVo)classifiable).getType());
    }
}
