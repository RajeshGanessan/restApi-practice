package pojo;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {

    private String streetName;
    private String city;
    private String state;
    private String country;
    private Boolean isLegal;



    public Boolean getIsLegal() {
        return isLegal;
    }

    public void setIsLegal(Boolean isLegal) {
        this.isLegal = isLegal;
    }
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
