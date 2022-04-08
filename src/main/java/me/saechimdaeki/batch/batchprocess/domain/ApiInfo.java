package me.saechimdaeki.batch.batchprocess.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ApiInfo {
    private final String url;
    private final List<? extends ApiRequestVo> apiRequestList;
}
