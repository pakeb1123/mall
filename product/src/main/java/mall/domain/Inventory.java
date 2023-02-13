package mall.domain;

import mall.domain.InventoryIncrease;
import mall.domain.InventoryDecrease;
import mall.ProductApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Inventory_table")
@Data

public class Inventory  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String productName;
    
    
    
    
    
    private Integer stock;

    @PostUpdate
    public void onPostUpdate(){


        InventoryIncrease inventoryIncrease = new InventoryIncrease(this);
        inventoryIncrease.publishAfterCommit();



        InventoryDecrease inventoryDecrease = new InventoryDecrease(this);
        inventoryDecrease.publishAfterCommit();

    }

    public static InventoryRepository repository(){
        InventoryRepository inventoryRepository = ProductApplication.applicationContext.getBean(InventoryRepository.class);
        return inventoryRepository;
    }




    public static void inventoryDecrease(DeliveryCompleted deliveryCompleted){

        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        InventoryDecrease inventoryDecrease = new InventoryDecrease(inventory);
        inventoryDecrease.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCompleted.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);

            InventoryDecrease inventoryDecrease = new InventoryDecrease(inventory);
            inventoryDecrease.publishAfterCommit();

         });
        */

        
    }
    public static void inventoryIncrease(DeliveryReturned deliveryReturned){

        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        InventoryIncrease inventoryIncrease = new InventoryIncrease(inventory);
        inventoryIncrease.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryReturned.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);

            InventoryIncrease inventoryIncrease = new InventoryIncrease(inventory);
            inventoryIncrease.publishAfterCommit();

         });
        */

        
    }


}
