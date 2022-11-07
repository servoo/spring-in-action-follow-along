package sia.tacocloud.controller;

import org.springframework.context.annotation.Configuration;
import sia.tacocloud.data.JdbcOrderRepository;
import sia.tacocloud.model.Ingredient;
import sia.tacocloud.model.Taco;
import sia.tacocloud.model.TacoOrder;

import java.util.Date;
import java.util.List;

@Configuration
public class StartupConfig {

    public StartupConfig(JdbcOrderRepository orderRepository) {
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

        Taco taco1 = Taco
                .builder()
                .createdAt(new Date())
                .name("TacoA")
                .ingredients(List.of(
                        new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                        new Ingredient("GRBF", "Corn Tortilla", Ingredient.Type.PROTEIN),
                        new Ingredient("TMTO", "Corn Tortilla", Ingredient.Type.VEGGIES)
                ))
                .build();

        Taco taco2 = Taco
                .builder()
                .createdAt(new Date())
                .name("TacoA")
                .ingredients(List.of(
                        new Ingredient("CHED", "Corn Tortilla", Ingredient.Type.WRAP),
                        new Ingredient("SLSA", "Corn Tortilla", Ingredient.Type.PROTEIN)
                ))
                .build();

        order.setTacos(List.of(
                taco1,
                taco2
        ));

        orderRepository.save(order);
    }
}
