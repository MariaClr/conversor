package models;

public class Moeda {
    private Double dolar;
    private Double real;
    private Double argentino;
    private Double colombiano;

    public Moeda(Rates dtoRates){
        this.dolar = dtoRates.conversion_rates().get("USD");
        this.argentino = dtoRates.conversion_rates().get("ARS");
        this.real = dtoRates.conversion_rates().get("BRL");
        this.colombiano = dtoRates.conversion_rates().get("COP");
    }

    public Double getDolar() {
        return dolar;
    }


    public Double getReal() {
        return real;
    }


    public Double getArgentino() {
        return argentino;
    }


    public Double getColombiano() {
        return colombiano;
    }


    @Override
    public String toString() {
        return "Moeda{" +
                "dolar=" + dolar +
                ", real=" + real +
                ", argentino=" + argentino +
                ", colombiano=" + colombiano +
                '}';
    }
}
