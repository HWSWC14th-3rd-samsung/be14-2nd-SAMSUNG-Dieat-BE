package com.samsung.dieat.diet_post.command.domain.service;

import com.samsung.dieat.diet_post.command.domain.aggregate.entity.DietPost;
import org.springframework.stereotype.Service;

@Service
public class DietPostDomainService {

    /* 설명. 조회 수 증가 */
    public void increaseViewCount(DietPost dietPost) {
        dietPost.setDietViewCnt(dietPost.getDietViewCnt() + 1);
    }

    /* 설명. 좋아요 수 증가*/
    public void increaseLikeCount(DietPost dietPost) {
        dietPost.setDietLikeCnt(dietPost.getDietLikeCnt() + 1);
    }

    /* 설명. 댓글 수 증가 */
    public void increaseCommentCount(DietPost dietPost) {
        dietPost.setDietCmtCnt(dietPost.getDietCmtCnt() + 1);
    }

    /* 설명. 게시물 삭제(soft delete) */
    public void softDeleteDietPost(DietPost dietPost) {
        dietPost.setDietIsDeleted(true);
    }
}
