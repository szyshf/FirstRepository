package com.birght.hibernate.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.lang.model.type.NullType;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.NullableType;

import com.birght.comm.HibernateBaseDAO;

public class SQLQueryList extends HibernateBaseDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String sql = "select title,fwxx,shi  from TBL_FWXX";
		SQLQueryList queryList = new SQLQueryList();
		
		Map map = new HashMap<String, String>();
		map.put("title", Hibernate.STRING);
		map.put("fwxx", Hibernate.STRING);
		map.put("shi",null);
		List<Map<String, Object>> lists = queryList.sqlQuery(map, sql);
		queryList.print(lists);

	}

	private List sqlQuery(Map<String, NullableType> map, String sql,
			Object... objects) {
		SQLQuery query = getSession().createSQLQuery(sql);
		if (objects != null) {
			for (int i = 0; i < objects.length; i++) {
				query.setParameter(i, objects[i]);
			}
		}

		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		query.addScalar("title", Hibernate.STRING);
		query.addScalar("fwxx",Hibernate.STRING);
		query.addScalar("shi",Hibernate.INTEGER);
		return query.list();
	}

	private void print(List<Map<String, Object>> lists) {
		for(int i=0;i<lists.size(); i++){
			System.out.println("title---> " + lists.get(i).get("title"));
			System.out.println("fwxx----> " + lists.get(i).get("fwxx"));
			System.out.println("shi-----> " + lists.get(i).get("shi").getClass());
			System.out.println(lists.get(i).get("shi") instanceof Integer);
			
		}
	}

}
