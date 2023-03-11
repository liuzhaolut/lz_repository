package com.person.daoimpl.recruit;

import com.person.dao.recruit.RucruitDao;
import com.person.pojo.Recruit;
import com.person.util.DaoUtils;
import com.person.util.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 高丽芳
 * 招聘管理-数据库操作：接口实现类
 */
public class RecruitDaoImpl extends DaoUtils implements RucruitDao {
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;

    /**
     * 查询所有招聘信息
     *
     * @return 返回所有招聘信息
     */
    @Override
    public List<Recruit> getAllRecruit() {
        try {
            con= DbUtils.getConnection();
            pst=con.prepareStatement("select * from recruit");
            rs=pst.executeQuery();
            List<Recruit>list=new ArrayList<Recruit>();
            while (rs.next()){
                int reId= rs.getInt("re_id");
                String reName= rs.getString("re_name");
                int reCount=rs.getInt("re_count");
                double reSal=rs.getDouble("re_sal");
                String reRequirt= rs.getString("re_requirt");
                Recruit recruit=new Recruit(reId,reName,reCount,reSal,reRequirt);
                list.add(recruit);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    /**
     * 删除操作
     * @param reId 招聘id
     * @return 返回是否删除成功
     */
    @Override
    public boolean delRecurit(int reId) {
        try {
            con=DbUtils.getConnection();
            pst=con.prepareStatement("delete from recruit where re_Id=?");
            pst.setInt(1,reId);
            int i=pst.executeUpdate();
            if (i>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    /**
     * 新增招聘信息
     *
     * @param recruit 招聘信息
     * @return 饭后新增的条数
     */
    @Override
    public int insertRecruit(Recruit recruit) {
        String sql="insert into recruit(re_name,re_count,re_sal,re_requirt) values(?,?,?,?)";
        Object[] objects={recruit.getReName(),recruit.getReCount(),recruit.getReSal(),recruit.getReRequirt()};
        int result = super.exeUpdate(sql,objects);
        return result;
    }

    /**
     * 查询单个招聘信息
     * @param reName 招聘职位
     * @return 返回招聘信息
     */
    @Override
    public Recruit findRecruit(String reName) {
        String sql="select * from recruit where re_name=?";
        Object[] objects={reName};
        Recruit recruit=null;
        try {
            ResultSet resultSet=super.exeQuery(sql,objects);
            if(resultSet.next()){
                int reId= resultSet.getInt("re_id");
                String reName1= resultSet.getString("re_name");
                int reCount=resultSet.getInt("re_count");
                double reSal=resultSet.getDouble("re_sal");
                String reRequirt= resultSet.getString("re_requirt");
                recruit=new Recruit(reId,reName1,reCount,reSal,reRequirt);
            }
            return recruit;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 修改-回显信息
     *
     * @param reId 招聘id
     * @return 返回招聘信息
     */
    @Override
    public Recruit getRecruitById(int reId) {
        try {
            con= DbUtils.getConnection();
            pst=con.prepareStatement("select * from recruit where re_id=?");
            pst.setInt(1,reId);
            rs=pst.executeQuery();
            while (rs.next()){
                return new Recruit(rs.getInt("re_id"),
                        rs.getString("re_name"),
                        rs.getInt("re_count"),
                        rs.getDouble("re_sal"),
                        rs.getString("re_requirt")
                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 修改招聘信息
     * @param recruit 招聘信息
     * @return 返回是否修改成功
     */
    @Override
    public boolean upRecruit(Recruit recruit) {
        try {
            con=DbUtils.getConnection();
            pst=con.prepareStatement("update  recruit set re_name=?,re_count=?,re_sal=?,re_requirt=?"+" where re_id=?");
            pst.setString(1,recruit.getReName());
            pst.setInt(2,recruit.getReCount());
            pst.setDouble(3,recruit.getReSal());
            pst.setString(4,recruit.getReRequirt());
            pst.setInt(5,recruit.getReId());
            int i=pst.executeUpdate();
            if (i>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.close(con,pst,rs);
        }
        return false;
    }

    /**
     * 清空招聘信息
     * @return 返回是否清空所有招聘信息
     */
    @Override
    public boolean deleteAllRecruit() {
        try {
            con=DbUtils.getConnection();
            pst=con.prepareStatement("delete from recruit ");
            int i=pst.executeUpdate();
            if (i>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


}
