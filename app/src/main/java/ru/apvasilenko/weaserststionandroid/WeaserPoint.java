package ru.apvasilenko.weaserststionandroid;

import java.util.GregorianCalendar;


public class WeaserPoint {
    GregorianCalendar datetime;
    Double t_boller;
    Double t_home;
    Double t_street;

    public WeaserPoint() {
        this.datetime = new GregorianCalendar();
        this.t_boller = 0.0;
        this.t_home = 0.0;
        this.t_street = 0.0;
    }
    public WeaserPoint(GregorianCalendar datetime, Double t_boller, Double t_home,Double t_street) {
        this.datetime = datetime;
        this.t_boller = t_boller;
        this.t_home = t_home;
        this.t_street = t_street;
    }

}
