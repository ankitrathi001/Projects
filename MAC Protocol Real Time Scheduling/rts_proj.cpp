#include<iostream>
#include<list>
#include<functional>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

using namespace std;

typedef struct taskType{
	int Ci,Di,Rem;
}defTask;

std::list<defTask> tasks;

bool compare(const defTask& a,const defTask& b)
{
	if(a.Di < b.Di)
		return true;
	return false;
}

void assignRandom(int n,int new_add,int totalFrame,int curtime)
{
	for(int i=0;i<new_add;i++)
	{
		srand(time(NULL)*(i+1));
		defTask newtask;
		newtask.Ci=rand()%(totalFrame/2)+1;
		newtask.Di=rand() %(totalFrame/3) +newtask.Ci+1 + curtime;
		newtask.Rem=newtask.Ci;
		tasks.push_back(newtask);
	}
	return;
}

int main()
{
	int totalFrame;
	cout << "Enter the number of frames for which you want to run the schedule"<<endl;
	cin >> totalFrame;
	int frameSize=0,n=0,new_add=0,count=totalFrame,curtime=0;
	std::list<defTask>::iterator it;
	while(count--)
	{
		for(it=tasks.begin(); it!=tasks.end();it++)
		{
			if((it->Rem)<=0)
			{
				tasks.erase(it--);
				n--;
			}
		}
		srand(time(NULL)*curtime);
		new_add=rand()%totalFrame;
		if(n==0 && new_add==0)
			new_add=1;
		curtime++;
		assignRandom(n,new_add,totalFrame,curtime);
		n+=new_add;
		cout<<n<<" tasks started to schedule"<<endl;
		for(it=tasks.begin(); it!=tasks.end();it++)
			frameSize+=(it->Rem);
		frameSize=totalFrame - frameSize/n+1;
		cout<<frameSize<<" time slot"<<endl;
		tasks.sort(compare);
		for(it=tasks.begin();it!=tasks.end();it++)
		{
			cout<<"Task with requirement "<<it->Rem<<" & Deadline "<<it->Di<<" started at "<<curtime<<" and remaining budget "<<frameSize<<endl;
			if((it->Rem)<=frameSize)
			{
				frameSize-=(it->Rem);
				curtime+=(it->Rem);
				(it->Rem)=0;
				cout<<"Task completed at "<<curtime<<" and remaining budget "<<frameSize<<endl;
			}
			else
			{
				(it->Rem)-=frameSize;
				frameSize=0;
				curtime+=frameSize;
				cout<<"Task preempted at "<<curtime<<" and remaining finished "<<endl;
			}
			if(frameSize==0)
				break;
		}
	}
	return 0;
}
