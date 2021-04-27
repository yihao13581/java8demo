package com.cmos.isccmp.util.consts;

public class CacheConsts {
	//各系统公用工具类中的开关key前缀
	public static final String  CACHE_SWITCH_PREFIX="CMP_SWITCH:";

	/**
	 * 接入运营管理中心管理的JVM缓存Key值管理
	 * 键值命名规则：系统名_业务名：自定义key
	 * 由运营管理中心与业务应用在命名规则的基础上进行约自行约定
	 * 示例：
	 * 新旧人脸特征值提取算法开关值
	 * SF_VERSION_UPGRADE
	 */
	public interface JVM{
		//新旧人脸特征值提取算法开关值
		String SF_VERSION_UPGRADE=CACHE_SWITCH_PREFIX+"SF_VERSION_UPGRADE";
	}
}
