package com.samsung.dieat.point.command.application.service;

import com.samsung.dieat.member.command.domain.aggregate.entity.UserInfoEntity;
import com.samsung.dieat.member.command.domain.repository.UserInfoRepository;
import com.samsung.dieat.point.command.domain.aggregate.entity.DailyPointEntity;
import com.samsung.dieat.point.command.domain.aggregate.entity.PointEntity;
import com.samsung.dieat.point.command.domain.enums.PType;
import com.samsung.dieat.point.command.domain.repository.DailyPointRepository;
import com.samsung.dieat.point.command.domain.repository.PointRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PointService {

    private final DailyPointRepository dailyPointRepository;
    private final PointRepository pointRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PointService(DailyPointRepository dailyPointRepository, PointRepository pointRepository, ModelMapper modelMapper) {
        this.dailyPointRepository = dailyPointRepository;
        this.pointRepository = pointRepository;
        this.modelMapper = modelMapper;
    }

    public void addPoints(int userCode, int point, PType pType) {
      DailyPointEntity dailyPoint = DailyPointEntity.builder()
              .dPointUserCode(userCode)
              .dPointRcvAmt(point)
              .dPointRcvType(pType)
              .build();

        switch (pType) {
            case REGIST_USERFOOD:
                dailyPointRepository.save(dailyPoint);
                break;
            case ACCURATE_USERFOOD:
                dailyPointRepository.save(dailyPoint);
                break;
            case REVIEW_USERFOOD:
                dailyPointRepository.save(dailyPoint);
                break;
            case MEAL:
                dailyPointRepository.save(dailyPoint);
                break;
            case DIET:
                dailyPointRepository.save(dailyPoint);
                break;
            case FREE:
                dailyPointRepository.save(dailyPoint);
                break;
            case SUCCESS:
                dailyPointRepository.save(dailyPoint);
                break;
            default:
                throw new IllegalAccessError("존재하지 않는 포인트 지급 유형입니다.");
        }
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void updateTotalPoint() {
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
        List<DailyPointEntity> pointRecords = dailyPointRepository.findByCreatedAtBefore(yesterday);

        if(!pointRecords.isEmpty()) {
            List<PointEntity> totalList = pointRecords.stream()
                    .map(record ->
                            modelMapper.map(record, PointEntity.class))
                    .collect(Collectors.toList());

            pointRepository.saveAll(totalList);
            dailyPointRepository.deleteAll(pointRecords);
        }
    }
}
