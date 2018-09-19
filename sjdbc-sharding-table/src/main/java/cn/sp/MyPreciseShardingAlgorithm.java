package cn.sp;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * Created by 2YSP on 2018/9/19.
 */
public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> preciseShardingValue) {
        for(String tablesName : availableTargetNames){
            if (tablesName.endsWith((preciseShardingValue.getValue() % 4+""))){
                return tablesName;
            }
        }
        throw new IllegalArgumentException();
    }
}
