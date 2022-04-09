package me.saechimdaeki.batchapi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class ApiRequestVo {
    private long id;
    private ProductVo productVo;
}
