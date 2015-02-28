#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<limits.h>
#include<math.h>

#define debug 0

int choice; // 1 -> Fixed Priority; 2 -> Dynamic Priority

typedef struct forOutput
{
	float endTime,startTime;
	int jobNum;
	int jobType;
}sigmaType;
sigmaType sigmaFunction[1000];
int sigmaCounter;

typedef struct eventDataType
{
	float creatTime;
	float time;
	int eventSrc;
	int eventName; //1 -> Job Completion; 2 -> Timeperiod Renewal; 3 -> Aperiodic Task Arrival; 4 -> Refill of Server; 5 -> Server Exhaust
}eventType;
eventType * Events;
int eventCount;

typedef struct Task
{
	float Ti,Ci,Ai,Di,Rem;  //Rem -> Remaining Execution Time
	int serverFlag,jobNum;  //compFlag -> For Aperiodic Task to mark whether it is complete or not
	float compFlag;
}taskType;
taskType * ptList;
taskType * aptList;

typedef struct processCB {
	int priority,jobType,jobPointer,jobNum; //jobType ---> 1=Periodic Task; 2=Aperiodic Task; -1=Idle;
	float startTime;
}process;

typedef struct forServer{
	float renewal,startTime,endTime;
	int refillFlag; //refillFlag = The corresponding refill has been conpleted if 1
}serverType;
serverType * serverActive;
int activeCount;

typedef struct forDynamic{
	int jobNum,jobPos;
}mapType;
mapType * mapPeriodic;
mapType * mapAperiodic;

void swap(eventType arr[],int i,int j)
{
	void * temp;
	temp=(void *)malloc(sizeof(eventType));
	memcpy((void *)temp,(void *)(arr+j),sizeof(eventType));
	memcpy((void *)(arr+j),(void *)(arr+i),sizeof(eventType));
	memcpy((void *)(arr+i),(void *)temp,sizeof(eventType));
	return;
}

void shuffleUp(eventType arr[],int i)
{
	int j=i,x=i/2;
	if(x>0 && ((arr[x].time>arr[j].time) || (arr[x].time==arr[j].time && arr[x].eventName>arr[j].eventName)))
	{
		swap(arr,j,x);
		shuffleUp(arr,x);
	}
	return;
}

void shuffleDown(eventType arr[],int n,int i)
{
	int j=i,x=2*j;
	if((2*j+1)<=n && ((arr[2*j].time>arr[2*j+1].time) || (arr[2*j].time==arr[2*j+1].time && arr[2*j].eventName>arr[2*j+1].eventName)))
		x++;
	if(x<=n && ((arr[x].time<arr[j].time) || (arr[x].time==arr[j].time && arr[x].eventName>arr[j].eventName)))
	{
		swap(arr,j,x);
		shuffleDown(arr,n,x);
	}
	return;
}

void heapify(eventType arr[],int n)
{
	int i;
	for(i=n/2;i>0;i--)
		shuffleDown(arr,n,i);
	return;
}

void push(float time,int type,int src,float presTime)
{
	Events[eventCount].creatTime=presTime;
	Events[eventCount].time = time;
	Events[eventCount].eventSrc = src;
	Events[eventCount++].eventName = type;
	shuffleUp(Events,eventCount-1);
	return;
}

void pop()
{
	eventCount--;
	swap(Events,1,eventCount);
	shuffleDown(Events,eventCount-1,1);
	return;
}

int compare(const void *a,const void *b)
{
	taskType *p=(taskType*)a;
	taskType *q=(taskType*)b;
	if((p->Ti) > (q->Ti))
		return 1;
	else return -1;
}

int dynamicCompare(const void *a,const void *b)
{
	taskType *p=(taskType*)a;
	taskType *q=(taskType*)b;
	if((p->Di) > (q->Di) || ((p->Di)==(q->Di) && (p->Ti)>(q->Ti)))
		return 1;
	else return -1;
}

int aperiodicPending(int apt,float presTime)
{
	int j,flag=0;
	for(j=0;j<apt;j++)
	{
		if(aptList[j].Ai<=presTime && aptList[j].compFlag==0)
			return j;
		else if(aptList[j].compFlag==0 && flag==0)
			flag=1;
	}
	if(flag!=1)
		return -2;
	return -1;
}

