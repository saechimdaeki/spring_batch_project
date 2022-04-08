package me.saechimdaeki.batch.batchprocess.rowmapper;

import me.saechimdaeki.batch.batchprocess.domain.ProductVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<ProductVo> {
    @Override
    public ProductVo mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ProductVo.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .price(rs.getInt("price"))
                .type(rs.getString("type"))
                .build();
    }
}
