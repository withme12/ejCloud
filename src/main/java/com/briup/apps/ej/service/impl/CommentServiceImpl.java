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
        CommentExample example=new CommentExample();
        return commentMapper.selectByExample(example);
    }
    @Override
    public Comment findCommentrById(Long id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insertOrUpdate(Comment comment) throws Exception {
        if(comment.getId()!=null){
            commentMapper.updateByPrimaryKey(comment);

        }else{
            commentMapper.insert(comment);
        }
    }

    @Override
    public void deleteCommentById(Long id) throws Exception {
            commentMapper.deleteByPrimaryKey(id);
    }



    @Override
    public List<Comment> query(Comment comment) {
        CommentExample example=new CommentExample();

        if(comment.getContent()!=null){
        example.
                createCriteria().
                andContentLike("%"+comment.getContent()+"%");
        }

        return commentMapper.selectByExample(example);
    }
    @Override
    public void batchDelete(long[] ids) throws Exception {
        for(long id:ids){
            commentMapper.deleteByPrimaryKey(id);
        }
    }
}
