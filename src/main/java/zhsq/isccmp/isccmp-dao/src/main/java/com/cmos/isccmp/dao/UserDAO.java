package com.cmos.isccmp.dao;

import com.cmos.isccmp.beans.UserDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDAO {
	UserDO selectByPrimaryKey(Long userId);

	int insertSelective(UserDO userDO);

	int updateByPrimaryKeySelective(UserDO userDO);

	int deleteUsers(@Param("userId") List<String> userIds, @Param("parentOrgId")Long parentOrgId);

	List<UserDO> selectByUserSelective(UserDO userDO);
	Map<String,String> getDetail(@Param("userId")Long userId,@Param("parentOrgId")Long parentOrgId);

	List<UserDO> selectEnabledUserByOrgIds(@Param("orgIds")List<Long> orgIds);
	List<UserDO> getUserByRnameAndMobile(UserDO userDO);
	List<UserDO> getUserByOrgIdRnameAndMobile(UserDO userDO);

}
