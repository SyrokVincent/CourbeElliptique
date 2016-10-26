import java.math.BigInteger;

public class Courbe {
	
	BigInteger x;
	BigInteger y;
	BigInteger a1,a2,a3,a4,a6;
	
	public Courbe(BigInteger coef1, BigInteger coef2, BigInteger coef3, BigInteger coef4, BigInteger coef6){
		this.a1 =coef1;
		this.a2 =coef2;
		this.a3 =coef3;
		this.a4 =coef4;
		this.a6 =coef6;
		
		
	}
	
	public boolean pointValide(Point p, Courbe c){
		BigInteger g;
		BigInteger d;
		g = p.y.multiply(p.y);
		g = g.add(c.a1.multiply(p.x).multiply(p.y));
		g = g.add(c.a3).multiply(p.y);
		
		d = p.x.multiply(p.x).multiply(p.x);
		d = d.add(c.a2.multiply(p.x).multiply(p.x));
		d = d.add(c.a4.multiply(p.x));
		d = d.add(c.a6);
		
		if (g == d){
			return true;
		}else return false;
	}
	
	public Point opposé(Point p){
		BigInteger xq;
		BigInteger yq;
		
		xq = p.x;
		yq = p.y.negate();
		yq = yq.add(a1.multiply(p.x).negate());
				
		return null;
		
	}
	
	public class Point {
		
		BigInteger x;
		BigInteger y;
		
		public Point(BigInteger x,BigInteger y){
			this.x =x;
			this.y =y;
		}
		

	}

}


