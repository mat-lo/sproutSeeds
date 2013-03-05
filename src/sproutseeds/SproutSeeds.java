package sproutseeds;

import controlP5.ControlP5;
import processing.core.PApplet;
import processing.core.PFont;

public class SproutSeeds extends PApplet {
	
	PFont droid;
	ControlP5 cp5;

	public void setup() {
		
		size(1024,800);
		droid = loadFont("DroidSerif-96.vlw");
		
		cp5 = new ControlP5(this);
		
		cp5.setColorForeground(0xff000000);
		cp5.setColorBackground(0xff808080);
		cp5.setColorActive(0xff303030);
		cp5.setControlFont(droid,15);
		cp5.setColorLabel(0xff000000);

		
		 cp5.addSlider("Bitter")
	     .setPosition(500,445)
	     .setRange(0,30)
	     .setSize(150,20);
	     ;
	     
	     cp5.addSlider("Nutrients")
	     .setPosition(500,478)
	     .setRange(0,30)
	     .setSize(150,20);
	     ;
		
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
		holes(500,330,21);
		
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
		int rectMargin = 22;
		
		float spacing = 28;
		rect(left,top,rectWidth,rectWidth/2);
		
		fill(240);
		for (int j = 0; j < 3; j+= 1) {
			for(int i = 0; i < 3; i+= 1) {				
				ellipse(left+rectMargin+i*spacing,top+rectMargin+j*spacing,diam,diam);
			}
		}
		
		textFont(droid,42);
		text("4",left+110,top+rectWidth/4+10);
		textFont(droid,24);
		text("mm",left+140,top+rectWidth/4+10);
	}
}
