#include <string.h>
#include <arpa/inet.h>
#include <stdio.h>
#include <stdlib.h>

#define MYPORT 12345
#define MY_IP "172.22.14.228"
#define A 0.875
#define B 2

void fatal(char *string)
{
	printf("%s\n",string);
	exit(1);
}

int main(int argc, char *argv[])
{
	int sockfd,sockfd2,counter=0,flag=0;
	char tosend[64]={'s'};			/* (64byte) to send to receivers */
	char ack[64];					/* (64byte) acknowledgement packets */
	struct sockaddr_in my_addr,rcvr_addr;
	struct timeval start,end,sendpacket,receive,temp;
	int sin_size = sizeof(my_addr),i,k,num_packet_sent,optval;
	double t1,t2,t5,t6,rtt,temp1;

	double srtt=0,s,rto=0.3;

	if( (sockfd = socket(PF_INET, SOCK_STREAM, IPPROTO_TCP)) ==-1)
	{
		fatal("socket error");
 	}
 
	my_addr.sin_family = AF_INET;
        my_addr.sin_port = htons(MYPORT);
 	my_addr.sin_addr.s_addr = inet_addr(MY_IP);
 	memset(my_addr.sin_zero, '\0', sizeof(my_addr.sin_zero));
 	//allow reuse of port
 	optval = 1;
 	if (setsockopt(sockfd,SOL_SOCKET,SO_REUSEADDR,&optval,sizeof(int)) == -1) 
	{
  		fatal("setsockopt");
 	}
	//bind(socketfd, struct about my address,sizeofmy address);
 	if (bind(sockfd, (struct sockaddr *)&my_addr, sizeof my_addr) == -1)
	{
		fatal("bind");
	}
	//allowing 10 clients for connection
	listen(sockfd,10);
		
    	sockfd2 = accept(sockfd, (struct sockaddr *)&rcvr_addr, &sin_size);
	gettimeofday(&start,NULL);
 	//connections OK
 	//send 100 packet of size 1 byte and for each send wait for ack

	t1=0.0; 
	t2=0.0;
 	printf("Sending 100 messages 64 byte each and wait for ack.\n");

 	for(num_packet_sent=0;num_packet_sent<100;num_packet_sent++)
	{
		//sprintf(tosend,"%d",num_packet_sent);
		flag=0;
		if(gettimeofday(&sendpacket,NULL))
		{
			fatal("time failed\n");
        	}
		
		send(sockfd2,&tosend,sizeof(tosend),0);
		t2 = sendpacket.tv_sec+(sendpacket.tv_usec/1000000.0);
		gettimeofday(&temp,NULL);
		temp1 = temp.tv_sec+(temp.tv_usec/1000000.0);
		
		if(temp1-t2>rto)
		{
			flag=1;
			counter++;
			//printf("1).Retransmitting packet:TIMEOUT\n");
			//send(sockfd2,&tosend,sizeof(tosend),0);
		}
			
		optval=recv(sockfd2,&ack,sizeof(tosend),0);
		
	
		
		if(optval==-1)
		{
			flag=1;
			counter++;
			//printf("2).Retransmitting packet");
			//send(sockfd2,&tosend,sizeof(tosend),0);
			//optval=recv(sockfd2,&ack,sizeof(tosend),0);
				
			//fatal("Receive error");
		}
		//else
		//{
			if(gettimeofday(&receive,NULL))
			{
				fatal("time failed\n");
			}
            		
            		t1 = start.tv_sec+(start.tv_usec/1000000.0);
		    	
            		t5 = receive.tv_sec+(receive.tv_usec/1000000.0);
			rtt = (t5-t2)*1000.0;
			if(rtt>rto)
			{
				flag=1;			
				counter++;
				//printf("3).Retransmitting packet:TIMEOUT\n");
				//send(sockfd2,&tosend,sizeof(tosend),0);
				//optval=recv(sockfd2,&ack,sizeof(tosend),0);
			}
			printf("%d\n",num_packet_sent);
			printf("RTT = %f ms\n",rtt);
			if(flag==0)
			{
				s = rtt;
				if(num_packet_sent == 0)
				srtt = s;

				srtt = (A*srtt) + (1-A)*s;
				rto = B*srtt;
			}
			else
			{
				rto=rto*2;
			}
			
			printf("SRTT = %f ms\n",srtt);
			printf("RTO = %f ms\n",rto); 
			//printf("\n%d",num_packet_sent);
	            	gettimeofday(&end,NULL);			//time at which connection is closed
	    		t6 = end.tv_sec+(end.tv_usec/1000000.0);

			printf("\nTime at which connection was established, T1 = %f",t1);
			printf("\nTime at which segments were send, T2 = %f",t2);
			printf("\nTime at which Acknowledgements were received, T5 = %f",t5);
			printf("\nTime at which connection was closed, T6 = %f",t6);
			printf("\nThe number of retransmissions=%d\n",counter);	
			printf("\n");
	
			if(flag!=0)
			{
			printf("Retransmitting Packet:TIMEOUT");
			num_packet_sent--;	
			}

	}

 	
	

	printf("close sockets and exit\n");
 	shutdown(sockfd2,2);
 	shutdown(sockfd,2);
 	
	exit(0);
}




