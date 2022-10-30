package com.codec.assessment.robot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RobotNavigation {

	@Value("${app.grid}")
	String grid;
	@Value("${app.command}")
	String command;
	
	
	public String finalPosition(){
		String result=null;
		int xMax=0,yMax=0;
		if(grid==null || command ==null) return result;
		try {
			checkValidGrid(grid);
			checkValidCommand(command);
		} catch (Exception e) {
			e.printStackTrace();
		}
		xMax = Integer.parseInt(grid.charAt(0)+"");
		yMax = Integer.parseInt(grid.charAt(2)+"");
		int x=1;
		int y=1;
		String facing ="north";
		for(int i=0;i<command.length();i++) {
			if(command.charAt(i)=='R') {
				facing = facingForRight(facing,x,y,xMax,yMax);
			}
			if(command.charAt(i)=='L') {
				facing = facingForLeft(facing,x,y,xMax,yMax);
			}
			
			if(command.charAt(i)=='F') {
				if(facing =="east")
					if(x!=xMax)
						x++;
				if(facing =="west")
					if(x>0)
						x--;
				if(facing =="north")
					if(y!=yMax)
						y++;
				if(facing =="south")
					if(y>0)
						y--;
				
			}
			
		}
		return x+"," + y +","+facing;
	}

	private String facingForRight(String facing, int x,int y,int xMax,int yMax) {
		String result = null;
		switch (facing) {
		case "north":
			result="east";
			if(x!=xMax) x++;
			break;
		case "east":
			result="south";
			if(x>0)x--;
			break;
		case "south":
			result="west";
			if(y>0) y--;
			break;
		case "west":
			result="north";
			if(y!=yMax)y++;
			break;

		default:
			break;
		}
		return result;
	}

	private String facingForLeft(String facing, int x,int y,int xMax,int yMax) {
		String result = null;
		switch (facing) {
		case "north":
			result="west";
			if(y>0) y--;
			break;
		case "east":
			result="north";
			if(y!=yMax)y++;
			break;
		case "south":
			result="east";
			if(x!=xMax) x++;
			break;
		case "west":
			result="south";
			if(x>0)x--;
			break;

		default:
			break;
		}
		return result;
	}

	private void checkValidCommand(String command) throws Exception {
		for (char c: command.toCharArray()) {
			if(c=='L'||c=='R'||c=='F' ) continue;
			else
				throw new Exception("Grid not valid");
		}
	}

	private void checkValidGrid(String grid) throws Exception{
		if(grid.length()!=3) {
		throw new Exception("Grid not valid");
		}
	}
}
