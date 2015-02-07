/**
 * John Lu (johnlu), Guanyu Chen (guanyu)
 * Extra Credit: Stream (20pts), Multiplayer (20pts), ...
 * ... Title/GameOver Screen(10pts), Faster Cars (10pts)
 */

package lab10;

import java.awt.Color;
import sedgewick.StdAudio;
//import java.awt.event.KeyEvent;
//import java.util.LinkedList;
import sedgewick.StdDraw;
//import lab10.ArcadeKeys;
import lab10.FroggerGame;

public class Frogger implements FroggerGame {
	
//	(1) why does pause() work but not show()?
//	(2) why do cars disappear?
//	(3) does the code make it to line 380 (ex. hasCollided)?
	
	public int score;
	public int score2;
	public int lives;
	public int lives2;
	public boolean hasDied;
	public boolean hasDied2;
	public boolean hasMet;
	public boolean hasMet2;
	public boolean hasCollided;
	public boolean hasCollided2;

	public Frogger() {
	}

	@Override
	public void playGame() {
		Frog f = new Frog(0.4, 0.025, Color.CYAN);
		Frog f2 = new Frog(0.6, 0.025, Color.ORANGE);
		Car [] cars = new Car[8];
		Goal [] goals = new Goal[5];
		River r = new River();
		Log[] logs = new Log[10];
		Puddle [] puddles1 = new Puddle[12];
		Puddle [] puddles2 = new Puddle[12];
		
		
		Car a = new Car(0.2, 0.2, 0.005,true);     
		Car a2 = new Car(0.6, 0.2, 0.005,true);

        Car b = new Car(0.1, 0.25, 0.006,false);  
        Car b2 = new Car(0.7, 0.25, 0.006,false);

        Car c = new Car(0.3, 0.3, 0.007,true);        
        Car c2 = new Car(0.8, 0.3, 0.007,true);

        Car d = new Car(0.4, 0.35, 0.004,false);        
        Car d2 = new Car(0.9, 0.35, 0.004,false);

        
        Log l1 = new Log(.1, .485, .008,true);        
        Log l10 = new Log(.4, .485, .008,true);

        Log l2 = new Log(.2, .565, .005,false);        
        Log l20 = new Log(.5, .565, .005,false);

        Log l3 = new Log(.3, .649, .003,true);        
        Log l30 = new Log(.7, .649, .003,true);

        Log l4 = new Log(.4, .724, .007,false);        
        Log l40 = new Log(.8, .724, .007,false);

        Log l5 = new Log(.5, .799, .008,true);        
        Log l50 = new Log(.9, .799, .008,true);
        
        cars[0] = a;
        cars[1] = b;
        cars[2] = c;
        cars[3] = d;
        cars[4] = a2;
        cars[5] = b2;
        cars[6] = c2;
        cars[7] = d2;
        
        logs[0] = l1;
        logs[1] = l2;
        logs[2] = l3;
        logs[3] = l4;
        logs[4] = l10;
        logs[5] = l20;
        logs[6] = l30;
        logs[7] = l40;
        logs[8] = l5;
        logs[9] = l50;
		
		Goal g1 = new Goal(0.1);
		Goal g2 = new Goal(0.3);
		Goal g3 = new Goal(0.5);
		Goal g4 = new Goal(0.7);
		Goal g5 = new Goal(0.9);
		
		goals [0] = g1;
		goals [1] = g2;
		goals [2] = g3;
		goals [3] = g4;
		goals [4] = g5;
		
		boolean [] met = new boolean[5];
		
		met[0] = false;
		met[1] = false;
		met[2] = false;
		met[3] = false;
		met[4] = false;
		
		int score = 0;
		int score2 = 0;
		int lives = 5;
		int lives2 = 5;
		double tlength = 0.5;
		double t2length = 0.5;
		
		Frog t = new Frog(0.5, 0.025, Color.CYAN);
		Frog u = new Frog(0.5, 0.025, Color.ORANGE);
		Frog v = new Frog(0.5, 0.025, Color.CYAN);
		River s = new River();
		
		boolean begin = false;
		boolean first = true;
		boolean credits = true;
		int k = 0;
		int j = 0;
		
		Credits g = new Credits();
		
		StdDraw.setPenColor(); // this opening screen allows one to skip the intro
		StdDraw.filledRectangle(0.5, 0.5, 1, 1);
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.text(0.5, 0.8, "AFROGCALYPSE");
		StdDraw.text(0.5, 0.2, "Press 1 and 2 to begin.");
		StdDraw.picture(0.5, 0.5, "images/(r)greenFrogRest.png");
		StdDraw.pause(1000);
		if(ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_WHITE)&&
				ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_WHITE)){ // both players press start to begin
			begin = true;
		}
		StdDraw.pause(1000);
		
		while(!begin){ // formal introduction to the game
			if(first){
				StdAudio.play("sound/stairway.wav");
			}
			StdDraw.setPenColor();
			StdDraw.filledRectangle(0.5, 0.5, 1, 1);
			if(!first){ // enables animation at the end of the introduction
				StdDraw.setPenColor(Color.WHITE);
				StdDraw.text(0.5, 0.8, "AFROGCALYPSE");
				StdDraw.picture(0.5, 0.5, "images/(r)greenFrogMove.png");
			}
			if(credits){ // plays backstory once
				while(g.getposY()<1.0){
					StdDraw.setPenColor();
					StdDraw.filledRectangle(0.5, 0.5, 1, 1);
					g.move();
					if(g.getposY()>=0.00 && g.getposY()<=0.01){
						StdAudio.play("sound/stairway.wav"); // replays intro theme a second time
					}
					g.draw();
//					System.out.println(g.getposY());
//					why doesn't StdDraw.show() work?
					StdDraw.pause(50);
					credits = false;
				}
			}
//			System.out.println("aha");
			int tc = 0;
			int uc = 0;
			int vc = 0;
			while(t.getposY()<0.3){
//				System.out.println("hoho");
				StdDraw.setPenColor();
				StdDraw.filledRectangle(0.5, 0.5, 1, 1);
				t.posY+=0.05;
				if(tc%2==1){
					StdDraw.picture(t.getposX(), t.getposY(), "images/(rr)greenFrogRest.png");
				}
				s.draw();
				t.draw();
				StdDraw.pause(50);
				tc++;
			}
			while(u.getposY()<0.3){
				StdDraw.setPenColor();
				StdDraw.filledRectangle(0.5, 0.5, 1, 1);
				u.posY+=0.05;
				if(uc%2==1){
					StdDraw.picture(u.getposX(), u.getposY(), "images/(rr)orangeFrogRest.png");
				}
				if(u.posY == t.posY){ // evil frog pushes daddy frog into river
					t.posY = 0.5;
				}
				s.draw();
				t.draw();
				u.draw2();
				StdDraw.pause(50);
				uc++;
			}
			
			if(first){ // opening animation
				StdDraw.pause(1000);
				StdDraw.setPenColor();
				StdDraw.filledRectangle(0.5, 0.5, 1, 1);
				StdDraw.setPenColor(Color.WHITE);
				StdDraw.text(0.5, 0.5, "Your father died to bring honor to your species...");
				StdDraw.pause(1500);
				StdDraw.setPenColor();
				StdDraw.filledRectangle(0.5, 0.5, 1, 1);
				StdDraw.setPenColor(Color.WHITE);
				StdDraw.text(0.5, 0.5, "You must take his place...");
				StdDraw.pause(1500);
				StdDraw.setPenColor();
				StdDraw.filledRectangle(0.5, 0.5, 1, 1);
				StdDraw.setPenColor(Color.WHITE);
				StdDraw.text(0.5, 0.5, "AND AVENGE HIM!!!");
				StdDraw.pause(1500);
				first = false;
			}
			
			while(v.getposY()<0.3){
				StdDraw.setPenColor();
				StdDraw.filledRectangle(0.5, 0.5, 1, 1);
				v.posY+=0.05;
				if(vc%2==1)StdDraw.picture(v.getposX(), v.getposY(), "images/(rr)greenFrogRest.png");
				if(v.posY == u.posY){ // the dutiful son pushes evil frog into river
					u.posY = 0.5;
				}
				s.draw();
				u.draw2();
				v.draw();
				StdDraw.pause(50);
				vc++;
			}
			StdDraw.pause(1000);
			StdDraw.setPenColor();
			StdDraw.filledRectangle(0.5, 0.5, 1, 1);
			StdDraw.setPenColor(Color.WHITE);
			StdDraw.text(0.5, 0.8, "AFROGCALYPSE");
			StdDraw.text(0.5, 0.2, "Press 1 and 2 to begin.");
			StdDraw.picture(0.5, 0.5, "images/(r)greenFrogRest.png");
			StdDraw.pause(1000);
			if(ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_WHITE)&&
					ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_WHITE)){
				begin = true;
			}
		}
		boolean shot1 = false;
		boolean shot2 = false;
		while(begin){
			int playTime = 0;
		while (lives>0 || lives2>0){
			StdDraw.clear();
			StdDraw.setPenColor();
			StdDraw.filledSquare(0.5, 0.5, 1);
			
			if(playTime==0){
				StdAudio.play("sound/Fix It Felix.wav");
			}
			
			if(playTime<200){//the file is 10 seconds long and loop updates every 50ms
				playTime++;	 //so the entire song will replay after playTime goes up to 200 = 10000/50
//				System.out.println(playTime);
				if(playTime==200){playTime=0;}
			}
			
			Rocket p = f.fireMissile(); // stores a missile if fired
			Rocket q = f2.fireMissile2();
			
			if(k<puddles1.length){
				puddles1[k] = f.leavePuddle(); // limits number of puddles created
				if(puddles1[k]!=null){
					k++;
//				System.out.println(k);
				}
			}
			
			if(shot1){ //makes screen white to signify explosion--> see below for more info
				StdDraw.clear();
				shot1 = false;
			}
			
			if(j<puddles2.length){
				puddles2[j] = f2.leavePuddle2();
				if(puddles2[j]!=null){
					j++;
//				System.out.println(j);
				}
			}
			
			if(shot2){
				StdDraw.clear();
				shot2 = false;
			}
			
			if(p!=null){ // missile moves up until it hits the river, a frog, or a car in bottom half...
				int pmove = 0; //... then moves up until top of screen in top half
				while(p.getposY()<1.0 && !p.collide(r) && !p.collide(cars[0]) 
						&& !p.collide(cars[1]) && !p.collide(cars[2])&&!p.collide(f2)){
					p.move();
					p.draw();
					shot1 = true; // referenced above
					pmove++;
				}
//				System.out.println("p: " + pmove);
				for(int i=0; i<cars.length; i++){ // if car is hit, then position resets (or blows up)
					if (p.collide(cars[i])){
						cars[i].posX = 0.0;
					}
				}
				
				if (p.collide(f2)){// if other frog is hit, then position resets
					f2.posY = 0.0;
				}
			}
			
			if(q!=null){
				int qmove = 0;
				while(q.getposY()<1.0 && !q.collide(r) && !q.collide(cars[0]) 
						&& !q.collide(cars[1]) && !q.collide(cars[2])&&!q.collide(f2)){
					q.move2();
					q.draw();
					shot2 = true;
					qmove++;
				}
//				System.out.println("q:" + qmove);
				for(int i=0; i<cars.length; i++){
					if (q.collide(cars[i])){
						cars[i].posX = 0.0;
					}
				}
				
				if (q.collide(f)){
					f.posY = 0.0;
				}
			}
			
			
			if(lives>0 && !shot2){f.move();} // the other player cannot move while missile is shot
			if(lives2>0 && !shot1){f2.move2();}
			
			hasDied = false;
			hasDied2 = false;
			hasCollided = false;
			hasCollided2 = false;
			boolean xHasDied = false;
			boolean xHasDied2 = false;
			boolean xCollide = false;
			
			for(int i=0; i<puddles1.length;i++){
				if(puddles1[i]!=null){ // draws puddles that have been activated
					puddles1[i].draw();
					if(f.collide(puddles1[i])){ // kills frogs that collide with it
						hasDied = true;
//						System.out.println(hasDied);
					}
					if(f2.collide(puddles1[i])){
						hasDied2 = true;
//						System.out.println(hasDied2);
					}
				}
			}
			
			for(int i=0; i<puddles2.length;i++){
				if(puddles2[i]!=null){
					puddles2[i].draw();
					if(f.collide(puddles2[i])){
						hasDied = true;
//						System.out.println(hasDied);
					}
					if(f2.collide(puddles2[i])){
						hasDied2 = true;
//						System.out.println(hasDied2);
					}
				}
			}
			
			for(int i=0; i<cars.length; i++){
				if (p!=null){
					if(p.collide(cars[0]) || p.collide(cars[1]) || p.collide(cars[2])){
						xCollide = true;
						hasCollided = true;
					}
				}
				
				if (q!=null){
					if(q.collide(cars[0]) || q.collide(cars[1]) || q.collide(cars[2])){
						xCollide = true;
						hasCollided2 = true;
					}
				}
				
				if (!xCollide){
					cars[i].move();
				}
				
				if (cars[i].rl){ // draws right or left based on boolean
					cars[i].draw();
				}
				else{
					cars[i].draw2();
					}
				
				xHasDied = f.collide(cars[i]);
				xHasDied2 = f2.collide(cars[i]);
				if(xHasDied){hasDied=true;} // if frog collides with any car, it will die
				if(xHasDied2){hasDied2=true;}
			}
			
			r.draw();
			
			for(int i=0; i<logs.length; i++){
				logs[i].move();
				if (logs[i].rl){
					logs[i].draw();
				}
				else{
					logs[i].draw2();
					logs[i].width = logs[i].width2;
					}
				if(f.collide(logs[i])){ 	 // frog have same speed as logs
					f.posX += logs[i].speed; // frogs go right on ice because momentum... 							
				}							 // ... is preserved from when it was on the log
				if(f2.collide(logs[i])){
					f2.posX += logs[i].speed;
				}
			}
			
			if (f.collide(r)){
				int count = 0;
				for(int i=0; i<logs.length; i++){
					if(!f.collide(logs[i])){
						count++;
					}
				}
				if (count==logs.length){ // if frog is not on any of the logs, then it dies
					hasDied = true;
				}
			}
			
			if (f2.collide(r)){
				int count = 0;
				for(int i=0; i<logs.length; i++){
					if(!f2.collide(logs[i])){
						count++;
					}
				}
				if (count==logs.length){
					hasDied2 = true;
				}
			}
			
			hasMet= false;
			hasMet2 = false;
			boolean y = false;
			boolean z = false;
			for(int i=0; i<goals.length; i++){
				goals[i].draw();
				y = f.collide(goals[i]);
				z = f2.collide(goals[i]);
				if(y && !met[i]){ // there must be a collision and the goal must be empty
					hasMet = true;
					met[i] = true;
				}
				if(z && !met[i]){
					hasMet2 = true;
					met[i] = true;
				}
			}
			
			for(int i=0; i<met.length;i++){
				if(met[i]){
					goals[i].stay(); // changes the appearance of a goal after a collision
				}
			}
			if(lives>0){f.draw();} // if frog is alive, draw it
			if(lives2>0){f2.draw2();}
			

			if (hasDied || tlength<0.003){ // frog either runs out of time or runs into something to die
				f = new Frog(0.5, 0.025, Color.CYAN);
				tlength = 0.5;
				lives--;
			}
			
			if (hasDied2 || t2length<0.003){
				f2 = new Frog(0.7, 0.025, Color.ORANGE);
				t2length = 0.5;
				lives2--;
			}
			
			if (hasMet && lives>0){ // advances frog to new level if still alive
				for(int i=0; i<cars.length;i++){
					cars[i].speed+=0.001; // increases speed of cars
				}
				for(int i=0; i<logs.length;i++){
					logs[i].speed+=0.001; // increases speed of logs
				}
				f = new Frog(0.5, 0.025, Color.CYAN);
				score+=100; // updates score
				tlength = 0.5; // resets time
			}
			
			if (hasMet2 && lives2>0){
				for(int i=0; i<cars.length;i++){
					cars[i].speed+=0.001;
				}
				for(int i=0; i<logs.length;i++){
					logs[i].speed+=0.001;
				}
				f2 = new Frog(0.7, 0.025, Color.ORANGE);
				score2+=100;
				t2length = 0.5;
			}
			
			if(lives<0){lives = 0;} // keeps lives at zero, even if actually negative
			if(lives2<0){lives2 = 0;}
			if(score==300 || score2 ==300){lives=0; lives2=0;}
			StdDraw.setPenColor(Color.WHITE);
			StdDraw.text(0.09, 1.00, "Player 1 Lives: " + lives); // informs players of frog's status
			StdDraw.text(0.64, 1.00, "Player 2 Lives: " + lives2);
			StdDraw.text(0.1, 0.97, "Player 1 Score: " + score);
			StdDraw.text(0.65, 0.97, "Player 2 Score: " + score2);
			if(lives>0){
				StdDraw.setPenColor(Color.CYAN);
				StdDraw.filledRectangle(0.5, 0.005, tlength, 0.01); // time limit as a bar
				tlength-=0.001; // gradually decreases time
			}
			if(lives2>0){
				StdDraw.setPenColor(Color.ORANGE);
				StdDraw.filledRectangle(0.5, -0.025,t2length, 0.01);
				t2length-=0.001;
			}
			
			StdDraw.show(50);
			
			int count=0;
			for(int i=0; i<met.length;i++){
				if(met[i]){count++;}
			}
			if(count==5){ // if all five goals are filled, the game ends
				lives=0;
				lives2=0;
			}
		}
		StdDraw.clear();
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(0.5, 0.5, "Game Over"); // final game over screen
		StdDraw.text(0.5, 0.95, "Player 1 Score: " + score);
		StdDraw.text(0.5, 0.85, "Player 2 Score: " + score2);
		StdDraw.show(50);
	}
	}
	@Override
	public String getGameName() {
		return "Frogger";
	}

	@Override
	public String[] getTeamMembers() {
		String[] byline = { "John Lu", "Guanyu Chen" };
		return byline;
	}

	public static void main(String[] args) {
		Frogger f = new Frogger();
		f.playGame();
	}
}


