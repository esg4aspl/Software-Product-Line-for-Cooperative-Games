package EM_plugin.Generator;

import java.util.ArrayList;

/*
 * İsmine GeneratorPlugInI demesek de "ComponenetGeneratorI" desek daha olur gibi geldi
 * Çünkü anladığım kadarıyla bu interface'i implement eden class'lar component yaratıyor.
 * PlugIn ismi ile bağlantısını anlayamadım.
 * 
 * */
public interface GeneratorPlugInI {
	
	//Bazı Generator class'larında bunun implement edilmediğini gördüm (DiceGenerator, FigureGenerator).
	//Eğer generator'larımızı type'li type'siz olarak ayıracaksak ki ayıracağız gibi duruyor.
	//Bu interface yerine //recommendation kısmında yer alan tasarımı kullanabiliriz. 
	void setParam(String type, int count);
	
	//setParam yerine setNumberOfCompenents diyebiliriz eğer "ComponenetGeneratorI"
	//isminde karar verirsek. Param çok genel bir kavram kullanmaktan uzak duralım.
	void setParam(int count);
	
	ArrayList<?> generate();
	
	//show yerine showComponents desek daha iyi olabilir, 
	//çünkü bu şekilde sanki generator'ı gösteriyormuşuz gibi anlaşılıyor.
	//Eğer Generator'ı göstermekten bahsediyorsak burada böyle kalabilir fakat bazı
	//class'larda içerisindeki compenent'leri gösterdiği görüyorum (PlayerGenerator).
	void show(); 
}
