package me.saechimdaeki.batch.batchprocess.chunk.processor;

import me.saechimdaeki.batch.batchprocess.domain.ApiRequestVo;
import me.saechimdaeki.batch.batchprocess.domain.ProductVo;
import org.springframework.batch.item.ItemProcessor;

public class ApiItemProcessor1 implements ItemProcessor<ProductVo, ApiRequestVo> {
    @Override
    public ApiRequestVo process(ProductVo productVo) throws Exception {
        return ApiRequestVo.builder()
                .id(productVo.getId())
                .productVo(productVo)
                .build();
    }
}
