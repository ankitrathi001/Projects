#include <string.h>
#include <arpa/inet.h>
#include <stdio.h>
#include <stdlib.h>

#define MYPORT 12345									/* Port number */
#define MY_IP "115.248.220.206"								/* Server's IP Address */
#define A 0.875										/* Value of alpha */
#define B 2										/* Value of beta (in algorithm) */
#define H 0.75

void fatal(char *string)								/* function to print error message */
{
	printf("%s\n",string);
	exit(1);
}

int main(int argc, char *argv[])
{
	struct sockaddr_in my_addr,rcvr_addr;
	struct timeval start,end,sendpacket,receive,temp;

	int sockfd,sockfd2;
	int counter=0,flag=0;
	int sin_size = sizeof(my_addr),i,k,num_packet_sent,optval;
	
	char tosend[1200] = {'s'};							/* (1200 byte) segment to send to the client */
	char ack[1200];									/* (1200 byte) acknowledgement packets received from the client */
		
	double t1,t2,t5,t6,rtt,temp1,err,variation=0;
	double srtt=0,s,rto=0.3;

	if( (sockfd = socket(PF_INET, SOCK_STREAM, IPPROTO_TCP)) == -1)
	{
		fatal("socket error");
 	}
 
	my_addr.sin_family = AF_INET;
        my_addr.sin_port = htons(MYPORT);
 	my_addr.sin_addr.s_addr = inet_addr(MY_IP);
 	memset(my_addr.sin_zero, '\0', sizeof(my_addr.sin_zero));
 	
	optval = 1;									/* allow reuse of port */
 	if (setsockopt(sockfd,SOL_SOCKET,SO_REUSEADDR,&optval,sizeof(int)) == -1) 
	{
  		fatal("setsockopt");
 	}
	
	if (bind(sockfd, (struct sockaddr *)&my_addr, sizeof my_addr) == -1)		/* bind(socketfd, struct about my address,sizeof my address) */
	{										/* to register its IP address */
		fatal("bind error");
	}
	
	listen(sockfd,10);								/* allowing 10 clients for connection */	
    	sockfd2 = accept(sockfd, (struct sockaddr *)&rcvr_addr, &sin_size);		/* connections OK */
	gettimeofday(&start,NULL);							/* time at which connection was established */
 	
	/* sending 1500 packets of size 1200 bytes and for each send wait for ack */

	t1=0.0; 
	t2=0.0;

 	for(num_packet_sent=0;num_packet_sent<1500;num_packet_sent++)
	{
		flag=0;									/* to check for retransmissions and TIMEOUT */
		if(gettimeofday(&sendpacket,NULL))					/* time at which packet sending was started */
		{
			fatal("time failed\n");
        	}
		
		send(sockfd2,&tosend,sizeof(tosend),0);
		t2 = sendpacket.tv_sec+(sendpacket.tv_usec/1000000.0);
		gettimeofday(&temp,NULL);						/* Time just before the acknowledgement is reached */
		temp1 = temp.tv_sec+(temp.tv_usec/1000000.0);
		
		if(temp1-t2>rto)							/* condition for retransmission */
		{
			counter++;
			flag=1;
		}
			
		optval=recv(sockfd2,&ack,sizeof(tosend),0);
		while(optval==-1)
		{
			flag=1;
			optval=recv(sockfd2,&ack,sizeof(tosend),0);
		}
		
		if(gettimeofday(&receive,NULL))						/* time at which acknowledgement reached */
		{
			fatal("time failed\n");
		}
            		
            	t1 = start.tv_sec+(start.tv_usec/1000000.0);
            	t5 = receive.tv_sec+(receive.tv_usec/1000000.0);
		rtt = (t5-t2)*1000.0;
			
		if(rtt>rto)								/* condition for retransmission */
		{
			counter++;
			flag=1;
		}
			
		printf("%d,",num_packet_sent);
		printf("%f,",rtt);
		s = rtt;

		if(num_packet_sent == 0)
		srtt = s;								/* initial SRTT i.e. SRTT(0) = RTT */

		srtt = (A*srtt) + (1-A)*s;						/* Jacobson's algorithm */
		err = rtt-srtt;
			
		if(err<0)
		err=err*(-1);
			
		variation = H*variation + (1-H)*err;
		rto= srtt + 3*variation;		
			
		printf("%f,",srtt);
		printf("%f,",rto); 
			
	        gettimeofday(&end,NULL);						/* time at which connection is closed */
	    	t6 = end.tv_sec+(end.tv_usec/1000000.0);

		printf("%f,",t1);
		printf("%f,",t2);
		printf("%f,",t5);
		printf("%f,",t6);
		printf("%d,",counter);
		printf("\n");

		if(flag!=0)
		{
			num_packet_sent--;
		}
	}

	shutdown(sockfd2,2);
 	shutdown(sockfd,2);
	exit(0);
}
