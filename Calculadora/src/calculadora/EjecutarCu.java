
package calculadora;

//@author tata7

import java.text.DecimalFormat;

 
public class EjecutarCu {
    
    public EjecutarCu(){
    }
  
    
    double a11,a12,a13,a14,a21,a22,a23,a24,a31,a32,a33,a34,a41,a42,a43,a44,r1,r2,r3,r4,dA,d1,d2,d3,d4,
            x,y,z,w,sd1,sd2,sd3,sd4,sd11,sd12,sd13,sd14,sd21,sd22,sd23,sd24,sd31,sd32,sd33,sd34,sd41,sd42,sd43,sd44;
    public void Capturardatos(){
        
      a11=Double.parseDouble(PorCuatro.a.getText());
      a12=Double.parseDouble(PorCuatro.b.getText());
      a13=Double.parseDouble(PorCuatro.c.getText());
      a14=Double.parseDouble(PorCuatro.d.getText());
      a21=Double.parseDouble(PorCuatro.e.getText());
      a22=Double.parseDouble(PorCuatro.f.getText());
      a23=Double.parseDouble(PorCuatro.g.getText());
      a24=Double.parseDouble(PorCuatro.h.getText());
      a31=Double.parseDouble(PorCuatro.i.getText());
      a32=Double.parseDouble(PorCuatro.j.getText());
      a33=Double.parseDouble(PorCuatro.k.getText());
      a34=Double.parseDouble(PorCuatro.l.getText());
      a41=Double.parseDouble(PorCuatro.m.getText());
      a42=Double.parseDouble(PorCuatro.n.getText());
      a43=Double.parseDouble(PorCuatro.o.getText());
      a44=Double.parseDouble(PorCuatro.p.getText());
      r1=Double.parseDouble(PorCuatro.q.getText());
      r2=Double.parseDouble(PorCuatro.r.getText());
      r3=Double.parseDouble(PorCuatro.s.getText());
      r4=Double.parseDouble(PorCuatro.t.getText());
      // Determinante Principal
      sd1=(a22*a33*a44)+(a23*a34*a42)+(a24*a32*a43)-(a42*a33*a24)-(a43*a34*a22)-(a44*a32*a23);
      sd2=(a21*a33*a44)+(a23*a34*a41)+(a24*a31*a43)-(a41*a33*a24)-(a43*a34*a21)-(a44*a31*a23);
      sd3=(a21*a32*a44)+(a22*a34*a41)+(a24*a31*a42)-(a41*a32*a24)-(a42*a34*a21)-(a44*a31*a22);
      sd4=(a21*a32*a43)+(a22*a33*a41)+(a23*a31*a42)-(a41*a32*a23)-(a42*a33*a21)-(a43*a31*a22);
      
      dA=(a11*sd1)-(a12*sd2)+(a13*sd3)-(a14*sd4);
      //Determinante 1
      sd11=(a22*a33*a44)+(a23*a34*a42)+(a24*a32*a43)-(a42*a33*a24)-(a43*a34*a22)-(a44*a32*a23);
      sd12=(r2*a33*a44)+(a23*a34*r4)+(a24*r3*a43)-(r4*a33*a24)-(a43*a34*r2)-(a44*r3*a23);
      sd13=(r2*a32*a44)+(a22*a34*r4)+(a24*r3*a42)-(r4*a32*a24)-(a42*a34*r2)-(a44*r3*a22);
      sd14=(r2*a32*a43)+(a22*a33*r4)+(a23*r3*a42)-(r4*a32*a23)-(a42*a33*r2)-(a43*r3*a22);
      
      d1=(r1*sd11)-(a12*sd12)+(a13*sd13)-(a14*sd14);
      //Determinante 2
      sd21=(r2*a33*a44)+(a23*a34*r4)+(a24*r3*a43)-(r4*a33*a24)-(a43*a34*r2)-(a44*r3*a23);
      sd22=(a21*a33*a44)+(a23*a34*a41)+(a24*a31*a43)-(a41*a33*a24)-(a43*a34*a21)-(a44*a31*a23);
      sd23=(a21*r3*a44)+(r2*a34*a41)+(a24*a31*r4)-(a41*r3*a24)-(r4*a34*a21)-(a44*a31*r2);
      sd24=(a21*r3*a43)+(r2*a33*a41)+(a23*a31*r4)-(a41*r3*a23)-(r4*a33*a21)-(a43*a31*r2);
      
      d2=(a11*sd21)-(r1*sd22)+(a13*sd23)-(a14*sd24);
      //Determinante 3
      sd31=(a22*r3*a44)+(r2*a34*a42)+(a24*a32*r4)-(a42*r3*a24)-(r4*a34*a22)-(a44*a32*r2);
      sd32=(a21*r3*a44)+(r2*a34*a41)+(a24*a31*r4)-(a41*r3*a24)-(r4*a34*a21)-(a44*a31*r2);
      sd33=(a21*a32*a44)+(a22*a34*a41)+(a24*a31*a42)-(a41*a32*a24)-(a42*a34*a21)-(a44*a31*a22);
      sd34=(a21*a32*r4)+(a22*r3*a41)+(r2*a31*a42)-(a41*a32*r2)-(a42*r3*a21)-(r4*a31*a22);
      
      d3=(a11*sd31)-(a12*sd32)+(r1*sd33)-(a14*sd34);
      //Determinante 4 
      sd41=(a22*a33*r4)+(a23*r3*a42)+(r2*a32*a43)-(a42*a33*r2)-(a43*r3*a22)-(r4*a32*a23);
      sd42=(a21*a33*r4)+(a23*r3*a41)+(r2*a31*a43)-(a41*a33*r2)-(a43*r3*a21)-(r4*a31*a23);
      sd43=(a21*a32*r4)+(a22*r3*a41)+(r2*a31*a42)-(a41*a32*r2)-(a42*r3*a21)-(r4*a31*a22);
      sd44=(a21*a32*a43)+(a22*a33*a41)+(a23*a31*a42)-(a41*a32*a23)-(a42*a33*a21)-(a43*a31*a22);
      
      d4=(a11*sd41)-(a12*sd42)+(a13*sd43)-(r1*sd44);
      
      x=d1/dA;
      y=d2/dA;
      z=d3/dA;
      w=d4/dA;
      
    
      
    }
    
        public void imprimir(){
            
        DecimalFormat df = new DecimalFormat("0.00");
        
        String rex=String.valueOf(df.format(x));
        PorCuatro.rx.setText(rex);
        
        String rey=String.valueOf(df.format(y));
        PorCuatro.ry.setText(rey);
        
        String rez=String.valueOf(df.format(z));
        PorCuatro.rz.setText(rez);
        
         String rew=String.valueOf(df.format(w));
        PorCuatro.rw.setText(rew);
    }
}
