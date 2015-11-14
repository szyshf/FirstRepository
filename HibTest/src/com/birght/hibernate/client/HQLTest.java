package com.birght.hibernate.client;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.birght.comm.HibernateBaseDAO;
import com.birght.hibernate.entity.FWXXModel;
import com.birght.hibernate.entity.JDModel;

public class HQLTest extends HibernateBaseDAO {

	/**
	 * @param args
	 */
	// 瀵硅薄鏌ヨ
	public void testBaseQuery() {
		Session session = getSession();
		String hql = "FROM FWXXModel";
		Query query = session.createQuery(hql);
		List<FWXXModel> fwxxList = query.list();
		printlnList(fwxxList);
	}

	// 鎵撳嵃缁撴灉
	public void printlnList(List<FWXXModel> fwxxList) {
		// TODO Auto-generated method stub
		for (FWXXModel model : fwxxList) {
			System.out.print(model.getFwid() + "\t");
			System.out.print(model.getZj() + "\t");
			System.out.print(model.getTitle() + "\t");
			System.out.print(model.getDate() + "\t");
			System.out.print(model.getFwxx() + "\t");
			System.out.print(model.getLxr() + "\t");
			System.out.print(model.getTelephone() + "\t\n");
		}

	}

	// 灞炴�鏌ヨ
	public void testPropertyQuery() {
		Session session = getSession();
		String hql = "select fw.lxr,fw.zj,fw.date from FWXXModel fw ";
		Query query = session.createQuery(hql);
		List fwxxList = query.list();
		Iterator it = fwxxList.iterator();
		while (it.hasNext()) {
			Object[] objects = (Object[]) it.next();
			System.out.println(objects[0] + "\t" + objects[1]);
		}

	}

	// 鍙傛暟鏌ヨ
	public void testParamQuery() {
		Session session = getSession();
		String hql = "from FWXXModel fw where fw.title like ?";
		Query query = session.createQuery(hql);
		query.setString(0, "%鍋�");
		List<FWXXModel> fwxxList = query.list();
		printlnList(fwxxList);
	}

	// 鑼冨洿鏌ヨ
	public void searchByZj(int zj1, int zj2) {
		Session session = super.getSession();
		String hql = "from FWXXModel fw where fw.zj between :zj1 and :zj2";
		Query query = session.createQuery(hql);
		query.setInteger("zj1", zj1);
		query.setInteger("zj2", zj2);
		List<FWXXModel> fwxxList = query.list();
		printlnList(fwxxList);
	}

	// 鑱旂粨鏌ヨ
	public void testAssociatedQuery() {
		Session session = super.getSession();
		String hql = "select jd from JDModel jd ,FWXXModel fw where fw.jdid = jd and fw.lxr='浼婂厛鐢�";
		Query query = session.createQuery(hql);
		List fwxxList = query.list();
		Iterator it = fwxxList.iterator();
		while (it.hasNext()) {
			JDModel jd = (JDModel) it.next();
			System.out.println(jd.getJd());
		}
	}

	// 鏌ヨ璁板綍琛屾暟
	public void testMaxCount() {
		Session session = super.getSession();
		String hqlString = "select count(fw) from FWXXModel fw";
		Query query = session.createQuery(hqlString);
		long count = (Long) query.uniqueResult();
		System.out.println(count);
	}

	// Criteria 鏌ヨ
	public List search(FWXXModel condition) {
		Session session = super.getSession();
		Criteria c = session.createCriteria(FWXXModel.class);
		if (null != condition) {
			// 杩涜妯＄硦鏌ヨ
			if (condition.getTitle() != null
					&& !"".equals(condition.getTitle())) {
				c.add(Restrictions.like("title", condition.getTitle(),
						MatchMode.ANYWHERE));
			}

			// 澶т簬鎴栫瓑浜嶼J1
			if (condition.getZj1() != 0) {
				c.add(Restrictions.ge("zj", condition.getZj1()));
			}

			// 灏忎簬鎴栫瓑浜嶼J2
			if (condition.getZj2() != 0) {
				c.add(Restrictions.le("zj", condition.getZj2()));
			}

			// 鑼冨洿鏌ヨ
			if (condition.getLxIds().length > 0) {
				c.add(Restrictions.in("lx.lxid", condition.getLxIds()));
			}
		}
		c.addOrder(Order.asc("fwid"));
		return c.list();
	}

	// 鍒嗛〉鏌ヨ
	public List search(int pageNo, int pageSize) {
		Session session = getSession();
		String hql = "from FWXXModel fw order by fw.fwid asc";
		Query query = session.createQuery(hql);
		int firstResultIndex = (pageNo - 1) * pageSize;
		query.setFirstResult(firstResultIndex);
		query.setMaxResults(pageSize);

		return query.list();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HQLTest test = new HQLTest();
		// test.testBaseQuery();
		// test.testPropertyQuery();
		// test.testParamQuery();
		// test.searchByZj(1000, 3000);
		// test.testAssociatedQuery();
		// test.testMaxCount();
		//test.printlnList(test.search(1, 2));
		FWXXModel model = new FWXXModel();
		model.setTitle("鍋�");
		model.setZj1(0.0);
		model.setZj2(0.0);
		test.printlnList(test.search(model));
	}

}
