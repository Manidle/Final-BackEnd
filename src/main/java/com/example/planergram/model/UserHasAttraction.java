package com.example.planergram.model;

import lombok.*;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Entity
@Table(name = "userhasattraction")
public class UserHasAttraction {

    @Id
    @Column(name="userHasAttractionId",nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userHasAttractionId;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private Long userId;

    @ManyToOne(targetEntity = Attraction.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "attractionId")
    private Long attractionId;
}
