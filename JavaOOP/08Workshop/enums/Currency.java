package enums;

import java.math.BigDecimal;

public enum Currency {

    BGN(new BigDecimal(1)),
    EUR(new BigDecimal(1.95)),
    USD(new BigDecimal(1.55));

    private BigDecimal rateToBGN;

    private Currency(BigDecimal rateToBGN) {
        this.rateToBGN = rateToBGN;
    }

    public BigDecimal getRateToBGN() {
        return this.rateToBGN;
    }
    
}