package com.cmos.isccmp.iservice;

import com.cmos.isccmp.beans.UserDO;
import com.github.pagehelper.PageInfo;

import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

/**
 * @CLassName IUserSV
 * @Description: TODO
 * @date: 2020/7/21 14:41
 * @Version 1.0
 */
public interface IUserSV {
	PageInfo<UserDO> selectByUserSelective(UserDO userDO);

	int updateUser(UserDO userDO) throws Exception;

	int deleteUsers(Long userId) throws Exception;

	UserDO selectByPrimaryKey(Long userId);

	Map<String,String> getDetail(Long userId) throws Exception;
	Map<String,String> getDetail(Long userId,Long parentOrgId) throws Exception;

	List<UserDO> getUserByOrgIds(List<Long> orgIds) throws Exception;
	List<UserDO> getUserByRnameAndMobile(UserDO userDO) throws Exception;
	List<UserDO> getUserByOrgIdRnameAndMobile(UserDO userDO) throws Exception;


}
