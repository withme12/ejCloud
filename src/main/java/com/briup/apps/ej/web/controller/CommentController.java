package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.service.ICommentService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "评论管理接口")
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;


    @ApiOperation("查找所有评论")
    @GetMapping("findAll")
    public Message findAll() {
        List<Comment> list = commentService.findAll();
        return MessageUtil.success("success", list);
    }

    @ApiOperation("（ID自动生成，请勿输入ID）保存或更新评论信息")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(Comment comment) throws Exception {
        commentService.saveOrUpdate(comment);
        return MessageUtil.success("保存成功");
    }

    @ApiOperation("通过ID删除用户评论")
    @GetMapping("deleteById")
    public Message deleteById(Long id) {
        try {
            commentService.deleteById(id);
            return MessageUtil.success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("通过ID查找用户评论")
    @GetMapping("selectById")
    public Message selectById(Long id) {
        Comment comment = commentService.selectById(id);
        if (comment == null)
            return MessageUtil.error("无评论");
        else {
            return MessageUtil.success("查找成功", comment);
        }
    }
    @ApiOperation("批量删除（数据用“,”隔开）")
    @PostMapping("batchDelete")
    public Message batchDelete(long[] ids) throws Exception{
        commentService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }

}