//if(hasCollided || hasCollided2){
//StdDraw.pause(1000);
//StdDraw.clear();
//}
//fix up the missile...
//cars[i].draw();
//Car a = new Car(0.15, 0.020);
//Car b = new Car(0.25, 0.015);
//Car c = new Car(0.35, 0.010);
//
//cars [0] = a;
//cars [1] = b;
//cars [2] = c;
//Log l1 = new Log(0.55, 0.005);
//Log l2 = new Log(0.55, 0.003);
//Log l3 = new Log(0.55, 0.001);
//
//logs [0] = l1;
//logs [1] = l2;
//logs [2] = l3;

//For thousands of years the Amazonians and the 
//Applachians lived together in harmony. Then the 
//comet struck the earth and changed everything. 
//Froglandia became uninhabitable and so began the 
//race to build vessels that would send individuals
//to the moon. These frogs would have to leave behind 
//the home they once knew in order to ensure the 
//survival of the species. The rest would remain 
//on Earth to die a slow and painful death.
//
//Once the greatest possible number of ships was
//produced, the Council of Elders agreed to send all 
//of the females in the largest of the ships, leaving 
//enough ships for five males. They then nominated your 
//father and his Amazonian brethren to board the 
//remaining pods because their seed was robust and was 
//therefore better suited to endure the moon's harsh 
//climate. But your father's Applachian rival and his 
//gang of thugs had other plans in mind.

