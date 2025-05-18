package org.datasource.jdbc.views.customerdetails;

import lombok.Value;

@Value
public class PlatiView {
    private Integer Id;
    private String metoda;
    private Double suma;
    private String data_plata;
}
