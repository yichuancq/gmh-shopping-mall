import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.gmh.mail.common.utils.DateUtils;
import com.gmh.order.OrderServerApplication;
import com.gmh.order.domain.OrderEntity;
import com.gmh.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
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
    public void testInt() {
        //long id=1555000553766346753;
        BigDecimal id = BigDecimal.valueOf(Long.valueOf("1555000553766346753"));
        System.out.println(id);
    }

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

    @Test
    public void deleteById() {
        final BigInteger id = BigInteger.valueOf(Long.parseLong("1555025306950111233"));
        log.info("id:{}", id);
        boolean flag = orderService.removeById(id);
        log.info("flag:{}", flag);
    }

    /**
     *
     */
    @Test
    public void saveBatch() {
        List<OrderEntity> orderEntityList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String date = "2022-05-01 10:58:19";
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setId(BigInteger.valueOf(Long.parseLong(IdWorker.getIdStr())));
            orderEntity.setOrderNumber(i);
            Date crateTime = DateUtils.parseTime(date);
            Date updateTime = DateUtils.parseTime(date);
            orderEntity.setCreateTime(crateTime);
//        orderEntity.setCreateTime(new Date());
            orderEntity.setUpdateTime(updateTime);
            orderEntityList.add(orderEntity);
        }
        orderService.saveBatch(orderEntityList, 50);
    }

    /**
     *
     */
    @Test
    public void saveOne() {
        OrderEntity orderEntity = new OrderEntity();
        String date = "2022-07-04 10:58:19";
        orderEntity.setId(BigInteger.valueOf(Long.parseLong(IdWorker.getIdStr())));
        orderEntity.setOrderNumber(2);
        Date crateTime = DateUtils.parseTime(date);
        Date updateTime = DateUtils.parseTime(date);
        orderEntity.setCreateTime(crateTime);
//        orderEntity.setCreateTime(new Date());
        orderEntity.setUpdateTime(updateTime);
        orderService.save(orderEntity);
    }
}
