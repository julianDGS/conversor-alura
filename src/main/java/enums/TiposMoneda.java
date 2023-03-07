package enums;


/**
 *
 * @author Julian
 */
public enum TiposMoneda {
    COP(4702.1F),
    EUR(0.93528F),
    USD(1.0F),
    CAD(1.3607F),
    JPY(135.97F),
    BRL(5.1544F),
    GBP(0.83019F);
    
    private final Float valor;

    TiposMoneda(Float valor) {
        this.valor = valor;
    }

    public Float getValor() {
        return this.valor;
    }
    
}
