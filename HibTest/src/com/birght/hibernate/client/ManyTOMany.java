package com.birght.hibernate.client;

import java.util.Iterator;

import com.birght.comm.HibernateBaseDAO;
import com.birght.hibernate.entity.EmployeeModel;
import com.birght.hibernate.entity.ProjectModel;

public class ManyTOMany extends HibernateBaseDAO {

	/**
	 * @param args
	 */

	public void testMany() {
		// 閸旂姾娴囩紓鏍у娇娑擄拷 1 閻ㄥ嫰銆嶉惄顔碱嚠鐠烇拷
		ProjectModel proj = (ProjectModel) super.get(ProjectModel.class, 2l);
		// 閸旂姾娴囧銈夈�閻╊喚娈戦幍锟芥稉鐑樺灇閸涳拷
		Iterator it = proj.getMumbers().iterator();
		System.out.println("濮濄倝銆嶉惄顔煎棘閸旂姷娈戦幋鎰喅閺堬拷:" + proj.getMumbers().size());
		for (; it.hasNext();) {
			EmployeeModel employee = (EmployeeModel) it.next();
			System.out.println("*************" + employee.getEmployeeName());
		}

		EmployeeModel employee2 = (EmployeeModel) get(EmployeeModel.class, 5l);
		Iterator it2 = employee2.getProjects().iterator();
		System.out.println("濮濄倕鎲冲銉ュ棘閸旂姷娈戞い鍦窗閺堬拷:" + employee2.getProjects().size());

		while (it2.hasNext()) {
			ProjectModel project2 = (ProjectModel) it2.next();
			System.out.println(project2.getProjectName());
		}
	}

	public void testAddEmployee() {
		
		// 閺傛澘濮為崗銉﹀灇閸涙ü绗侀崣锟�
		EmployeeModel sanshu = new EmployeeModel();
		sanshu.setEmployeeName("娑撳褰�");
		
		// 閸旂姾娴囬崶钘夘啀鐏烇拷娓氭稑绨查柧楣冦�閻╊喖顕挒锟�
		
		ProjectModel guojiaju = (ProjectModel)super.get(ProjectModel.class, 2l);
		
		//閸︺劌娴楃�璺虹湰娓氭稑绨查柧楣冦�閻╊喕鑵戦崝鐘插弳閹存劕鎲虫稉澶婂絽
		guojiaju.getMumbers().add(sanshu);
		
		//閸︺劋绗侀崣鏂捐厬閸旂姴鍙嗘い鍦窗閸ヨ棄顔嶇仦锟芥笟娑樼安闁鹃箖銆嶉惄锟�
		sanshu.getProjects().add(guojiaju);
		
		//閹笛嗩攽閹镐椒绠欓崠鏍ㄦ煙濞夛拷
		super.add(sanshu);
		super.update(guojiaju);
		

	}
	
	public void testAddProj(){
		
		ProjectModel wangyin = new ProjectModel();
		wangyin.setProjectName("ERP");
		
		EmployeeModel sanshu = (EmployeeModel)super.get(EmployeeModel.class, 5l);
		EmployeeModel pangzi = (EmployeeModel)super.get(EmployeeModel.class, 3l);
		
		wangyin.getMumbers().add(sanshu);
		
		//娑撹桨绮堟稊鍫滅瑝閺勵垰鎲冲銉よ厬閸旂娀銆嶉惄锟�閼板本妲告い鍦窗娑擃厼濮為崨妯轰紣? 
		wangyin.getMumbers().add(pangzi);
		
		sanshu.getProjects().add(wangyin);
		
		pangzi.getProjects().add(wangyin);
		
		super.update(sanshu);
		//閺囧瓨鏌婃稉澶婂絽 
		super.update(pangzi);
		
		super.add(wangyin);
	}

	public void  deleteAllEmployee(){
		EmployeeModel tod  = (EmployeeModel) super.get(EmployeeModel.class, 2l);
		EmployeeModel hanni = (EmployeeModel) super.get(EmployeeModel.class, 4l);
		
		ProjectModel weihu = (ProjectModel) super.get(ProjectModel.class, 5l);
		weihu.getMumbers().removeAll(weihu.getMumbers());
		
		tod.getProjects().remove(weihu);
		
		hanni.getProjects().remove(weihu);
		
		super.update(tod);
		super.update(hanni);
		super.delete(ProjectModel.class, 5l);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManyTOMany test = new ManyTOMany();
		//test.testMany();
		//test.testAddEmployee();
		test.testAddProj();
		//test.deleteAllEmployee();
	}

}