void organize(int pt,int apt)
{
	int i;
	for(i=0;i<=pt;i++)
		mapPeriodic[ptList[i].jobNum].jobPos=i;
	for(i=0;i<apt;i++)
		mapAperiodic[aptList[i].jobNum].jobPos=i;
}

int **createImage(int **img,int pt,int height,int width,int apt)
{
	int i=0,j=0,k=0,l=0,task,aptTask;
	for(l=0;l<sigmaCounter;l++)
	{    
		if(sigmaFunction[l].jobType==2)
			task=pt;
		else
			task=mapPeriodic[sigmaFunction[l].jobNum].jobPos;
		aptTask=mapPeriodic[sigmaFunction[l].jobNum].jobPos;
		for(i=task*100+50;i<task*100+100;i++)
		{   
			if(task==-1)
				break;
			for(j=(sigmaFunction[l].startTime)*50*3; j<(sigmaFunction[l].endTime)*50*3;j+=3)
			{   
				if(l+1==sigmaCounter)
					break;
				if(task!=pt)
				{
				img[i][j]=255/((task+1)*(task+1));
				img[i][j+1]=190/((task+1)*(task+1));
				img[i][j+2]=100/((task+1)*(task+1));
				}
				else
				{
					img[i][j]=255/(aptTask+1) + apt*apt;
					img[i][j+1]=180/(aptTask+1) + apt*apt;
					img[i][j+2]=15/(aptTask+1) +apt*apt;
				}
			}   
		}   
	}   
	for(l=0;l<pt;l++)
	{
		int period=0;
		period+=ptList[l].Ti;
		task=(mapPeriodic[ptList[l].jobNum].jobPos);
		while(period<(sigmaFunction[sigmaCounter-1].startTime))
		{
			for(i=task*100;i<task*100+100;i++)
				for(j=(period*50*3)-3;j<=period*50*3+3;j+=3)
				{
					img[i][j]=255;
					img[i][j+1]=0;
					img[i][j+2]=0;
				}
			period+=ptList[l].Ti;
		}
	}
	for(l=0;l<apt;l++)
	{
		int period=0;
		period=aptList[l].Ai;
		task=pt;
		for(i=task*100+25;i<task*100+100;i++)
			for(j=(period*50*3)-3;j<=period*50*3+3;j+=3)
			{
				img[i][j]=0;
				img[i][j+1]=255;
				img[i][j+2]=0;
			}
		period=aptList[l].compFlag;
		task=pt;
		for(i=task*100;i<task*100+100;i++)
			for(j=(period*50*3)-3;j<=period*50*3+3;j+=3)
			{
				img[i][j]=0;
				img[i][j+1]=0;
				img[i][j+2]=255;
			}
	}
	return img;
}

int analyze(int pt)
{
	int i;
	float Up=0,Us=0;
	for(i=0;i<pt+1;i++)
		Up+=(float)((ptList[i].Ci)/(ptList[i].Ti));
	Us=2*pow(((Up/pt) + 1),-1*pt) - 1;
	if(Us + Up <= 1)
		return 1;
	return 0;
}

