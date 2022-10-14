
package calculadora;

import java.text.DecimalFormat;

public class Ejecutar {
    
    public Ejecutar(){
    }
    double a11,a12,a13,a21,a22,a23,a31,a32,a33,r1,r2,r3,dA,d1,d2,d3,x,y,z;
   
    public void capturaIng(){
      a11=Double.parseDouble(PorTres.a.getText());
      a12=Double.parseDouble(PorTres.b.getText());
      a13=Double.parseDouble(PorTres.c.getText());
      a21=Double.parseDouble(PorTres.d.getText());
      a22=Double.parseDouble(PorTres.e.getText());
      a23=Double.parseDouble(PorTres.f.getText());
      a31=Double.parseDouble(PorTres.g.getText());
      a32=Double.parseDouble(PorTres.h.getText());
      a33=Double.parseDouble(PorTres.i.getText());
      r1=Double.parseDouble(PorTres.j.getText());
      r2=Double.parseDouble(PorTres.k.getText());
      r3=Double.parseDouble(PorTres.l.getText());
      
      dA=(a11*a22*a33)+(a12*a23*a31)+(a13*a21*a32)-(a31*a22*a13)-(a32*a23*a11)-(a33*a21*a12);
      d1=(r1*a22*a33)+(a12*a23*r3)+(a13*r2*a32)-(r3*a22*a13)-(a32*a23*r1)-(a33*r2*a12);
      d2=(a11*r2*a33)+(r1*a23*a31)+(a13*a21*r3)-(a31*r2*a13)-(r3*a23*a11)-(a33*a21*r1);
      d3=(a11*a22*r3)+(a12*r2*a31)+(r1*a21*a32)-(a31*a22*r1)-(a32*r2*a11)-(r3*a21*a12);
      
      x=d1/dA;
      y=d2/dA;
      z=d3/dA;
    }
    
 
    public void imprimirIng(){
        
         DecimalFormat df = new DecimalFormat("0.00");
        String resx=String.valueOf(df.format(x));
        PorTres.rx.setText(resx);
        
        String resy=String.valueOf(df.format(y));
        PorTres.ry.setText(resy);
        
        String resz=String.valueOf(df.format(z));
        PorTres.rz.setText(resz);
    }
}
