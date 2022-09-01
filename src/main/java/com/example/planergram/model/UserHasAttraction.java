package com.example.planergram.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "UserHasAttraction", sequenceName = "USER_has_ATTRACTION")
public class UserHasAttraction {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumnOrFormula(column = @JoinColumn(name = "user_has_attraction_user_id", referencedColumnName = "user_id"))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumnOrFormula(column = @JoinColumn(name = "user_has_attraction_attraction_id", referencedColumnName = "attraction_id"))
    private Attraction attraction;
}