void startNextTask(process *current,int pt,int apt,float presTime)
{
	int i,server;
	int flag=0;
	for(i=0;i<=pt;i++)
	{
		if(ptList[i].Rem!=0 && ptList[i].serverFlag==0)
		{
			(*current).jobNum = ptList[i].jobNum;
			(*current).priority = i;
			(*current).jobType = 1;
			(*current).jobPointer = i;
			(*current).startTime = presTime;
			push((presTime+ptList[i].Rem),1,ptList[i].jobNum,presTime);
			if(flag==1 && activeCount>0 && serverActive[activeCount-1].endTime==-1)
				serverActive[activeCount-1].endTime=presTime;
#if debug
			printf("Periodic Job Started: %d, Time Rem: %.2f, Time: %.2f\n",ptList[i].jobNum,ptList[i].Rem,presTime);
#endif
			break;
		}
		else if(ptList[i].serverFlag)
		{
			flag=1;
			int j;
			server=i;
			if(ptList[server].Ci==0)
				continue;
			j=aperiodicPending(apt,presTime);
			if(j!=-1 && j!=-2)
			{
				(*current).jobNum = aptList[j].jobNum;
				(*current).priority = server;
				(*current).jobType = 2;
				(*current).jobPointer = j;
				(*current).startTime = presTime;
				push((presTime+aptList[j].Rem),1,aptList[j].jobNum,presTime);
				push(presTime+ptList[server].Ci,5,ptList[server].jobNum,presTime);
				if(activeCount==0 || serverActive[activeCount-1].endTime!=-1)
				{
					serverActive[activeCount].startTime=presTime;
					serverActive[activeCount].endTime=-1;
					serverActive[activeCount].renewal=0;
					serverActive[activeCount++].refillFlag=0;
					if(choice!=2)
						push((presTime+ptList[server].Ti),4,ptList[server].jobNum,presTime);
				}
#if debug
				printf("Aperiodic Job Started: %d, Time Rem: %.2f, Time: %.2f\n",aptList[j].jobNum,aptList[j].Rem,presTime);
#endif
				break;
			}
		}
	}
	if(i>pt)
		(*current).jobType=-1;
	if(!flag)
		if(activeCount==0 || serverActive[activeCount-1].endTime!=-1)
		{
			serverActive[activeCount].startTime=presTime;
			serverActive[activeCount].endTime=-1;
			serverActive[activeCount].refillFlag=0;
			serverActive[activeCount++].renewal=-1;
			for(;i<=pt;i++)
				if(ptList[i].serverFlag)
					break;
			push((presTime+ptList[i].Ti),4,ptList[i].jobNum,presTime);
		}
	return;
}

void preempt(process *current,float presTime,int server)
{
	int i=(*current).jobPointer;
	int j=sigmaCounter;
	if((*current).jobType==-1)
		return;
	taskType * temp=aptList;
	if((*current).jobType==1)
		temp=ptList;
	if((*current).jobType==2)
	{
		if(serverActive[activeCount-1].renewal==-1)
			serverActive[activeCount-1].renewal=0;
		serverActive[activeCount-1].renewal+=(presTime-(*current).startTime);
		ptList[server].Ci-=presTime-(*current).startTime;
	}
	temp[i].Rem=temp[i].Rem-(presTime-(*current).startTime);
	if(temp[i].Rem==0.0 && (*current).jobType==2)
		temp[i].compFlag=presTime;
	if(j!=0 && sigmaFunction[j-1].jobNum==temp[i].jobNum && sigmaFunction[j-1].jobType==(*current).jobType && temp[i].Rem!=0.0)
	{
		sigmaCounter--;
		j--;
	}
	else
		sigmaFunction[j].startTime=(*current).startTime;
	sigmaFunction[j].jobType=(*current).jobType;
	sigmaFunction[j].jobNum=temp[i].jobNum;
	sigmaFunction[j].endTime=presTime;
	sigmaCounter++;
	(*current).jobType=-1;
#if debug
	printf("Job Preempted: %d, Time Rem: %.2f, Time: %.2f\n",i,temp[i].Rem,presTime);
#endif
	return;
}

