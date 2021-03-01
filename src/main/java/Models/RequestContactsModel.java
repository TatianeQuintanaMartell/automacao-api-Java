package Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestContactsModel {
    private String name;
    private String lastName;
    private String email;
    private String age;
    private String phone;
    private String address;
    private String state;
    private String city;

    public RequestContactsModel() {
        this.name = "Tatiane";
        this.lastName = "quintana";
        this.email = "tati@gmail.com";
        this.age = "21";
        this.phone = "51983108310";
        this.address = "endereço";
        this.state = "RS";
        this.city = "VilaNova";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty("last_name") // sempre q o nome do campo for composto
    public String getLastName() {
        return lastName;
    }
    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
