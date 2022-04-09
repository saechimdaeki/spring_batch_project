package me.saechimdaeki.batchapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class ApiController {

    /**
     * 현재 각각 다른서버로 구성되었다는 가정하로 할 것이므로
     * url endpoint는 불편함을감수 (각각 서버는 port만 다르게 진행)
     * @param apiInfo
     * @return
     */
    @PostMapping("/api/product/1")
    public String product1(@RequestBody ApiInfo apiInfo){
        List<ProductVo> productVoList = apiInfo.getApiRequestList().stream().map(item -> item.getProductVo()).collect(Collectors.toList());
        log.info("productVoList1 = {}",productVoList);

        return "product1 was successfully processed";
    }

    @PostMapping("/api/product/2")
    public String product2(@RequestBody ApiInfo apiInfo){
        List<ProductVo> productVoList = apiInfo.getApiRequestList().stream().map(item -> item.getProductVo()).collect(Collectors.toList());
        log.info("productVoList2 = {}",productVoList);

        return "product2 was successfully processed";
    }


    @PostMapping("/api/product/3")
    public String product3(@RequestBody ApiInfo apiInfo){
        List<ProductVo> productVoList = apiInfo.getApiRequestList().stream().map(item -> item.getProductVo()).collect(Collectors.toList());
        log.info("productVoList3 = {}",productVoList);

        return "product3 was successfully processed";
    }
}
