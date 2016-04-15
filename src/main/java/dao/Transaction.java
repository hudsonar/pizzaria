package dao;

import dao.impl.EM;

public class Transaction {
	
	public static void begin(){
		EM.getlocalEm().getTransaction().begin();
	}
	
	public static void commit(){
		EM.getlocalEm().getTransaction().commit();
	}
	
	public static void rollback(){
		EM.getlocalEm().getTransaction().rollback();
	}
	
	public static boolean isActive(){
		return EM.getlocalEm().getTransaction().isActive();
	}
}
