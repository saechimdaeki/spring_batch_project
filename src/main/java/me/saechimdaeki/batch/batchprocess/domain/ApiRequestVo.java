package me.saechimdaeki.batch.batchprocess.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ApiRequestVo {

    private long id;
    private ProductVo productVo;
    private ApiResponseVo apiResponseVo;
}
