package com.example.shiyouge.utils;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@MappedJdbcTypes(JdbcType.DATE)
@MappedTypes(String.class)
public class DateTypeHandler implements TypeHandler<String> {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        return sdf.format(rs.getDate(columnName));
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        return sdf.format(rs.getDate(columnIndex));
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return sdf.format(cs.getDate(columnIndex));
    }

//    public static void main(String[] args) {
//        java.util.Date date = new Date();
//        Timestamp createTime =  new Timestamp(date.getTime());
//        System.out.println(createTime);
//    }
}
