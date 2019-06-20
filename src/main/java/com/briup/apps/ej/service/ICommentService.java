package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();
    Comment findCommentrById(Long id);
    void insertOrUpdate(Comment comment)throws Exception;
    void deleteCommentById(Long id) throws Exception;
    List<Comment> query(Comment comment);
    void batchDelete(long[] ids)throws Exception;
}
