package compra;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Builder(toBuilder = true)
public class Compra {
    private List<Item> itemList;

    public BigDecimal getTotal() {
        return itemList.stream()
                .map(Item::getValue)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }
}
