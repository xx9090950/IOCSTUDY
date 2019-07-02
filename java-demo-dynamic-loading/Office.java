class Office{
	public static void  main(String[] arg){
		if("word".equals(arg[0])){
			Word w=new Word();
			w.start();
		}
		if("excel".equals(arg[0])){
			Excel e=new Excel();
			e.start();
		}
	}
}