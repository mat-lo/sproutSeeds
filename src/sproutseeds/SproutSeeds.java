package sproutseeds;

import processing.core.PApplet;
import processing.core.PFont;

//test
public class SproutSeeds extends PApplet {
	
	PFont droid;

	public void setup() {
		
		size(1024,800);
		droid = loadFont("DroidSerif-96.vlw");
		
		smooth();
	}

	public void draw() {
		
		background(240);
		
		noStroke();
		fill(128);
		ellipse(200,150,200,200);
		
		fill(0);
		textFont(droid,96);
		text("Hemp",350,130);
		
		paragraph(190,16);				
		sprout(380,550,mouseX/2);
		holes(500,330,mouseX/30);
		
	}
	
	
	public void paragraph(float yTop, float charSize) {
		textFont(droid,charSize);
		text("Hemp has been used for millenials. It has all",350,yTop);
		text("the amminoacids required by our body and",350,yTop+20);
		text("theoretically, a man can survive just by eating",350,yTop+40);
		text("Hemp Seeds",350,yTop+60);
	}
	
	void sprout(float baseX, float baseY, float Sheight) {
		
		//height limits
		if (Sheight > 300) Sheight = 250;
		else if (Sheight < 60) Sheight = 60;
		
		stroke(0);
		strokeWeight(Sheight*0.05f);
		noFill();
		
		//stem		
		bezier(baseX+Sheight*0.1f,baseY-Sheight,		baseX-Sheight*Sheight*0.0018f,baseY-Sheight+Sheight/3,		baseX,baseY-(Sheight/3),		baseX,baseY);
		
		//top
		noStroke();
		fill(0);
		ellipse(baseX+Sheight*0.1f,baseY-Sheight,Sheight*0.1f,Sheight*0.1f);		
		
		}
	
	void holes(float left, float top, float diam) {
		noStroke();
		fill(128);
		int rectWidth = 200;
		int rectMargin = 20;
		
		float spacing = (rectWidth/2 - rectMargin) / 3;
		rect(left,top,rectWidth,rectWidth/2);
		
		fill(240);
		for (int j = 0; j < rectWidth/2; j+= spacing) {
			for(int i = 0; i < rectWidth/2; i+= spacing) {
				ellipse(left+rectMargin/2+i,top+10+j,diam,diam);
			}
		}
	}
}
