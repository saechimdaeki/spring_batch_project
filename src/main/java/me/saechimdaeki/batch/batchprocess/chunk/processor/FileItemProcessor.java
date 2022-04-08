package me.saechimdaeki.batch.batchprocess.chunk.processor;

import me.saechimdaeki.batch.batchprocess.domain.Product;
import me.saechimdaeki.batch.batchprocess.domain.ProductVo;
import org.modelmapper.ModelMapper;
import org.springframework.batch.item.ItemProcessor;

public class FileItemProcessor  implements ItemProcessor<ProductVo, Product> {
    @Override
    public Product process(ProductVo productVo) throws Exception {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(productVo, Product.class);
    }
}
