import java.math.BigInteger;

public class Courbe {
	
	BigInteger m;
	BigInteger a1,a2,a3,a4,a6;
	
	public Courbe(BigInteger modulo, BigInteger coef1, BigInteger coef2, BigInteger coef3, BigInteger coef4, BigInteger coef6){
		this.m = modulo;
		this.a1 =coef1;
		this.a2 =coef2;
		this.a3 =coef3;
		this.a4 =coef4;
		this.a6 =coef6;
		
		
	}
	
	public boolean pointValide(Point p){
		BigInteger g;
		BigInteger d;
		g = p.y.multiply(p.y).mod(m);
		g = g.add(a1.multiply(p.x).multiply(p.y).mod(m)).mod(m);
		g = g.add(a3).multiply(p.y).mod(m);
		
		d = p.x.multiply(p.x).multiply(p.x).mod(m);
		d = d.add(a2.multiply(p.x).multiply(p.x).mod(m)).mod(m);
		d = d.add(a4.multiply(p.x)).mod(m);
		d = d.add(a6).mod(m);
		
		if (g == d){
			return true;
		}else return false;
	}
	
	public Point opposé(Point p){
		BigInteger xq;
		BigInteger yq;
		
		xq = p.x;
		yq = p.y.negate().mod(m);
		yq = yq.add(a1.multiply(p.x).negate().mod(m)).mod(m);
		yq = yq.add(a3.negate()).mod(m);
				
		return new Point(xq,yq);
		
	}
	
	public Point add(Point p, Point q){
		BigInteger xr;
		BigInteger yr;
		
		//p1 different de -p2
		BigInteger l; // lambda
		if(p.x == q.x){
			l = ((new BigInteger("3")).multiply(p.x).multiply(p.x)).add((new BigInteger("2")).multiply(p.x).multiply(p.x));
			l = (l.add(a4).add(a1.multiply(p.y).negate())).mod(m);
			l = l.divide(((new BigInteger("2")).multiply(p.y)).add(a1.multiply(p.x)).add(a3).mod(m));
		}else{
			l = p.y.add(q.y.negate()).mod(m);
			l = l.divide(p.x.add(q.x.negate()).mod(m));
		}
		
		xr = (l.multiply(l)).add(a1.multiply(l)).add(a2.negate()).add(p.x.negate()).add(q.x.negate()).mod(m);
		yr = (l.add(a1)).multiply(xr).negate().add(l.multiply(p.x)).add(q.y.negate()).add(a3.negate()).mod(m);
		
		
		return new Point(xr,yr);
	}
	
	public Point mult(Point p, int n){
		Point r = p;
		for (int i=0;i<n;i++){
			r = add(r,p);
		}
		return r;
	}
}


