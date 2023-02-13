package mall.domain;

import mall.domain.*;
import mall.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class InventoryDecrease extends AbstractEvent {

    private Long id;
    private String productName;
    private Integer stock;

    public InventoryDecrease(Inventory aggregate){
        super(aggregate);
    }
    public InventoryDecrease(){
        super();
    }
}
