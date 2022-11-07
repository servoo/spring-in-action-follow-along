package sia.tacocloud.controller;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import sia.tacocloud.data.JdbcOrderRepository;
import sia.tacocloud.model.Ingredient;
import sia.tacocloud.model.Taco;
import sia.tacocloud.model.TacoOrder;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@JdbcTest
@Sql({"classpath:schema.sql", "classpath:data.sql"})
class OrderControllerTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // TODO https://www.baeldung.com/spring-jdbctemplate-testing
    @Test
    public void testSaveTacoOrder() {
        JdbcOrderRepository orderRepository = new JdbcOrderRepository(jdbcTemplate);

        TacoOrder order = new TacoOrder();
        order.setId(1L);
        order.setPlacedAt(new Date());
        order.setDeliveryName("coolDeliveryName");
        order.setDeliveryStreet("coolStuff");
        order.setDeliveryCity("coolStuff");
        order.setDeliveryState("LA");
        order.setDeliveryZip("LA");
        order.setCcNumber("4716091694546587");
        order.setCcExpiration("01/28");
        order.setCcCVV("172");

        Taco taco = Taco
                .builder().name("TacoA").ingredients(List.of(new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP)))
                .build();
        ;
        order.setTacos(List.of(
                taco
        ));

        orderRepository.save(order);
    }

}
