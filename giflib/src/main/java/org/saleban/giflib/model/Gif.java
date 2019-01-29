package org.saleban.giflib.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Gif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime dateUploaded = LocalDateTime.now();
    private String username = "sale";
    private int favorite;
    private int categoryId;
    private String hash;
    @ManyToOne
    private Category category;
    @Lob
    private byte[] bytes;

    public String getTimeSinceUploaded() {
        String unit = "";
        LocalDateTime now = LocalDateTime.now();
        long diff;
        if((diff = ChronoUnit.SECONDS.between(dateUploaded,now)) < 60){
            unit = "secs";
        } else if ((diff = ChronoUnit.MINUTES.between(dateUploaded,now)) < 60) {
            unit = "mins";
        } else if ((diff = ChronoUnit.HOURS.between(dateUploaded,now)) < 24) {
            unit = "hours";
        } else if ((diff = ChronoUnit.DAYS.between(dateUploaded,now)) < 30) {
            unit = "days";
        } else if ((diff = ChronoUnit.MONTHS.between(dateUploaded,now)) < 12) {
            unit = "months";
        } else{
            diff = ChronoUnit.YEARS.between(dateUploaded,now);
        }
        return String.format("%d %s",diff,unit);
    }
}
