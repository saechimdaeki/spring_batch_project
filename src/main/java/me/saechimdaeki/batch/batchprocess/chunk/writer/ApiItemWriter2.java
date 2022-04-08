package me.saechimdaeki.batch.batchprocess.chunk.writer;

import lombok.extern.slf4j.Slf4j;
import me.saechimdaeki.batch.batchprocess.domain.ApiRequestVo;
import me.saechimdaeki.batch.batchprocess.domain.ApiResponseVo;
import me.saechimdaeki.batch.service.AbstractApiService;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

@Slf4j
public class ApiItemWriter2 implements ItemWriter<ApiRequestVo> {

    private final AbstractApiService apiService;

    public ApiItemWriter2(AbstractApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void write(List<? extends ApiRequestVo> items) throws Exception {
        ApiResponseVo responseVo = apiService.service(items);
        log.info("responseVo2 = {}",responseVo);
    }
}
