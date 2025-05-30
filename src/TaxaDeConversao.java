import java.util.Map;

public record TaxaDeConversao  (String result,
                              String documentation,
                              String terms_of_use,
                              long time_last_update_unix,
                              String time_last_update_utc,
                              long time_next_update_unix,
                              String time_next_update_utc,
                              String base_code,
                              Map<String, Double> conversion_rates)

{
    @Override
    public String toString() {
        return "Moeda{" +
                "result='" + result + '\'' +
                ", documentation='" + documentation + '\'' +
                ", terms_of_use='" + terms_of_use + '\'' +
                ", time_last_update_unix=" + time_last_update_unix +
                ", time_last_update_utc='" + time_last_update_utc + '\'' +
                ", time_next_update_unix=" + time_next_update_unix +
                ", time_next_update_utc='" + time_next_update_utc + '\'' +
                ", base_code='" + base_code + '\'' +
                ", conversion_rates=" + conversion_rates +
                '}';
    }


}