//why can't I extract a boolean as a separate variable?
//abc = !p.collide(cars[0])&& !p.collide(cars[1]);
//System.out.println(abc);
//while(p.getposY()<1.0 && abc){
//Car s = new Car(0.5, 0.020);
//s.posX = 0;
//while(s.getposX()<0.5){
//	StdDraw.setPenColor();
//	StdDraw.filledRectangle(0.5, 0.5, 1, 1);
//	s.posX+=0.05;
//	t.draw();
//	u.draw2();
//	s.draw();
//	StdDraw.pause(50);
//}
//Dad: "Wish me luck, son. If I make it through this game, we'll be rich!"
//[Dad walks onto the street. Truck approaches.]
//Son: "Daddy! Where are you going?"
//[Dad turns back.]
//Dad: "Huh?"
//[Dad gets hit by a truck.]
//Rival: Hahaha what a loser!!!
//[The rival runs ahead.]
//Your father died to bring honor to your family...
//AVENGE HIM!!!

//double time = 500;
//while (time > 0)
//if (hasDied || lives == 0)
//time = 0;
//time--;
//StdDraw.text(0.5, 0.95, "time: " + Math.round(time / 500 * 30));
//public boolean [] isFilled;
//isFilled = new boolean[goals.length]; 
//if (q!=null){p=null;}
//if (p!=null){q=null;}
//if(p!=null){
//	xCollide = p.collide(cars[i]);
//	if(xCollide){hasCollided=true;}
//	if(xCollide2){hasCollided2=true;}
//	System.out.println(hasCollided);
//}
//LinkedList<Car> cars = new LinkedList<Car>();
//cars.add(a);
//cars.add(b);
//boolean shot = false;
//if(p!=null){
//	for(int i=0; i<cars.length;i++){
//		shot = p.collide(cars[i]);
//		System.out.println(shot + " " + abc);
//		if(shot){abc = true;}
//	}
//}
//boolean abc = false;
//int k=0;
//boolean z = false, v = false;
//Frog [] abc = new Frog[5];
//for(int i=0; i<abc.length; i++){
//if(abc[i]!=null){abc[i].draw();}
//}
//&&!z&&k<abc.length
//f.posX = goals[i].posX;
//f.posY = goals[i].posY;
//f.draw();
	
