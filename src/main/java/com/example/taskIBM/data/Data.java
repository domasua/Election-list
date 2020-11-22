package com.example.taskIBM.data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    private String vrt_pav;
    private String rink_data;
    private int id;

    public Data(){

    }

    public String getVrt_pav() {
        return vrt_pav;
    }

    public void setVrt_pav(String vrt_pav) {
        this.vrt_pav = vrt_pav;
    }

    public String getRink_data() {
        return rink_data;
    }

    public void setRink_data(String rink_data) {
        this.rink_data = rink_data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

