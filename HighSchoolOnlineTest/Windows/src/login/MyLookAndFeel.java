package login;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class MyLookAndFeel {
	//在界面内直接掉就可以实现皮肤效果
	//系统自带皮肤,5中都能用
	public static String sys_Metal = "javax.swing.plaf.metal.MetalLookAndFeel"; 
	public static String sys_Nimbus = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
	public static String sys_CDE_Motif = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	public static String sys_Windows = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	public static String sys_Windows_Classic = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
	//JIattoo jar包资源
	public static String jtattoo_acryl = "com.jtattoo.plaf.acryl.AcrylLookAndFeel";
	public static String jtattoo_aero = "com.jtattoo.plaf.aero.AeroLookAndFeel";
	public static String jtattoo_aluminum = "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";
	public static String jtattoo_bernstein = "com.jtattoo.plaf.bernstein.BernsteinLookAndFeel";
	public static String jtattoo_fast = "com.jtattoo.plaf.fast.FastLookAndFeel";
	public static String jtattoo_hifi = "com.jtattoo.plaf.hifi.HiFiLookAndFeel";
	public static String jtattoo_luna = "com.jtattoo.plaf.luna.LunaLookAndFeel";
	public static String jtattoo_mcwin = "com.jtattoo.plaf.mcwin.McWinLookAndFeel";
	public static String jtattoo_mint = "com.jtattoo.plaf.mint.MintLookAndFeel";
	public static String jtattoo_noire = "com.jtattoo.plaf.noire.NoireLookAndFeel";
	public static String jtattoo_smart = "com.jtattoo.plaf.smart.SmartLookAndFeel";
	//liquidlnf.jar包资源
	public static String liquidinf= "com.birosoft.liquid.LiquidLookAndFeel";
	//SwingSet2_zip.jar包资源  苹果皮肤 咋不太好看
	public static String SwingSet_borland= "com.borland.plaf.borland.BorlandLookAndFeel";
	public static String SwingSet_quaqua1= "ch.randelshofer.quaqua.Quaqua13PantherLookAndFeel";
    public static String SwingSet_quaqua2= "ch.randelshofer.quaqua.QuaquaLookAndFeel";
    public static String SwingSet_Office2003= "org.fife.plaf.Office2003.Office2003LookAndFeel";
	public static String SwingSet_OfficeXP= "org.fife.plaf.OfficeXP.OfficeXPLookAndFeel";
	
	
	//构造函数
	public MyLookAndFeel(){
		
	}
	
	public static void setLookAndFeel(String skin){
		try {
			UIManager.setLookAndFeel(skin);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
