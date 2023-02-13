package mall.domain;

import mall.domain.*;
import mall.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class InventoryIncrease extends AbstractEvent {

    private Long id;
    private String productName;
    private Integer stock;

    public InventoryIncrease(Inventory aggregate){
        super(aggregate);
    }
    public InventoryIncrease(){
        super();
    }
}
