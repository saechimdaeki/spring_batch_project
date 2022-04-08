package me.saechimdaeki.batch.batchprocess.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ApiResponseVo {

    private final int status;
    private final String msg;
}
