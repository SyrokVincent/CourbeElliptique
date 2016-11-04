import java.math.BigInteger;

public class classMain {


//w256-001
//p=8884933102832021670310856601112383279507496491807071433260928721853918699951
//n=8884933102832021670310856601112383279454437918059397120004264665392731659049
//a4=2481513316835306518496091950488867366805208929993787063131352719741796616329
//a6=4387305958586347890529260320831286139799795892409507048422786783411496715073
//r4=5473953786136330929505372885864126123958065998198197694258492204115618878079
//r6=5831273952509092555776116225688691072512584265972424782073602066621365105518
//gx=7638166354848741333090176068286311479365713946232310129943505521094105356372
//gy=762687367051975977761089912701686274060655281117983501949286086861823169994
//r=8094458595770206542003150089514239385761983350496862878239630488323200271273
//
//e256-001
//p=17788785049862795200150516910406025137463828480015848539718291306993861084899
//n=17788785049862795200150516910406025137363578126680481424741935402610840792044
//d=3796951610952418946414838013946402540659352227509671351658573117542984656493
//rd=8691808718684137624443735665996936692240583232324910500040371199339620074813
//gx=1986605118669389278383185019082317115767420240937840666424031679646376737334
//gy=13522141226273509754871071682844347818526232922984052207011535368467814622472
//r=11437956621720228291212199612953420381679188428091051450834331532002067513477
//t=2

	static BigInteger m = new BigInteger("8884933102832021670310856601112383279507496491807071433260928721853918699951");
	static BigInteger a1 = new BigInteger("0");
	static BigInteger a2 = new BigInteger("0");
	static BigInteger a3 = new BigInteger("0");
	static BigInteger a4 = new BigInteger("2481513316835306518496091950488867366805208929993787063131352719741796616329");
	static BigInteger a6 = new BigInteger("4387305958586347890529260320831286139799795892409507048422786783411496715073");
 
	public static void main(String[] args) {
		Courbe c = new Courbe(m,a1, a2, a3, a4, a6);
		Point p = new Point(new BigInteger("7638166354848741333090176068286311479365713946232310129943505521094105356372")
						,new BigInteger("762687367051975977761089912701686274060655281117983501949286086861823169994"));
		
		System.out.println(c.pointValide(p));
		System.out.println(c.pointValide(c.add(p, p)));
		System.out.println(c.pointValide(c.mult(p, new BigInteger("1000"))));
		System.out.println(c.pointValide(c.oppos�(p)));
		System.out.println(c.pointValide(c.add(p, c.oppos�(p))));
		

	}

}
