package org.spring.action.spitter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Spittle {
    private Long id;
    private String message;
    private Date time;
    private Double lattitude;
    private Double longitude;

    public Spittle(Long id, String message, Date time, Double lattitude, Double longitude) {
        this.id = id;
        this.message = message;
        this.time = time;
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getLattitude() {
        return lattitude;
    }

    public void setLattitude(Double lattitude) {
        this.lattitude = lattitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((time == null) ? 0 : time.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Spittle other = (Spittle) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (time == null) {
            if (other.time != null)
                return false;
        } else if (!time.equals(other.time))
            return false;
        return true;
    }

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.get(Calendar.YEAR -100);
        SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
        sdf.get2DigitYearStart();
        }
}
