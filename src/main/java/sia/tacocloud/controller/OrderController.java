package sia.tacocloud.controller;

import javax.validation.Valid;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;
import sia.tacocloud.data.OrderRepository;
import sia.tacocloud.model.TacoOrder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Component
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
@AllArgsConstructor
public class OrderController {

    private OrderRepository orderRepo;

    @GetMapping(value = "/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping()
    public String processOrder(@Valid TacoOrder order, Errors error, SessionStatus sessionStatus) {

        if (error.hasErrors()) {
            return "orderForm";
        }

        log.info("Order submitted: {}", order);
        this.orderRepo.save(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
