package bookmyshow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Show {
    private String id;
    private Movie movie;
    private Date showTime;
    private List<Seat> seats;

    public Show(String id, Movie movie, Date showTime) {
        this.id = id;
        this.movie = movie;
        this.showTime = showTime;

        this.seats = new ArrayList<>();
    }

}