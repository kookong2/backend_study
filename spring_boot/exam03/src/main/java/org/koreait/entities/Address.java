package org.koreait.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder @NoArgsConstructor @AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    private String zipCode;
    private String address;
    private String addressSub;

    //@OneToOne
    //@JoinColumn(name="userNo")
    //private Member member;

}

