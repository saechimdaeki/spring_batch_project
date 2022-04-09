package me.saechimdaeki.batchapi;

import lombok.*;

import java.util.List;

@Data
@Builder
public class ApiInfo {

    private String url;
    private List<? extends ApiRequestVo> apiRequestList;
}