//	if(k<abc.length){
//	System.out.println(k);
//	abc[k] = f;
//	k++;
//}
//for (int j=0; j<abc.length;j++){
//if(abc[j]!=null){
//	v = abc[j].collide(goals[i]);
//	if(v){z=true;}
////	System.out.println(z);
//}
//}
////if(y)System.out.println("collision");
//if (hasDied){
//	StdDraw.clear();
//	StdDraw.setPenColor();
//	StdDraw.filledSquare(0.5, 0.5, 1);
//	
//	for(int i=0; i<cars.length;i++){
//		cars[i].draw();
//	}
//	
////	c.draw();
//	StdDraw.setPenColor(Color.WHITE);
//	StdDraw.text(0.5, 0.90, "lives: " + lives);
//	StdDraw.text(0.5, 0.95, "score: " + score);
////	StdDraw.text(0.5, 0.95, "time: " + Math.round(time / 500 * 30));
//	StdDraw.filledRectangle(0.5, 1.00, tlength, 0.01);
//	StdDraw.show(50);
////	time = 500;
//}

// if (check1){
// StdDraw.clear();
// StdDraw.setPenColor(Color.BLACK);
// StdDraw.text(0.5, 0.5, "New Level");
// StdDraw.show(500);
// time = 500;
// }
