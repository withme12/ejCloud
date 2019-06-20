package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.bean.extend.OrderExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findCustomerById(Long id);
    void insertOrUpdate(Customer customer)throws Exception;
    void deleteCustomerById(Long id) throws Exception;
    List<Customer> query(Customer customer);
    void batchDelete(long[] ids)throws Exception;
    List<OrderExtend> findOrderAllMessageById(Long id);
    List<OrderExtend> query2(Long customerId, Long waiterId)throws Exception;
   // List<CustomerExtend> selectAllWithTeacher();

   // List<StudentCourseExtend> selectCourseWithTeacherAndStudentAndGradeById(Long id);
}
