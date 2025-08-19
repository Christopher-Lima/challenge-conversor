import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

public record ExchangeRate(
        String result, // "success" ou "error"
        @SerializedName("base_code") String baseCode,
        @SerializedName("target_code") String targetCode,
        @SerializedName("conversion_rate") BigDecimal conversionRate,
        @SerializedName("error-type") String errorType
) {}
