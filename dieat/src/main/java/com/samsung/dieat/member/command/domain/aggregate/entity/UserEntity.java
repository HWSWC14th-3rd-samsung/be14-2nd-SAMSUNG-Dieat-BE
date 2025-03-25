package com.samsung.dieat.member.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity  // 이 어노테이션을 추가
@Table(name = "tbl_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_code")
    private int userCode;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_pwd")
    private String userPwd;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_tel")
    private String userTel;

    @Column(name = "user_gender")
    private String userGender;

    @Column(name = "user_birthday")
    private String userBirthday;

    @Column(name = "user_role")
    private String userRole;

}