void execute(int pt,int apt,int server)
{
	float presTime=sigmaCounter=0;
	int serverNum=ptList[server].jobNum;
	process current;
	startNextTask(&current,pt,apt,presTime);
	while(eventCount!=1 ) 
	{
		int i=Events[1].eventSrc,serverRefill=0;
		presTime=Events[1].time;
		for(serverRefill=0;serverRefill<activeCount;serverRefill++)
		{
			if(serverActive[serverRefill].refillFlag!=0)
				continue;
			break;
		}
		if(aperiodicPending(apt,presTime)==-2 && serverRefill==activeCount)
			break;
		if(Events[1].eventName==1)
		{
			if(Events[1].eventSrc==current.jobNum && Events[1].creatTime==current.startTime)
			{
#if debug
				printf("Job Completion: Time = %f; Src = %d; JobType = %d\n",Events[1].time,Events[1].eventSrc,current.jobType);
#endif
				preempt(&current,presTime,server);
				startNextTask(&current,pt,apt,presTime);
			}
		}
		else if(Events[1].eventName==2)
		{
			i=mapPeriodic[i].jobPos;
#if debug
			printf("Job Time Period Renew: Time = %f; Src = %d;\n",Events[1].time,Events[1].eventSrc);
#endif
			if(ptList[i].Rem!=0)
			{
				printf("Deadline Miss. Unfeasible Task Set\n");
				exit(0);
			}
			ptList[i].Rem=ptList[i].Ci;
			ptList[i].Di=ptList[i].Ti+presTime;
			push(presTime+ptList[i].Ti,2,ptList[i].jobNum,presTime);
			if(choice==2)
			{
				i=ptList[i].jobNum;
				qsort(ptList,pt+1,sizeof(taskType),dynamicCompare);
				organize(pt,apt);
				server=mapPeriodic[serverNum].jobPos;
				if(current.jobType!=-1)
				{
					if(current.jobType==1)
					{
						current.jobPointer=mapPeriodic[current.jobNum].jobPos;
						current.priority=current.jobPointer;
					}
					else if(current.jobType==2)
					{
						current.jobPointer=mapAperiodic[current.jobNum].jobPos;
						current.priority=server;
					}
				}
				i=mapPeriodic[i].jobPos;
			}
			if(current.priority>i || current.jobType==-1)
			{
				preempt(&current,presTime,server);
				startNextTask(&current,pt,apt,presTime);
			}
		}
		else if(Events[1].eventName==3)
		{
#if debug
			printf("Aperiodic Job Arrival: Time = %.2f, Src = %d\n",Events[1].time,Events[1].eventSrc);
#endif
			if(choice==2)
			{
				if(ptList[server].Ci!=0)
				{
					ptList[server].Di=presTime+(ptList[server].Ti);
					push((presTime+ptList[server].Ti),4,ptList[server].jobNum,presTime);
					qsort(ptList,pt+1,sizeof(taskType),dynamicCompare);
					organize(pt,apt);
					server=mapPeriodic[serverNum].jobPos;
					if(current.jobType!=-1)
					{
						if(current.jobType==1)
						{
							current.jobPointer=mapPeriodic[current.jobNum].jobPos;
							current.priority=current.jobPointer;
						}
						else if(current.jobType==2)
						{
							current.jobPointer=mapAperiodic[current.jobNum].jobPos;
							current.priority=server;
						}
					}
				}
			}
			if((ptList[server].Ci!=0 && current.priority > server && current.jobType!=2) || current.jobType==-1)
			{
				preempt(&current,presTime,server);
				startNextTask(&current,pt,apt,presTime);
			}
		}
		else if(Events[1].eventName==4)
		{
			int j;
			for(j=0;j<activeCount;j++)
			{
				if(serverActive[j].refillFlag!=0)
					continue;
				serverActive[j].refillFlag=1;
				if(serverActive[j].renewal==-1)
					serverActive[j].renewal=0;
				ptList[server].Ci+=serverActive[j].renewal;
#if debug
				printf("Server Refill: Time = %f; Src = %d; Amt = %.2f;\n",Events[1].time,Events[1].eventSrc,serverActive[j].renewal);
#endif
				break;
			}
			if(choice==2)
			{
				j=aperiodicPending(apt,presTime);
				if(ptList[server].Ci!=0 && j!=-1 && j!=-2)
				{
					ptList[server].Di=presTime+(ptList[server].Ti);
					push((presTime+ptList[server].Ti),4,ptList[server].jobNum,presTime);
					qsort(ptList,pt+1,sizeof(taskType),dynamicCompare);
					organize(pt,apt);
					server=mapPeriodic[serverNum].jobPos;
					if(current.jobType!=-1)
					{
						if(current.jobType==1)
						{
							current.jobPointer=mapPeriodic[current.jobNum].jobPos;
							current.priority=current.jobPointer;
						}
						else if(current.jobType==2)
						{
							current.jobPointer=mapAperiodic[current.jobNum].jobPos;
							current.priority=server;
						}
					}
				}
			}
			if((current.priority > server && current.jobType!=2) || current.jobType==-1)
			{
				preempt(&current,presTime,server);
				startNextTask(&current,pt,apt,presTime);
			}
		}
		else if(Events[1].eventName==5)
		{
			if(ptList[server].Ci==(presTime-Events[1].creatTime) && current.jobType==2 && current.startTime==Events[1].creatTime)
			{
#if debug
				printf("Server Exhausted: Time = %f; Src = %d;\n",Events[1].time,Events[1].eventSrc);
#endif
				preempt(&current,presTime,server);
				startNextTask(&current,pt,apt,presTime);
				ptList[server].Ci=0;
			}
		}
		pop();
	}
}

