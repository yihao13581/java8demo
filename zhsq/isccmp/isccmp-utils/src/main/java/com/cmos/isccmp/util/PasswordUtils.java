package zhsq.isccmp.isccmp-utils.src.main.java.com.cmos.isccmp.util;
import com.cmos.common.datasource.DataSourcePasswordCrypto;
import com.cmos.common.security.CryptionException;
/**
 * @CLassName TestClass
 * @Description: TODO
 * @date: 2020/1/13 17:37
 * @Version 1.0
 */
public class PasswordUtils {
    public static void encryAndDecry() throws CryptionException{
        DataSourcePasswordCrypto d=new DataSourcePasswordCryPto();
        System.out.println(d.encrypt(""));
        System.out.println(d.decrypt(""));
    }
	public static void main(String[] args) throws Exception {
	    encryAndDecry();
	}
}
