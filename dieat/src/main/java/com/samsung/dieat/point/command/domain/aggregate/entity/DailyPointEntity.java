<<<<<<< HEAD
package com.samsung.dieat.point.command.domain.aggregate.entity;

import com.samsung.dieat.member.command.domain.aggregate.entity.UserEntity;
import com.samsung.dieat.member.command.domain.aggregate.entity.UserInfoEntity;
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
@Table(name = "tbl_daily_point")
public class DailyPointEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "d_point_code")                                              // 포인트 적립 코드
    private int dPointCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "d_point_user_code", nullable = false)                   // 포인트 적립 받는 회원 코드
    private UserInfoEntity dPointUserCode;

    @Column(name = "d_point_rcv_amt", nullable = false, length = 10)         // 포인트 적립 양
    private int dPointRcvAmt = 0;

    @Column(name = "d_point_rcv_dt", nullable = false)                          // 포인트 적립 일시
    private LocalDateTime dPointRcvDt = LocalDateTime.now();

    @Enumerated(EnumType.STRING)                                                // 포인트 적립 대상 구분
//    @Column(name = "d_point_rcv_type", nullable = false)
    private PType dPointRcvType;

    @Column(name = "d_point_rcv_code", nullable = false, length = 1000)         // 포인트 적립 대상 코드
    private int dPointRcvCode;
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
//@Table(name = "tbl_daily_point")
//public class DailyPointEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "d_point_code")
//    private int d_point_code;
//
//    @ManyToOne
//    @JoinColumn(name = "d_point_user_code", nullable = false)
//    private Member member;
//
//    @Column(name = "d_point_rcv_amt", nullable = false, length = 50000)
//    private int d_point_rcv_amt;
//
//    @Column(name = "d_point_rcv_dt", nullable = false)
//    private LocalDateTime d_point_rcv_dt;
//
//    @Enumerated(EnumType.STRING)
////    @Column(name = "d_point_rcv_type", nullable = false)
//    private PType d_point_rcv_type;
//
//    @Column(name = "d_point_rcv_code", nullable = false, length = 1000)
//    private int d_point_rcv_code;
//}
>>>>>>> 2cbde92212667ea14e50afb39161f4db0b222b19
