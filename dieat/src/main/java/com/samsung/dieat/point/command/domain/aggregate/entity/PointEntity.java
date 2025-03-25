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
