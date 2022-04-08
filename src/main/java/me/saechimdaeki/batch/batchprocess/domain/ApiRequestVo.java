package me.saechimdaeki.batch.batchprocess.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ApiRequestVo {

    private long id;
    private ProductVo productVo;
}
