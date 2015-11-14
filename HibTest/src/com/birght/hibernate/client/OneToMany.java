package com.birght.hibernate.client;

import com.birght.comm.HibernateBaseDAO;
import com.birght.hibernate.entity.JDModel;
import com.birght.hibernate.entity.QXModel;

public class OneToMany extends HibernateBaseDAO  {

	public void testAddQX() {
		QXModel qx = new QXModel();
		qx.setQx("灞卞崡鍖�");
		super.add(qx);
	}

	/**
	 * @param args
	 */
	
	public void testAddJD(){
		QXModel qx = (QXModel)super.get(QXModel.class, 23);
		JDModel jd1 = new JDModel();
		jd1.setJd("鍜屽钩璺�");
		jd1.setQx(qx);
		super.add(jd1);
		
		JDModel jd2 = new JDModel();
		jd2.setJd("鍏竴璺�");
		jd2.setQx(qx);
		super.add(jd2);
		
		JDModel jd3 = new JDModel();
		jd3.setJd("浜斿洓澶ч亾");
		jd3.setQx(qx);
		super.add(jd3);
		
		
	}
	
	
	public void testDeleteJD(){
		
		super.delete(JDModel.class, 369);
	}
	
	
	public void testDeleteQx(){
		super.delete(QXModel.class, 22);
	}
	
	
	public void testMoveJDtoQx(){
		//鑾峰彇灞卞崡鍖哄璞�
		QXModel shannam = (QXModel) super.get(QXModel.class, 23);
		//鍔犺浇娴锋穩鍖哄璞�
		QXModel haidian = (QXModel)super.get(QXModel.class,1);
		//鍔犺浇鍜屽钩璺璞�
		JDModel jd = (JDModel)super.get(JDModel.class,371);
		//鍦ㄥ北鍗楀尯瀵硅薄涓Щ闄ゅ拰骞宠矾
        shannam.getJds().remove(jd);
        //鎵ц鎸佷箙鍖栨柟娉�
        super.delete(JDModel.class,371);
        //璁剧疆鍜屽钩璺负娴锋穩鍖�
        jd.setQx(haidian);
        //鎵ц澧炲姞
        super.add(jd);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      OneToMany test = new OneToMany();
       //test.testAddQX();
       //test.testAddJD();
       //test.testDeleteJD();
       // test.testDeleteQx();
       test.testMoveJDtoQx();
	}

}
