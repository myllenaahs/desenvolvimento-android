package br.edu.ifpb.ontouchimage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import br.edu.ifpb.ontouchimage.R;

public class CriarImagem extends View 
{ 
     private Drawable imagem; 
     private int x, y, largura, altura; 
     private boolean Clicou; 
     public int movimento = 12;
     
     public CriarImagem(Context context, AttributeSet attrs) 
     { 
          super(context, attrs); 
     imagem =    context.getResources().getDrawable(R.drawable.image2); 
          largura = imagem.getIntrinsicWidth(); 
          altura = imagem.getIntrinsicHeight(); 
          x = 150; 
          y = 300; 
          setFocusable(true); 
     }
     
     @Override 
     protected void onDraw(Canvas canvas) 
     { 
          super.onDraw(canvas); 
          imagem.setBounds(x,y,x+largura,y+altura); 
          imagem.draw(canvas); 
     }
     
     public boolean onTouchEvent(MotionEvent motionEvent) 
     { 
          this.x = (int)motionEvent.getX(); 
          this.y = (int) motionEvent.getY(); 
              
          switch(motionEvent.getAction()) 
          { 
              case MotionEvent.ACTION_DOWN: 
              { 
                   Clicou = imagem.copyBounds().contains(x,y); 
                   break; 
              } 
                          
              case MotionEvent.ACTION_MOVE: 
               if (Clicou) 
               { 
                   this.x = x - (largura/2); 
                   this.y = y - (altura/2); 
                   break; 
               } 
                                                
              case MotionEvent.ACTION_UP : 
              { 
                   Clicou = false; 
                   break; 
              } 
           } 
              
          invalidate(); 
          return true; 
     }
}
