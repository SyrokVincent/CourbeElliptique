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
		g = (p.y.multiply(p.y).mod(m)).add(a1.multiply(p.x).multiply(p.y).mod(m)).add(a3.multiply(p.y)).mod(m);
		
		d = (p.x.multiply(p.x).multiply(p.x).mod(m)).add(a2.multiply(p.x).multiply(p.x).mod(m)).add(a4.multiply(p.x).mod(m)).add(a6).mod(m);
		
		if (g.compareTo(d) == 0){
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
		if ( p.neutre){
			return q;
		} 
		else if (q.neutre){
			return p;
		}
		
		//p1 different de -p2
		BigInteger l; // lambda
		if(p.x.compareTo(q.x) == 0){
			l = ((new BigInteger("3")).multiply(p.x).multiply(p.x)).add((new BigInteger("2")).multiply(a2).multiply(p.x)).mod(m);
			l = ((l.add(a4)).add(a1.multiply(p.y).negate())).mod(m);
			l = l.multiply((((new BigInteger("2")).multiply(p.y)).add(a1.multiply(p.x)).add(a3)).modInverse(m)).mod(m);
			l = l.mod(m);
		}else{
			l = p.y.add(q.y.negate()).mod(m);
			l = l.multiply((p.x.add(q.x.negate())).modInverse(m)).mod(m);
		}
		
		xr = (l.multiply(l)).add(a1.multiply(l)).add(a2.negate()).add(p.x.negate()).add(q.x.negate()).mod(m);
		yr = ((l.add(a1).negate()).multiply(xr)).add(l.multiply(p.x)).add(p.y.negate()).add(a3.negate()).mod(m);
		
		
		return new Point(xr,yr);
	}
	
	public Point mult(Point p, BigInteger n){
		//algo to improve
//		Point r = p;
//		BigInteger i;
//		for (i = new BigInteger("1") ;i.compareTo(n)<0;i = i.add(new BigInteger("1"))){
//			r = add(r,p);
//		}
//		System.out.println(r.x);
//		System.out.println(r.y);
//		return r;
		
		
		return null;
		
	
	}
}


