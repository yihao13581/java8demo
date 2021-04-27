package zhsq.isccmp.isccmp-utils.src.main.java.com.cmos.isccmp.util;

/**
 * @CLassName TestClass
 * @Description: TODO
 * @date: 2020/1/13 17:37
 * @Version 1.0
 */
public class TestClass {
	public static void main(String[] args) throws Exception {
		String strAddr= com.cmos.isccmp.util.Base64.encode("oNest_P/captureImage/ISCDAS/202001/2019101217021900004/2020011315413583785002_1.jpg".getBytes("UTF-8"));
		System.out.println(strAddr);
//		String  decodeAddr=Base64.decode("b05vc3RzUC9QYXBhdXJ1EW1JZ2VnEVNJREFELzIvMjAyME8xMDEwMTAxMjEy MDIwOTA5MDAwLzIvMjAyMTExMTUxMTMxODM4ODU4MDIwME4xcGc=");
//		System.out.println(decodeAddr);
	}
}
