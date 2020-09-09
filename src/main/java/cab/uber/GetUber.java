package cab.uber;

import org.springframework.web.client.RestTemplate;

import cab.uber.dto.PriceEstimate;
import helper.Helper;

public class GetUber {
    private static final String baseUrl = "https://api.uber.com";
    private static final String priceEstimateEndpoint = "/v1.2/estimates/price";

    private String startLatitude;
    private String startLongitude;
    private String endLatitude;
    private String endLongitude;

    private PriceEstimate[] priceEstimates;
    
    private RestTemplate restTemplate;
    private Helper helper;

    // public GetUber(RestTemplate restTemplate) {
    //     this.restTemplate = new RestTemplate();
    // }

    public PriceEstimate[] getPriceEstimates(String startLatitude, String startLongitude, 
            String endLatitude, String endLongitude) {
        // validate location coordinates
        if (helper.isValidLocation(startLatitude, startLongitude, 
            endLatitude, endLongitude) == false) {
            return new PriceEstimate[0];
        }
        // get url to call
        String url = getPriceEstimateBaseUrl(startLatitude, startLongitude, 
            endLatitude, endLongitude);

        // restTemplate = new RestTemplate();
        // get data by making API call
        PriceEstimate[] priceEstimates = restTemplate.getForObject(
            url, PriceEstimate[].class); 
        return priceEstimates;
    }

    
    // public GetUber(String startLatitude, String startLongitude, String endLatitude, String endLongitude) {
    //     this.startLatitude = startLatitude;
    //     this.startLongitude = startLongitude;
    //     this.endLatitude = endLatitude;
    //     this.endLongitude = endLongitude;

    //     // get price estimate of journey for different Uber cab types
    //     this.priceEstimates = getPriceEstimates(startLatitude, startLongitude, endLatitude, endLongitude);
    // }

    public String getPriceEstimateBaseUrl(String startLatitude, String startLongitude, String endLatitude,
            String endLongitude) {
        String apiTemplate = baseUrl + priceEstimateEndpoint
                + "?start_latitude=$1&start_longitude=$2&end_latitude=$3&end_longitude=$4";
        String api = apiTemplate.replace("$1", startLatitude).replace("$2", startLongitude).replace("$3", endLatitude)
                .replace("$4", endLongitude);

        return api;
    }

    public String getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(String startLatitude) {
        this.startLatitude = startLatitude;
    }

    public String getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(String startLongitude) {
        this.startLongitude = startLongitude;
    }

    public String getEndLatitude() {
        return endLatitude;
    }

    public void setEndLatitude(String endLatitude) {
        this.endLatitude = endLatitude;
    }

    public String getEndLongitude() {
        return endLongitude;
    }

    public void setEndLongitude(String endLongitude) {
        this.endLongitude = endLongitude;
    }

    public PriceEstimate[] getPriceEstimates() {
        return priceEstimates;
    }

    public void setPriceEstimates(PriceEstimate[] priceEstimates) {
        this.priceEstimates = priceEstimates;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setHelper(Helper helper) {
        this.helper = helper;
    }

}