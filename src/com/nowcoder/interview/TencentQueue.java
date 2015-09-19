package com.nowcoder.interview;

import java.util.LinkedList;

/*
 * 请设计一个排队系统，能够让每个进入队伍的用户都能看到自己在队列中所处的位置和变化，
 * 队伍可能随时有人加入和退出；当有人退出影响到用户的位置排名时需要及时反馈到用户
 */
class User{
	String name;
	int queuePos;
	TencentQueue queue;
	public User(String n) {
		// TODO Auto-generated constructor stub
		this.name=n;
	}
	public void insertQueue(TencentQueue q){
		this.queue=q;
		queuePos=queue.queueSize();
		queue.insertUser(this);
	}
	public void leaveQueue(){
		queue.userLeave(this);;
	}
	public void updatePos(int x){
		this.queuePos=x;
	}
	public int getPrePos(){
		return queuePos;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+" pos:"+queuePos;
	}
	
}
public class TencentQueue {
	LinkedList<User> queue=new LinkedList<>();
	public void insertUser(User user){
		queue.add(user);
	}
	public int queueSize(){
		return queue.size()+1;
	}
	public void userLeave(User user){
		if(!queue.contains(user))
			throw new IllegalArgumentException();
		int leavePos=queue.indexOf(user);
		queue.remove(user);
		updateUserPos(leavePos);
	}
	private void updateUserPos(int leavepos){
		for(User user:queue){
			if(user.queuePos>leavepos){
				user.updatePos(user.getPrePos()-1);
			}
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder builder=new StringBuilder();
		for(User user:queue){
			builder.append(user).append(",");
		}
		return builder.toString();
	}
	public static void main(String[] args) {
		User[] users=new User[6];
		TencentQueue queue=new TencentQueue();
		for(int i=0;i<6;i++){
			users[i]=new User("user"+i);
			users[i].insertQueue(queue);
		}
		System.out.println(queue);
		users[4].leaveQueue();
		System.out.println(queue);
	}
	
}
