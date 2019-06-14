package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.bean.CommentExample;
import com.briup.apps.ej.dao.CommentMapper;
import com.briup.apps.ej.service.ICommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<Comment> findAll() {
        CommentExample example = new CommentExample();
        return commentMapper.selectByExample(example);
    }

    @Override
    public Comment selectById(Long id){
        return commentMapper.selectByPrimaryKey(id);

    }
    @Override
    public int saveOrUpdate(Comment comment){
        //id自动生成
        if(comment.getId()== null) {
            return commentMapper.insert(comment);
        }else {
            return commentMapper.updateByPrimaryKey(comment);
        }

    }


    @Override
    public int deleteById(Long id) throws Exception{
        if (id == null) {
            throw new Exception("要删除的用户不存在");
        } else {
            return commentMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void batchDelete(long[] ids) throws Exception {
        for(long id : ids){
            commentMapper.deleteByPrimaryKey(id);
        }

    }

}
