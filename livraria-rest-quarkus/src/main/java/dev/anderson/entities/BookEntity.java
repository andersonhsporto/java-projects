package dev.anderson.entities;

import dev.anderson.types.StatusEnum;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private String title;
    private int releaseYear;
    private BigDecimal unitPrice;
    private BigDecimal promotionalPrice;
    private int unitsInStock;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    public void setPromotionalPrice() {
        if (this.unitPrice != null) {
            this.promotionalPrice = this.status.calculaValorPromocional(unitPrice);
        }
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
