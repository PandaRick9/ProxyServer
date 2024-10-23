package by.baraznov.proxyserver.models;

import jakarta.validation.constraints.NotEmpty;

import java.lang.annotation.Native;

public class Admin {

    @NotEmpty
    private String filter;
    @NotEmpty
    private String masking;

    public Admin(){}
    public Admin(String filter, String masking) {
        this.filter = filter;
        this.masking = masking;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getMasking() {
        return masking;
    }

    public void setMasking(String masking) {
        this.masking = masking;
    }

    @Override
    public String toString() {
        return "Admin{" +
                ", filter='" + filter + '\'' +
                ", masking='" + masking + '\'' +
                '}';
    }
}
