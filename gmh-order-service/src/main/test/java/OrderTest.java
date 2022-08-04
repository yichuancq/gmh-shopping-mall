import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gmh.order.OrderServerApplication;
import com.gmh.order.domain.OrderEntity;
import com.gmh.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {OrderServerApplication.class})
public class OrderTest {
    @Autowired
    private OrderService orderService;

    /**
     *
     */
    @Test
    public void findOneById() {
        final Integer id = 1;
        log.info("info->findById:{}", id);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        List<OrderEntity> entityList = orderService.getBaseMapper().selectList(queryWrapper);
        if (entityList != null) {
            log.info("list size:{}", entityList.size());
        }
    }

}
