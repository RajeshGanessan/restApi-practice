package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

    @JsonProperty(value = "firstName")
    private String name;
    private int age;
    //    @JsonProperty(value = "Married")
    private boolean isMarried;
    private String address;
    private String mobileNo;

}
