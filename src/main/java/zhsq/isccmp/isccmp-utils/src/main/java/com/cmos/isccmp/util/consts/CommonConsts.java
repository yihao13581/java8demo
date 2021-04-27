package com.cmos.isccmp.util.consts;

public interface CommonConsts {
	//有效标识
	String VALID_FLAG_TRUE="1";//有效
	String VALID_FLAG_FALSE="0";//无效

	String NOTICE_TABLE_NAME="t_isccmp_note";//公告表名
	String NOTICE_DEVICE_TABLENAME="t_isccmp_note_device";

	Integer BATCH_MAX_VALUE=2000;//批量操作最大值
	String USER_PASSWORD="cmos_10086";//用户默认密码
	String AES_KEY_DEFAULT="cmosiegs";//加解密密钥

	//session用户
	String SESSION_USER="sessionUser";

	public interface PRSN_TYPR{
		String ROOM_OWNER="1";//业主
		String ROOM_OWNER_MEMBER="2";//业主成员
		String ROOM_TENEMENT="3";//租户
	}

	//重启设备，时间间隔限制10分钟（10*60）
	public static final Integer REDIS_DEVICE_REBOOT_TIME=10*60;
	public static final String REDIS_DEVICE_REBOOT_PREFIX="DEVICE_RESTART";

}
