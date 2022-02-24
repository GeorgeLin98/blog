package com.george.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.george.blog.mapper.CommentMapper;
import com.george.blog.pojo.*;
import com.george.blog.service.ICommentsService;
import com.george.blog.service.ISysUserService;
import com.george.blog.util.ConstantUtil;
import com.george.blog.util.UserThreadLocal;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description 评论service实现类
 * @author georgeLin
 * @date 2022-01-11-21:39
 */
@Service
public class CommentsServiceImpl implements ICommentsService {
    @Resource
    private CommentMapper commentMapper;
    @Autowired
    private ISysUserService sysUserService;

    @Override
    public ResultVO commentsByArticleId(Long articleId) {
        LambdaQueryWrapper<CommentPO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CommentPO::getArticleId,articleId);
        queryWrapper.eq(CommentPO::getLevel,1);
        List<CommentPO> comments = commentMapper.selectList(queryWrapper);
        return ResultVO.success(copyList(comments));
    }

    @Override
    public ResultVO comment(CommentDTO commentDTO) {
        SysUserPO sysUserPO = UserThreadLocal.get();
        CommentPO comment = new CommentPO();
        comment.setArticleId(commentDTO.getArticleId());
        comment.setAuthorId(sysUserPO.getId());
        comment.setContent(commentDTO.getContent());
        comment.setCreateDate(System.currentTimeMillis());
        Long parent = commentDTO.getParent();
        if (parent == null || parent == 0) {
            comment.setLevel(1);
        }else{
            comment.setLevel(2);
        }
        comment.setParentId(parent == null ? 0 : parent);
        Long toUserId = commentDTO.getToUserId();
        comment.setToUid(toUserId == null ? 0 : toUserId);
        this.commentMapper.insert(comment);
        return ResultVO.success(null);
    }

    public CommentVO copy(CommentPO comment){
        CommentVO commentVo = new CommentVO();
        BeanUtils.copyProperties(comment,commentVo);
        //时间格式化
        commentVo.setCreateDate(new DateTime(comment.getCreateDate()).toString(ConstantUtil.DATE_TIME_FORMAT));
        Long authorId = comment.getAuthorId();
        UserVO userVo = sysUserService.findUserVoById(authorId);
        commentVo.setAuthor(userVo);
        //评论的评论
        List<CommentVO> commentVoList = findCommentsByParentId(comment.getId());
        commentVo.setChildrens(commentVoList);
        if (comment.getLevel() > ConstantUtil.COMMENT_FIRST_LEVEL) {
            Long toUid = comment.getToUid();
            UserVO toUserVo = sysUserService.findUserVoById(toUid);
            commentVo.setToUser(toUserVo);
        }
        return commentVo;
    }

    public List<CommentVO> copyList(List<CommentPO> commentList){
        List<CommentVO> commentVoList = new ArrayList<>();
        for (CommentPO comment : commentList) {
            commentVoList.add(copy(comment));
        }
        return commentVoList;
    }

    private List<CommentVO> findCommentsByParentId(Long id) {
        LambdaQueryWrapper<CommentPO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CommentPO::getParentId,id);
        queryWrapper.eq(CommentPO::getLevel,2);
        List<CommentPO> comments = this.commentMapper.selectList(queryWrapper);
        return copyList(comments);
    }
}
