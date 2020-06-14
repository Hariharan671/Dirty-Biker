package com.harryh5n1.dirtybiker;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

public class DirtyBiker extends ApplicationAdapter {
	SpriteBatch batch;
	Texture bike,bg;int hb,wb;Texture d1,d2,d3,d4,d5,d6,bg1,go,pa;
	int w1,w3,w4,w5,w6,w2;int l=0;int o=0;int x,y,x1,y1;int w=0;
	Random random=new Random();boolean game=true;
	ShapeRenderer shapeRenderer;
	String[] bik={"d2","d3","d4","d5","d6","d7","d8","d9","d1"};

	@Override
	public void create () {
		batch = new SpriteBatch();
		bg=new Texture("back.png");
		go=new Texture("go.png");
		shapeRenderer=new ShapeRenderer();
		bg1=new Texture("back.png");
		bike=new Texture("b3.png");
		pa=new Texture("play.png");
		x=y=y1=0;
		hb=100;
		x1=Gdx.graphics.getWidth();
		wb=-bike.getWidth()/3+100;
	}

	@Override
	public void render () {
		batch.begin();
		if(Gdx.input.isTouched()&&!game){
			Circle circle=new Circle(Gdx.graphics.getWidth()/2-pa.getWidth()/2,250,pa.getWidth()/2);
			Vector3 temp = new Vector3(Gdx.input.getX()-135, Gdx.graphics.getHeight()-Gdx.input.getY()-55, 0);
			if(circle.contains(temp.x,temp.y)){
				game=true;
				batch.draw(pa,-1000,1000);
				circle=new Circle(-1000,1000,pa.getWidth()/2);
				o=0;l=0;w=0;
			}
		}

		if(o==0){
			if(x<-Gdx.graphics.getWidth()){
				x=Gdx.graphics.getWidth();
                batch.draw(bg,x,y,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
            }
			else if(x1<-Gdx.graphics.getWidth()) {
				x1=Gdx.graphics.getWidth();
				batch.draw(bg1,x1,y1,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
			}else{
                batch.draw(bg,x,y,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
                batch.draw(bg,x1,y,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
                x=x-5;
                x1=x1-5;
            }
			if(wb==Gdx.graphics.getWidth()/2-bike.getWidth()+100){
				wb=wb+0;
			}else {
				wb=1+wb;
			}
			if(hb>100){
				hb=hb-9;
			}
		}
		if(w==1){
			batch.draw(bg,x,y,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
			batch.draw(bg1,x1,y1,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
			batch.draw(go,Gdx.graphics.getWidth()/2-go.getWidth()/2,500);
			batch.draw(pa,Gdx.graphics.getWidth()/2-pa.getWidth()/2,250);
		}

		batch.draw(bike,wb,hb,bike.getWidth(),bike.getHeight());
		if(game) {
			if (l == 0) {
				start();
			} else {
				if (w1 < -d1.getWidth()) {
					d1 = new Texture(bik[random.nextInt(9)] + ".png");
					w1 = (Gdx.graphics.getWidth()) + 8 * Gdx.graphics.getWidth() / 3;
					batch.draw(d1, w1, 100);
				} else {
					w1 = w1 - 5;
					batch.draw(d1, w1, 100);
				}
				if (w2 < -d2.getWidth()) {
					d2 = new Texture(bik[random.nextInt(9)] + ".png");
					w2 = (Gdx.graphics.getWidth()) + 8 * Gdx.graphics.getWidth() / 3;
					batch.draw(d2, w2, 100);
				} else {
					w2 = w2 - 5;
					batch.draw(d2, w2, 100);
				}
				if (w3 < -d3.getWidth()) {
					d3 = new Texture(bik[random.nextInt(9)] + ".png");
					w3 = (Gdx.graphics.getWidth()) + 8 * Gdx.graphics.getWidth() / 3;
					batch.draw(d3, w3, 100);
				} else {
					w3 = w3 - 5;
					batch.draw(d3, w3, 100);
				}
				if (w4 < -d4.getWidth()) {
					d4 = new Texture(bik[random.nextInt(9)] + ".png");
					w4 = (Gdx.graphics.getWidth()) + 8 * Gdx.graphics.getWidth() / 3;
					batch.draw(d4, w4, 100);
				} else {
					w4 = w4 - 5;
					batch.draw(d4, w4, 100);
				}
				if (w5 < -d5.getWidth()) {
					d5 = new Texture(bik[random.nextInt(9)] + ".png");
					w5 = (Gdx.graphics.getWidth()) + 8 * Gdx.graphics.getWidth() / 3;
					batch.draw(d5, w5, 100);
				} else {
					w5 = w5 - 5;
					batch.draw(d5, w5, 100);
				}
				if (w6 < -d6.getWidth()) {
					d6 = new Texture(bik[random.nextInt(9)] + ".png");
					w6 = (Gdx.graphics.getWidth()) + 8 * Gdx.graphics.getWidth() / 3;
					batch.draw(d6, w6, 100);
				} else {
					w6 = w6 - 5;
					batch.draw(d6, w6, 100);
				}
			}
		}
		if(o==0) {
			if (Gdx.input.isTouched()) {
				hb = hb + 17;
				if(hb>Gdx.graphics.getHeight()-bike.getHeight()){
					gameover();
				}
			}
		}
		/*Circle carac1=new Circle (w1,100,d1.getWidth());
		Circle carac2=new Circle (w2,100,d2.getWidth());
		Circle  carac3=new Circle (w3,100,d3.getWidth());
		Circle  carac4=new Circle (w4,100,d4.getWidth());
		Circle  carac5=new Circle (w5,100,d5.getWidth());
		Circle  carac6=new Circle (w6,100,d6.getWidth());*/
		Rectangle ike=new Rectangle(wb+25,hb,bike.getWidth()-100,bike.getHeight()-100);
		Rectangle carac1=new Rectangle(w1+20,100,d1.getWidth()-50,d1.getHeight()-75);
		Rectangle carac2=new Rectangle(w2+20,100,d2.getWidth()-50,d2.getHeight()-75);
		Rectangle carac3=new Rectangle(w3+20,100,d3.getWidth()-50,d3.getHeight()-75);
		Rectangle carac4=new Rectangle(w4+20,100,d4.getWidth()-50,d4.getHeight()-75);
		Rectangle carac5=new Rectangle(w5+20,100,d5.getWidth()-50,d5.getHeight()-75);
		Rectangle carac6=new Rectangle(w6+20,100,d6.getWidth()-50,d6.getHeight()-75);
		if(Intersector.overlaps(ike,carac1)||Intersector.overlaps(ike,carac2)||Intersector.overlaps(ike,carac3)||Intersector.overlaps(ike,carac4)||Intersector.overlaps(ike,carac5)||Intersector.overlaps(ike,carac6)){
			gameover();
		}

		/*shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(wb+25,hb,bike.getWidth()-100,bike.getHeight()-100);
        shapeRenderer.rect(w1+20,100,d1.getWidth()-50,d1.getHeight()-75);
        shapeRenderer.rect(w2+20,100,d2.getWidth()-50,d2.getHeight()-75);
        shapeRenderer.rect(w3+20,100,d3.getWidth()-50,d3.getHeight()-75);
        shapeRenderer.rect(w4+20,100,d4.getWidth()-50,d4.getHeight()-75);
        shapeRenderer.rect(w5+20,100,d5.getWidth()-50,d5.getHeight()-75);
        shapeRenderer.rect(w6+20,100,d6.getWidth()-50,d6.getHeight()-75);
		shapeRenderer.circle(w1,100,d1.getWidth()/2);
		shapeRenderer.circle(w2,100,d1.getWidth()/2);
		shapeRenderer.circle(w3,100,d1.getWidth()/2);
		shapeRenderer.circle(w4,100,d1.getWidth()/2);
		shapeRenderer.circle(w5,100,d1.getWidth()/2);
		shapeRenderer.circle(w6,100,d1.getWidth()/2);
		shapeRenderer.end();*/
		batch.end();
	}
	
	@Override
	public void dispose () {

	}
	public void gameover(){
		wb=0;hb=100;
		w=1;
		o=1;
		start();
		x=0;
		x1=Gdx.graphics.getWidth();
		game=false;
	}
	public void start(){
		w1=Gdx.graphics.getWidth();
		w2=Gdx.graphics.getWidth() + 2*Gdx.graphics.getWidth()/3;
		w3=(Gdx.graphics.getWidth()) + 4*Gdx.graphics.getWidth()/3;
		w4=(Gdx.graphics.getWidth()) + 6*Gdx.graphics.getWidth()/3;
		w5=(Gdx.graphics.getWidth()) + 8*Gdx.graphics.getWidth()/3;
		w6=(Gdx.graphics.getWidth()) + 10*Gdx.graphics.getWidth()/3;
		d1 = new Texture(bik[random.nextInt(9)] + ".png");
		d2 = new Texture(bik[random.nextInt(9)] + ".png");
		d3 = new Texture(bik[random.nextInt(9)] + ".png");
		d4 = new Texture(bik[random.nextInt(9)] + ".png");
		d5 = new Texture(bik[random.nextInt(9)] + ".png");
		d6 = new Texture(bik[random.nextInt(9)] + ".png");
		batch.draw(d2,w2,100);
		batch.draw(d1,w1,100);
		batch.draw(d3,w3,100);
		batch.draw(d4,w4,100);
		batch.draw(d5,w5,100);
		batch.draw(d6,w6,100);
		l=1;
	}
}
