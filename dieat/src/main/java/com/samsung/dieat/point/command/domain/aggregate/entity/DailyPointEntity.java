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
