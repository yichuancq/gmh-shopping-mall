package com.gmh.order.config.shardingjdbc;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;
import java.util.Date;

/**
 * @author yichuan
 */
@Slf4j
public class DatePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Date> {

    /**
     * @param availableTargetNames
     * @param preciseShardingValue
     * @return
     */
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Date> preciseShardingValue) {
        Date date = preciseShardingValue.getValue();
        String suffix = ShardingUtils.getSuffixByYearMonth(date);
        log.info("suffix: {}", suffix);
        for (String tableName : availableTargetNames) {
            log.info("tableName: {}", tableName);
            if (tableName.endsWith(suffix)) {
                return tableName;
            }
        }
        throw new IllegalArgumentException("未找到匹配的数据表");
    }
}
