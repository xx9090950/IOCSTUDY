class OfficeBetter{
	public static void main(String[] arg){
		try{
		//使用forname方法获取到传入的类名的类类型
		Class c=Class.forName(arg[0]);
		//获取类类型的实例
		OfficeAble oa=(OfficeAble)c.newInstance();
		//运行实例
		oa.start();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}