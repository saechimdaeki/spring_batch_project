package me.saechimdaeki.batch.batchprocess.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class ProductVo {

    private Long id;
    private String name;
    private int price;
    private String type;

}
