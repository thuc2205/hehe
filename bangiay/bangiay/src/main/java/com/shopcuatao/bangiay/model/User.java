package com.shopcuatao.bangiay.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Builder
public class User extends BaseCreated{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private int status;

    @Column(name = "birth")
    private Date birth;

    @Column(name = "facebook_id")
    private int facebookId;

    @Column(name = "google_id")
    private int googleId;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role roleId;


}
