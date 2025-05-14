package models;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public record Rates(
        @SerializedName("conversion_rates")
        Map<String, Double> conversion_rates) {
    @Override
    public String toString() {
        return "teste : " + conversion_rates
                ;
    }
}
