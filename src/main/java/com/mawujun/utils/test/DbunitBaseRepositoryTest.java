package com.mawujun.utils.test;

/**
 * 娴ｈ法鏁bunit鏉╂稖顢戦弫鐗堝祦閻ㄥ嫰鍣哥純锟�
 * @author mawujun
 *
 */
public class DbunitBaseRepositoryTest {
//	protected static IDatabaseConnection dbConn;
//	/**
//	 * 閺嶈宓乭ibernate閻ㄥ嫰鍘ょ純顔煎灥婵瀵查弫鐗堝祦鎼存捁绻涢幒锟�
//	 * @author mawujun email:160649888@163.com qq:16064988
//	 * @param pfile
//	 */
//	public  static void initHibernate(String pfile) {
//		try {
//			PropertiesUtils aa=PropertiesUtils.load(pfile);//new PropertiesUtils();
//			//aa.load(pfile);//閸旂姾娴囬柊宥囩枂閺傚洣娆㈡稉顓犳畱閺佺増宓佸┃鎰版懠閹恒儰淇婇幁锟�
//			//;
//
//			//閺堫兛绶ユ担璺ㄦ暏postgresql閺佺増宓佹惔锟� 
//			Class.forName(aa.getProperty("hibernate.connection.driver_class"));
//			//鏉╃偞甯碊B 
//			Connection conn=DriverManager.getConnection(aa.getProperty("hibernate.connection.url"),
//					aa.getProperty("hibernate.connection.username"),
//					aa.getProperty("hibernate.connection.password"));
//			//閼惧嘲绶盌B鏉╃偞甯�
//			dbConn =new DatabaseConnection(conn);
//			} catch(Exception e){
//				e.printStackTrace();
//			}
//	}
//	
//	/**
//	 * 閺嶈宓佹导鐘插弳閻ㄥ嫮鏁ら幋宄版倳鐎靛棛鐖滅粵澶屾畱闁板秶鐤嗛崚婵嗩潗閸栨牗鏆熼幑顔肩氨鏉╃偞甯�
//	 * @author mawujun email:160649888@163.com qq:16064988
//	 * @param pfile
//	 */
//	public  static void init(String driver,String url,String usernam,String password){
//		if(dbConn!=null){
//			return;
//		}
//		try {
//			//PropertiesUtils aa=new PropertiesUtils();
//			//aa.load(pfile);//閸旂姾娴囬柊宥囩枂閺傚洣娆㈡稉顓犳畱閺佺増宓佸┃鎰版懠閹恒儰淇婇幁锟�
//			//;
//
//			//閺堫兛绶ユ担璺ㄦ暏postgresql閺佺増宓佹惔锟� 
//			Class.forName(driver);
//			//鏉╃偞甯碊B 
//			Connection conn=DriverManager.getConnection(url,
//					usernam,
//					password);
//			//閼惧嘲绶盌B鏉╃偞甯�
//			dbConn =new DatabaseConnection(conn);
//			} catch(Exception e){
//				e.printStackTrace();
//			}
//	}
//	/**
//	 * 閺嶈宓侀柊宥囩枂婵傜晫娈慏ataSource閻ㄥ嫰鍘ょ純顔煎灥婵瀵查弫鐗堝祦鎼存捁绻涢幒锟�
//	 * @author mawujun email:160649888@163.com qq:16064988
//	 * @param pfile
//	 */
//	public  static void initDataSource(DataSource dataSource){
//		if(dbConn!=null){
//			return;
//		}
//		try {
// 
//			Connection conn=dataSource.getConnection();
//			dbConn =new DatabaseConnection(conn);
//			} catch(Exception e){
//				e.printStackTrace();
//			}
//	}
//
//	public static IDatabaseConnection getDbConn() {
//		return dbConn;
//	}
	
}
