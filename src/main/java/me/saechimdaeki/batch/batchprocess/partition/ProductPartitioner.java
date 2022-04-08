package me.saechimdaeki.batch.batchprocess.partition;

import me.saechimdaeki.batch.batchprocess.domain.ProductVo;
import me.saechimdaeki.batch.batchprocess.job.api.QueryGenerator;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class ProductPartitioner implements Partitioner {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {

        ProductVo[] productVoList = QueryGenerator.getProductList(dataSource);
        Map<String, ExecutionContext> result = new HashMap<>();

        int number = 0;

        for(int i=0; i< productVoList.length; i++){
            ExecutionContext value = new ExecutionContext();
            result.put("partition"+ number++,value);
            value.put("product",productVoList[1]);
        }
        return result;
    }
}
