package me.saechimdaeki.batch.batchprocess.chunk.writer;

import lombok.extern.slf4j.Slf4j;
import me.saechimdaeki.batch.batchprocess.domain.ApiRequestVo;
import me.saechimdaeki.batch.batchprocess.domain.ApiResponseVo;
import me.saechimdaeki.batch.service.AbstractApiService;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

@Slf4j
public class ApiItemWriter1 extends FlatFileItemWriter<ApiRequestVo> {

    private final AbstractApiService apiService;

    public ApiItemWriter1(AbstractApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void write(List<? extends ApiRequestVo> items) throws Exception {
        ApiResponseVo responseVo = apiService.service(items);
        log.info("responseVo1 = {}",responseVo);

        items.forEach(item->item.setApiResponseVo(responseVo));


        super.setResource(new ClassPathResource("product1.txt"));
        super.open(new ExecutionContext());
        super.setLineAggregator(new DelimitedLineAggregator<>());
        super.setAppendAllowed(true);
        super.write(items);
    }
}