int main()
{
	int i,pt,apt,server;
	printf("Select the Server: \n1)Fixed Priority Sporadic Server\n2)Dynamic Priority Sporadic Server\n");
	scanf("%d",&choice);
	if(choice!=1 && choice!=2)
	{
		printf("Invalid Choice\n");
		return 0;
	}
	printf("Enter number of periodic task : ");
	scanf("%d",&pt);
	printf("\nEnter number of aperiodic task : ");
	scanf("%d",&apt);
	printf("\n");

	ptList = (taskType *)malloc((pt+1)*sizeof(taskType));
	aptList = (taskType *)malloc(apt*sizeof(taskType));

	mapPeriodic = (mapType *)malloc((pt+1)*sizeof(mapType));
	mapAperiodic = (mapType *)malloc(apt*sizeof(mapType));

	Events = (eventType *)malloc(100*sizeof(eventType));
	eventCount=1;

	serverActive = (serverType *)malloc(100*sizeof(serverType));
	activeCount=0;

	for(i=0;i<pt;i++)
	{
		printf("Periodic(Ti, Ci)\n");
		scanf("%f%f",&ptList[i].Ti,&ptList[i].Ci);
		ptList[i].Rem=ptList[i].Ci;
		ptList[i].serverFlag=0;		
		ptList[i].Di=ptList[i].Ti;
		if(ptList[i].Ti < ptList[i].Ci)
		{
			printf("Unfeasible Task set\n");
			exit(0);
		}
	}
	for(i=0;i<apt;i++)
	{
		printf("Aperiodic(Ci, Ai)\n");
		scanf("%f%f",&aptList[i].Ci,&aptList[i].Ai);
		aptList[i].Rem=aptList[i].Ci;
		aptList[i].Ti=aptList[i].Ai;
	}
	printf("Server(Ts, Cs)\n");
	scanf("%f%f",&ptList[pt].Ti,&ptList[pt].Ci);
	ptList[pt].serverFlag=1;
	if(!analyze(pt))
	{
		printf("Infeasible Task Set\n");
		exit(0);
	}
	qsort(ptList,pt+1,sizeof(taskType),compare);
	qsort(aptList,apt,sizeof(taskType),compare);

	for(i=0;i<pt+1;i++)
	{
		ptList[i].jobNum=i;
		mapPeriodic[i].jobNum=mapPeriodic[i].jobPos=i;
		if(ptList[i].serverFlag)
		{
			server=i;
			continue;
		}
		Events[eventCount].creatTime=0;
		Events[eventCount].time=ptList[i].Ti;
		Events[eventCount].eventName=2;
		Events[eventCount++].eventSrc=i;
	}
	for(i=0;i<apt;i++)
	{
		Events[eventCount].creatTime=0;
		Events[eventCount].time=aptList[i].Ai;
		Events[eventCount].eventName=3;
		Events[eventCount++].eventSrc=i;
		aptList[i].compFlag=0;
		aptList[i].jobNum=i;
		mapAperiodic[i].jobNum=mapAperiodic[i].jobPos=i;
	}
	heapify(Events,eventCount-1);
	int serverNum=ptList[server].jobNum;
	if(choice==2)
	{
		if(ptList[server].Ci!=0 && aperiodicPending(apt,0.0)>=0)       /////////////NEEDS TESTING
		{
			ptList[server].Di=0.0+(ptList[server].Ti);
			qsort(ptList,pt+1,sizeof(taskType),dynamicCompare);
			organize(pt,apt);
			server=mapPeriodic[server].jobPos;
		}
	}
	execute(pt,apt,server);
	system("clear");
	FILE *fp=fopen("gnuPlotFile","w");
	float lastTime=0;
	ptList[mapPeriodic[serverNum].jobPos].Ti=INT_MAX;
	qsort(ptList,pt+1,sizeof(taskType),compare);
	organize(pt,apt);
	int lastJob=sigmaFunction[0].jobNum;
	lastJob=mapPeriodic[lastJob].jobPos;
	for(i=0;i<sigmaCounter;i++)
	{
		int currentJob=mapPeriodic[sigmaFunction[i].jobNum].jobPos;
		if(i>0 && sigmaFunction[i-1].endTime!=sigmaFunction[i].startTime)
		{
			fprintf(fp,"%.2f	%d\n",sigmaFunction[i-1].endTime,lastJob+1);
			fprintf(fp,"%.2f	%d\n",sigmaFunction[i-1].endTime,0);
			lastJob=-1;
		}
		fprintf(fp,"%.2f	%d\n",sigmaFunction[i].startTime,lastJob+1);
		if(sigmaFunction[i].jobType==1)
		{
			printf("From %.2f To %.2f, Periodic Job Num %d executed\n",sigmaFunction[i].startTime,sigmaFunction[i].endTime,sigmaFunction[i].jobNum);
			fprintf(fp,"%.2f	%d\n",sigmaFunction[i].startTime,currentJob+1);
			lastJob=currentJob;
		}
		if(sigmaFunction[i].jobType==2)
		{
			printf("From %.2f To %.2f, Aperiodic Job Num %d executed\n",sigmaFunction[i].startTime,sigmaFunction[i].endTime,sigmaFunction[i].jobNum);
			fprintf(fp,"%.2f	%d\n",sigmaFunction[i].startTime,pt+1);
			lastJob=pt;
		}
	}
	fclose(fp);


	int j;
	int height=(pt+1)*100,width=50*(sigmaFunction[sigmaCounter-1].startTime);
	int **imageMat=(int **)malloc(sizeof(int *)*height);
	for(i=0;i<(pt+1)*100;i++)
		imageMat[i]=(int *)malloc(sizeof(int)*3*width);
	for(i=0;i<height;i++)
		for(j=0;j<3*width;j+=3)
		{
			if(i%100==0)
				imageMat[i][j]=imageMat[i][j+1]=imageMat[i][j+2]=0;
			else
			{   
				if(i%50==0 || j%50==0)
					imageMat[i][j]=imageMat[i][j+1]=imageMat[i][j+2]=200;
				else
					imageMat[i][j]=imageMat[i][j+1]=imageMat[i][j+2]=255;
			}   
		}
	imageMat=createImage(imageMat,pt,height,width,apt);
	free(ptList);
	free(aptList);
	FILE *fp1=fopen("scheduling.ppm","w");
	fprintf(fp1,"P3\n%d %d\n255\n",width,height);
	for(j=0;j<height;j++)
	{
		for(i=0;i<width*3;i+=3)
			fprintf(fp1,"%d %d %d\t",imageMat[j][i],imageMat[j][i+1],imageMat[j][i+2]);
		fprintf(fp1,"\n");
	}
	fclose(fp1);

	FILE *pipe = popen("gnuplot -persist","w");
	fprintf(pipe, "set xrange [0.000:%.4f]\n",sigmaFunction[sigmaCounter-1].endTime+5.0);
	fprintf(pipe, "set yrange [0:%d]\n",pt+1+5);
	fprintf(pipe, "set terminal png\n");
	fprintf(pipe, "set output 'graph.png'\n");
	fprintf(pipe, "set title 'We are plotting from C'\n");
	fprintf(pipe, "set xlabel 'Time'\n");
	fprintf(pipe, "set ylabel 'Tasks & Server=%d'\n",pt+1);
	 fprintf(pipe, "plot 'gnuPlotFile' using 1:2 with linespoints\n");
	 fclose(pipe);
	for(i=0;i<(pt+1)*100;i++)
		free(imageMat[i]);
	free(imageMat);

	mapPeriodic = (mapType *)malloc((pt+1)*sizeof(mapType));
	mapAperiodic = (mapType *)malloc(apt*sizeof(mapType));

	Events = (eventType *)malloc(100*sizeof(eventType));
	eventCount=1;

	serverActive = (serverType *)malloc(100*sizeof(serverType));
	return 0;	
}
