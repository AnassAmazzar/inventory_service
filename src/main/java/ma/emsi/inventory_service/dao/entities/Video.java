package ma.emsi.inventory_service.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Video {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String url;
    private String description;
    //@Temporal(TemporalType.DATE)
    @Column(name = "datePublication", nullable = false)
    private LocalDate datePublication;
    @ManyToOne
    private Creator creator;


}
