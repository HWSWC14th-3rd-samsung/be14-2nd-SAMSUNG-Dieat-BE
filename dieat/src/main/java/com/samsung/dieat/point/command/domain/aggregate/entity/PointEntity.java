<<<<<<< HEAD
package com.samsung.dieat.point.command.domain.aggregate.entity;

import com.samsung.dieat.member.command.domain.aggregate.entity.UserEntity;
import com.samsung.dieat.point.command.domain.enums.PType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "tbl_point")
public class PointEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_code")                                        // 포인트 적립 코드
    private int pointCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "point_user_code", nullable = false)             // 포인트 적립 받는 회원 코드
    private UserEntity pointUserCode;      // 회원 정보 연관 관계 매핑

    @Column(name = "point_amt", nullable = false, length = 50000)       // 포인트 적립 양
    private int pointAmt = 0;

    @Column(name = "point_rcv_dt", nullable = false)                    // 포인트 적립 일시
    private LocalDateTime pointRcvDt;

    @Enumerated(EnumType.STRING)                                        // 포인트 적립 대상 구분
//    @Column(name = "point_rcv_type", nullable = false)
    private PType pointRcvType;

    @Column(name = "point_rcv_code", nullable = false, length = 1000)   // 포인트 적립 대상 코드
    private int pointRcvCode;

}
=======
package com.samsung.dieat.point.command.domain.aggregate.entity;//package com.samsung.dieat.point.command.domain.aggregate.entity;
//
//import com.samsung.dieat.point.command.domain.enums.PType;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.time.LocalDateTime;
//
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Table(name = "tbl_point")
//public class PointEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "point_code")
//    private int point_code;
//
//    @ManyToOne
//    @JoinColumn(name = "point_user_code", nullable = false)
//    private Member member;      // 회원 정보 연관 관계 매핑
//
//    @Column(name = "point_amt", nullable = false, length = 50000)
//    private int point_amt;
//
//    @Column(name = "point_rcv_dt", nullable = false)
//    private LocalDateTime point_rcv_dt;
//
//    @Enumerated(EnumType.STRING)
////    @Column(name = "point_rcv_type", nullable = false)
//    private PType point_rcv_type;
//
//    @Column(name = "point_rcv_code", nullable = false, length = 1000)
//    private int point_rcv_code;
//
//
//
//
//
//}
>>>>>>> d339f28b3cb67a1725d2aee13692e0949aa12d24
