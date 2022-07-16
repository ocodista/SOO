package br.unesp.agrotech.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorMessage implements Serializable {

    @JsonProperty("id")
    private int id;

    @JsonProperty("value")
    private double value;

    @JsonProperty("label")
    private String label;

    @JsonProperty
    private Date sentAt;

    private DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    @Override
    public String toString() {
        return "[" + formatter.format(sentAt) + "] Sensor " + id +": " + value + " " + label;
    }
}
